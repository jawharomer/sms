package com.joh.sms.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joh.sms.model.Enrollment;
import com.joh.sms.model.EnrollmentPayment;
import com.joh.sms.service.EnrollmentPaymentService;
import com.joh.sms.service.EnrollmentService;

@Controller()
@RequestMapping(path = "/enrollmentPayments")
public class EnrollmentPaymentController {

	private static final Logger logger = Logger.getLogger(EnrollmentPaymentController.class);

	@Autowired
	private EnrollmentPaymentService enrollmentPaymentService;

	@Autowired
	private EnrollmentService enrollmentService;

	@GetMapping(path = "/enrollment/{id}")
	public String getAllEnrollmentPayment(@PathVariable int id, Model model) {
		logger.info("getAllEnrollmentPayment->fired");
		logger.info("enrollmentId=" + id);
		model.addAttribute("enrollmentId", id);
		Enrollment enrolllment = enrollmentService.findOne(id);
		logger.info("enrolllment=" + enrolllment);
		Iterable<EnrollmentPayment> enrollmentPayments = enrollmentPaymentService.findByEnrollmentId(id);
		logger.info("enrollmentPayments=" + enrollmentPayments);
		model.addAttribute("enrollmentPayments", enrollmentPayments);
		model.addAttribute("enrolllment", enrolllment);
		return "enrollmentPayments";
	}

	@GetMapping(path = "/add/{id}")
	public String getAddingEnrollmentPayment(@PathVariable int id, Model model) {
		logger.info("getAddingEnrollmentPayment->fired");
		EnrollmentPayment enrollmentPayment = new EnrollmentPayment();
		model.addAttribute("enrollmentId", id);
		model.addAttribute("enrollmentPayment", enrollmentPayment);
		return "enrollmentPayment/addEnrollmentPayment";
	}

	@PostMapping(path = "/add/{id}")
	public String addEnrollmentPayment(@PathVariable int id, @RequestBody @Valid EnrollmentPayment enrollmentPayment,
			BindingResult result, Model model) {
		logger.info("addEnrollmentPayment->fired");
		logger.info("enrollmentPayment=" + enrollmentPayment);

		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("enrollmentId", id);

			model.addAttribute("enrollmentPayment", enrollmentPayment);
			return "enrollmentPayment/addEnrollmentPayment";
		} else {
			Enrollment enrollment = new Enrollment();
			enrollment.setId(id);
			enrollmentPayment.setEnrollment(enrollment);

			enrollmentPaymentService.save(enrollmentPayment);
			return "success";
		}
	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public String deleteEnrollmentPayment(@PathVariable int id) {
		logger.info("deleteEnrollmentPayment->fired");
		logger.info("id=" + id);
		enrollmentPaymentService.delete(id);
		return "success";
	}

	@GetMapping(path = "/edit/{id}")
	public String getEditingEnrollmentPayment(@PathVariable int id, Model model) {
		logger.info("getEditingEnrollmentPayment->fired");

		EnrollmentPayment enrollmentPayment = enrollmentPaymentService.findOne(id);

		logger.info("enrollmentPayment=" + enrollmentPayment);
		model.addAttribute("enrollmentPayment", enrollmentPayment);
		return "enrollmentPayment/editEnrollmentPayment";
	}

	@PostMapping(path = "/edit/{id}")
	public String updateEnrollmentPayment(@PathVariable int id, @RequestBody @Valid EnrollmentPayment enrollmentPayment,
			BindingResult result, Model model) {
		logger.info("updateEnrollmentPayment->fired");
		logger.info("enrollmentPaymentId=" + id);

		enrollmentPayment.setId(id);

		logger.info("error=" + result.getAllErrors());
		if (result.hasErrors()) {
			model.addAttribute("enrollmentPayment", enrollmentPayment);
			return "enrollmentPayment/editEnrollmentPayment";
		} else {
			enrollmentPaymentService.update(enrollmentPayment);
			return "success";
		}

	}

}
