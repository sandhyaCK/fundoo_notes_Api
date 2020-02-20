package com.bridgelabz.fundoonotes.service;

import org.springframework.context.annotation.Profile;
import org.springframework.web.multipart.MultipartFile;

public interface ProfilePicService {
	Profile storeObjectInS3(MultipartFile file, String fileName, String contentType, String token);

	S3Object fetchobject(String awsFileName);

	void deleteobject(String key);

	Profile update(MultipartFile file, String originalFilename, String contentType, String token);

	S3Object getProfilePic(String token);
}
