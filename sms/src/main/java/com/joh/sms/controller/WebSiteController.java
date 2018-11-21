package com.joh.sms.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.joh.sms.exception.CusDataIntegrityViolationException;
import com.joh.sms.model.AttachedFile;
import com.joh.sms.model.Student;
import com.joh.sms.model.WebSite;
import com.joh.sms.service.AttachedFileService;
import com.joh.sms.service.WebSiteService;

@Controller()

public class WebSiteController {
	private static final Logger logger = Logger.getLogger(WebSiteController.class);

	@Autowired
	private WebSiteService webSiteService;

	@RequestMapping(path = "/")
	public String getWebSiteRoot(Model model) {
		logger.info("getWebSiteRoot->fired");
		WebSite webSite = webSiteService.findWebSite();
		logger.info("webSite=" + webSite);

		model.addAttribute("webSite", webSite);

		return "webSiteRoot";
	}

	@GetMapping(path = "/webSite/edit")
	public String getEditingWebSite(Model model) {
		logger.info("getEditingWebSite->fired");
		WebSite webSite = webSiteService.findWebSite();
		logger.info("webSite=" + webSite);

		model.addAttribute("webSite", webSite);

		return "editWebSite";
	}

	@PostMapping(path = "/webSite/update")
	public String updateWebSite(@RequestBody WebSite webSite, Model model) {
		logger.info("updateWebSite->fired");
		logger.info("webSite=" + webSite);

		model.addAttribute("webSite", webSite);

		webSiteService.update(webSite);

		return "success";
	}

	@PostMapping(path = "/webSite/files/add/coursel")
	public String addCarouselFile(@RequestParam MultipartFile file, Model model) throws IOException {
		logger.info("addCarouselFile->fired");
		logger.info("FileName=" + file.getOriginalFilename());
		if (!file.isEmpty()) {
			BufferedImage image = ImageIO.read(file.getInputStream());
			Integer width = image.getWidth();
			Integer height = image.getHeight();

			logger.info("image width=" + width);
			logger.info("image heigth=" + height);

			if (width != 800 && height != 600) {
				String message = String.format("(%dx%d) وێنەکە دەبێت پانوی بەرزی (800-600) تەواو بێت", width, height);
				throw new CusDataIntegrityViolationException(message);
			}

			webSiteService.addCarouselFile(file);

		}
		return "redirect:/webSite/edit";
	}

	@PostMapping(path = "/webSite/files/delete/coursel/{id}")
	public String deleteCarouselFile(@PathVariable int id) throws IOException {
		logger.info("deleteCarouselFile->fired");
		logger.info("id=" + id);

		webSiteService.deleteCarouselFile(id);

		return "success";
	}

	@PostMapping(path = "/webSite/files/add/album")
	public String addAlbumFile(@RequestParam MultipartFile file, Model model) throws IOException {
		logger.info("addAlbumFile->fired");
		logger.info("FileName=" + file.getOriginalFilename());
		if (!file.isEmpty()) {
			BufferedImage image = ImageIO.read(file.getInputStream());
			Integer width = image.getWidth();
			Integer height = image.getHeight();

			logger.info("image width=" + width);
			logger.info("image heigth=" + height);

			if (width != 800 && height != 600) {
				String message = String.format("(%dx%d) وێنەکە دەبێت پانوی بەرزی (800-600) تەواو بێت", width, height);
				throw new CusDataIntegrityViolationException(message);
			}

			webSiteService.addAlbumFile(file);

		}
		return "redirect:/webSite/edit";
	}

	@PostMapping(path = "/webSite/files/delete/album/{id}")
	public String deleteAlbumFile(@PathVariable int id) throws IOException {
		logger.info("deleteAlbumFile->fired");
		logger.info("id=" + id);

		webSiteService.deleteAlbumFile(id);

		return "success";
	}

}
