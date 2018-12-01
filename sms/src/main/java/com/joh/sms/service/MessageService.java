package com.joh.sms.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.Message.MessageEncodings;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;
import org.springframework.beans.factory.annotation.Autowired;

import com.joh.sms.dao.SMSMessageDAO;
import com.joh.sms.domain.model.ModemStatus;
import com.joh.sms.model.SMSMessage;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

@org.springframework.stereotype.Service()
public class MessageService {

	@Autowired
	private SMSMessageDAO smsMessageDAO;

	@PersistenceContext
	EntityManager entityManager;

	private static final Logger logger = Logger.getLogger(MessageService.class);

	public ModemStatus getModemStatus() {
		logger.info("getModemStatus->fired");

		ModemStatus modemStatus = new ModemStatus();

		try {
			modemStatus.setSignal(getSignal());
		} catch (Exception e) {

		}

		try {
			modemStatus.setBalance(getBalance());
		} catch (Exception e) {

		}

		return modemStatus;
	}

	private static String outputHexa;

	private String getBalance() {
		logger.info("getBalance->fired");
		outputHexa = "";// reset it
		SerialPort serialPort = null;
		try {

			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(getPort());

			if (portIdentifier.isCurrentlyOwned()) {
				logger.info("Error: Port is currently in use");
			}
			CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

			serialPort = (SerialPort) commPort;

			serialPort.setSerialPortParams(19200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			logger.info("initializeing in|out");
			InputStream in = serialPort.getInputStream();
			OutputStream out = serialPort.getOutputStream();

			serialPort.notifyOnDataAvailable(true);

			byte[] buffer = new byte[1024];
			serialPort.addEventListener(e -> {
				try {
					int len = 0;
					int data;
					while ((data = in.read()) > -1) {
						if (data == '\n') {
							break;
						}
						buffer[len++] = (byte) data;
					}
					String output = new String(buffer, 0, len);
					logger.info("output=" + output);
					if (!output.isEmpty() && output.startsWith("+CUSD")) {
						outputHexa += output;
						logger.info("outputHexa=" + outputHexa);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			});

			Thread outThread = new Thread(() -> {
				try {
					logger.info("Thread Sending commands starts");
					out.write("ATD*211#;\r\n".getBytes());
					Thread.sleep(6000);
					logger.info("Thread  sending commands done");
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			outThread.start();
			outThread.join(20000);
			System.out.println("outThread->Done");
			logger.info("outputHexa=" + outputHexa);
			String toParse = outputHexa.substring(outputHexa.indexOf("\"") + 1, outputHexa.lastIndexOf("\""));
			logger.info("toParse=" + toParse);
			String result = decodeUcs2Text(hexToByte(toParse));
			logger.info("result=" + result);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("geting balace failed");
		} finally {
			if (serialPort != null)
				serialPort.close();
		}
	}

	private static String outputHexaAddBalance;

	public String addBalance(String cardNumber) {
		logger.info("addBalance->fired");
		outputHexaAddBalance = "";// reset it
		SerialPort serialPort = null;
		try {

			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(getPort());

			if (portIdentifier.isCurrentlyOwned()) {
				logger.info("Error: Port is currently in use");
			}
			CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

			serialPort = (SerialPort) commPort;

			serialPort.setSerialPortParams(19200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			logger.info("initializeing in|out");
			InputStream in = serialPort.getInputStream();
			OutputStream out = serialPort.getOutputStream();

			serialPort.notifyOnDataAvailable(true);

			byte[] buffer = new byte[1024];
			serialPort.addEventListener(e -> {
				try {
					int len = 0;
					int data;
					while ((data = in.read()) > -1) {
						if (data == '\n') {
							break;
						}
						buffer[len++] = (byte) data;
					}
					String output = new String(buffer, 0, len);
					logger.info("output=" + output);
					if (!output.isEmpty() && output.startsWith("+CUSD")) {
						outputHexaAddBalance += output;
						logger.info("outputHexaAddBalance=" + outputHexaAddBalance);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			});

			Thread outThread = new Thread(() -> {
				try {
					logger.info("Thread Sending commands starts");
					String comamnd = "ATD*221*" + cardNumber + "#;\r\n";
					logger.info("comamnd=" + comamnd);
					out.write(comamnd.getBytes());
					Thread.sleep(6000);
					logger.info("Thread  sending commands done");
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			outThread.start();
			outThread.join(20000);
			System.out.println("outThread->Done");
			logger.info("outputHexaAddBalance=" + outputHexaAddBalance);
			String toParse = outputHexaAddBalance.substring(outputHexaAddBalance.indexOf("\"") + 1,
					outputHexaAddBalance.lastIndexOf("\""));
			logger.info("toParse=" + toParse);
			String result = decodeUcs2Text(hexToByte(toParse));
			logger.info("result=" + result);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(" add balnce failed");
		} finally {
			if (serialPort != null)
				serialPort.close();
		}
	}

	private static String outputHexaSignal;

	public int getSignal() {
		logger.info("getSignal->fired");
		outputHexaSignal = "";// reset it
		SerialPort serialPort = null;
		try {

			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(getPort());

			if (portIdentifier.isCurrentlyOwned()) {
				logger.info("Error: Port is currently in use");
			}
			CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

			serialPort = (SerialPort) commPort;

			serialPort.setSerialPortParams(19200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

			logger.info("initializeing in|out");
			InputStream in = serialPort.getInputStream();
			OutputStream out = serialPort.getOutputStream();

			serialPort.notifyOnDataAvailable(true);

			byte[] buffer = new byte[1024];
			serialPort.addEventListener(e -> {
				try {
					int len = 0;
					int data;
					while ((data = in.read()) > -1) {
						if (data == '\n') {
							break;
						}
						buffer[len++] = (byte) data;
					}
					String output = new String(buffer, 0, len);
					logger.info("output=" + output);
					if (!output.isEmpty() && output.startsWith("+CSQ")) {
						outputHexaSignal += output;
						logger.info("outputHexaSignal=" + outputHexaSignal);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			});

			Thread outThread = new Thread(() -> {
				try {
					logger.info("Thread Sending commands starts");
					String comamnd = "AT+CSQ;\r\n";
					logger.info("comamnd=" + comamnd);
					out.write(comamnd.getBytes());
					Thread.sleep(3000);
					logger.info("Thread  sending commands done");
				} catch (InterruptedException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			outThread.start();
			outThread.join(20000);
			logger.info("outThread->Done");
			logger.info("outputHexaSignal=" + outputHexaSignal);
			String search = "+CSQ:";
			String result = outputHexaSignal.substring(outputHexaSignal.indexOf(search) + search.length() + 1,
					outputHexaSignal.lastIndexOf(",")).trim();
			logger.info("result=" + result);
			return Integer.parseInt(result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(" add balnce failed");
		} finally {
			if (serialPort != null)
				serialPort.close();
		}
	}

	public void starSending() {
		logger.info("starSending->fired");
		smsMessageDAO.flush();

		try {

			List<SMSMessage> smsMessages = smsMessageDAO.findAllNotSentMessages();

			logger.info("smsMessages=" + smsMessages);

			for (SMSMessage smsMessage : smsMessages) {
				logger.info("smsMessage=" + smsMessage);
				logger.info("Start sending sms");
				OutboundMessage msg = new OutboundMessage();
				msg.setEncoding(MessageEncodings.ENCUCS2);
				msg.setRecipient(smsMessage.getTo());
				msg.setText(smsMessage.getMessage());

				sendSMS(msg);
				logger.info("sms sent done");

				smsMessageDAO.messageSent(smsMessage.getId());

			}

		} catch (Exception e) {
			throw new RuntimeException("Sending sms failed");
		}
		logger.info("starSending->done");
	}

	//

	static SerialModemGateway gateway;

	static {
		try {
			initialize();
		} catch (Exception e) {
			logger.info("Initializeing Modem failed");
			e.printStackTrace();
		}
	}

	public static void initialize() throws Exception {
		logger.info("initialize->fired");
		Properties properties = System.getProperties();

		properties.setProperty("smslib.serial.polling", "true");

		OutboundNotification outboundNotification = new OutboundNotification();
		System.out.println("Example: Send message from a serial gsm modem.");
		System.out.println(Library.getLibraryDescription());
		System.out.println("Version: " + Library.getLibraryVersion());
		gateway = new SerialModemGateway("modem.com1", "/dev/ttyACM0", 19200, "SIMCOM_Ltd", "SIMCOM_SIM900");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		// gateway.setSimPin("0000");
		// Explicit SMSC address set is required for some modems.
		// Below is for VODAFONE GREECE - be sure to set your own!
		// gateway.setSmscNumber("+306942190000");
		Service.getInstance().setOutboundMessageNotification(outboundNotification);
		Service.getInstance().addGateway(gateway);
		Service.getInstance().startService();

		System.out.println();
		System.out.println("Modem Information:");
		System.out.println("  Manufacturer: " + gateway.getManufacturer());
		System.out.println("  Model: " + gateway.getModel());
		System.out.println("  Serial No: " + gateway.getSerialNo());
		System.out.println("  SIM IMSI: " + gateway.getImsi());
		System.out.println("  Signal Level: " + gateway.getSignalLevel() + " dBm");
		System.out.println("  Battery Level: " + gateway.getBatteryLevel() + "%");
		System.out.println();

		Service.getInstance().stopService();
		logger.info("initialize->done");
	}

	public static class OutboundNotification implements IOutboundMessageNotification {
		public void process(AGateway gateway, OutboundMessage msg) {
			System.out.println("Outbound handler called from Gateway: " + gateway.getGatewayId());
			System.out.println(msg);
		}
	}

	public static void sendSMS(OutboundMessage msg) throws Exception {
		logger.info("sendSMS->fired");
		Service.getInstance().startService();
		// Send a message synchronously.

		System.err.println("First Stats=" + gateway.getStatus());

		Service.getInstance().sendMessage(msg);

		System.out.println(msg);
		System.out.println("Now Sleeping - Hit <enter> to terminate.");
		// System.in.read();

		Service.getInstance().stopService();
		logger.info("sendSMS->done");
	}

	public SMSMessage saveSMS(SMSMessage smsMessage) {
		return smsMessageDAO.save(smsMessage);
	}

	public Iterable<SMSMessage> saveSMS(List<SMSMessage> smsMessages) {
		return smsMessageDAO.save(smsMessages);
	}

	/// Helper

	public byte[] hexToByte(String in) {
		int len = in.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(in.charAt(i), 16) << 4) + Character.digit(in.charAt(i + 1), 16));
		}
		return data;
	}

	public static String decodeUcs2Text(byte[] encodedText) {
		StringBuilder bob = new StringBuilder(encodedText.length >> 1);
		for (int i = 0; i < encodedText.length; i += 2) {
			char c = (char) (encodedText[i + 1] & 0xFF);
			c |= encodedText[i] << 8;
			bob.append(c);
		}
		return bob.toString();
	}

	public String getPort() {
		List<String> list = new ArrayList<>();
		Enumeration thePorts = CommPortIdentifier.getPortIdentifiers();

		while (thePorts.hasMoreElements()) {
			CommPortIdentifier com = (CommPortIdentifier) thePorts.nextElement();
			switch (com.getPortType()) {
			case CommPortIdentifier.PORT_SERIAL:

				list.add(com.getName());
			}
		}
		logger.info("all Avaiable ports=" + list);
		if (list.size() == 0) {
			throw new RuntimeException("No port Available");
		}

		return list.get(0);
	}

}
