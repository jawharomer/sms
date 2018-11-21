package com.joh.sms.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.joh.sms.model.WebSite;

public interface WebSiteService {

	WebSite findWebSite();

	WebSite update(WebSite webSite);

	void addCarouselFile(MultipartFile file) throws IOException;

	void deleteCarouselFile(int id) throws IOException;

	void addAlbumFile(MultipartFile file) throws IOException;

	void deleteAlbumFile(int id) throws IOException;

}
