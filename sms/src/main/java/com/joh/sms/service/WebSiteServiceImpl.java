package com.joh.sms.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.joh.sms.dao.WebSiteDAO;
import com.joh.sms.exception.CusDataIntegrityViolationException;
import com.joh.sms.model.AttachedFile;
import com.joh.sms.model.WebSite;

@Service
public class WebSiteServiceImpl implements WebSiteService {

	@Autowired
	private WebSiteDAO webSiteDAO;

	@Autowired
	private AttachedFileService attachedFileService;

	@Override
	public WebSite findWebSite() {
		return webSiteDAO.findFirstByOrderById();
	}

	@Override
	public WebSite update(WebSite webSite) {
		WebSite findOne = webSiteDAO.findOne(webSite.getId());
		if (findOne == null) {
			throw new CusDataIntegrityViolationException("وێبسایتەکە بەتالە");
		}
		// Prevent Direct update
		webSite.setCarouselFiles(findOne.getCarouselFiles());
		webSite.setAlbumFiles(findOne.getAlbumFiles());
		return webSiteDAO.save(webSite);
	}

	@Transactional
	@Override
	public void addCarouselFile(MultipartFile file) throws IOException {
		AttachedFile attachedFile = attachedFileService.save(file);
		WebSite webSite = webSiteDAO.findFirstByOrderById();
		webSite.getCarouselFiles().add(attachedFile);
		webSiteDAO.save(webSite);
	}

	@Transactional
	@Override
	public void deleteCarouselFile(int id) throws IOException {
		AttachedFile attachedFile = attachedFileService.findOne(id);
		attachedFileService.delete(attachedFile);
		WebSite webSite = webSiteDAO.findFirstByOrderById();
		webSite.getCarouselFiles().removeIf(i -> {
			if (i.getId() == id) {
				return true;
			} else {
				return false;
			}
		});
		webSiteDAO.save(webSite);
	}

	@Transactional
	@Override
	public void addAlbumFile(MultipartFile file) throws IOException {
		AttachedFile attachedFile = attachedFileService.save(file);
		WebSite webSite = webSiteDAO.findFirstByOrderById();
		webSite.getAlbumFiles().add(attachedFile);
		webSiteDAO.save(webSite);
	}

	@Transactional
	@Override
	public void deleteAlbumFile(int id) throws IOException {
		AttachedFile attachedFile = attachedFileService.findOne(id);
		attachedFileService.delete(attachedFile);
		WebSite webSite = webSiteDAO.findFirstByOrderById();
		webSite.getAlbumFiles().removeIf(i -> {
			if (i.getId() == id) {
				return true;
			} else {
				return false;
			}
		});
		webSiteDAO.save(webSite);
	}

}
