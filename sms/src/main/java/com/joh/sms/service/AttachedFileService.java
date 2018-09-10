package com.joh.sms.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.joh.sms.exception.AttachmentNotFoundException;
import com.joh.sms.model.AttachedFile;

public interface AttachedFileService {

	AttachedFile save(MultipartFile multipartFile) throws IOException;

	void delete(AttachedFile attachedFile);

	byte[] getAttachentFile(int id) throws AttachmentNotFoundException;

	AttachedFile findOne(int id);


	byte[] getAttachedFileSmall(int id) throws AttachmentNotFoundException;

}
