package com.bridgelabz.fundoonotes.service;

/*
 *  author : Sandhya
 */

import org.springframework.web.multipart.MultipartFile;

import com.bridgelabz.fundoonotes.model.ProfilePic;

public interface ProfilePicService {
	
	public ProfilePic uploadFileTos3Bucket(MultipartFile file, String fileName, String token);

	public ProfilePic updateProfile(MultipartFile file, String originalFilename, String contentType, String token);

	public void deleteobjectFromS3Bucket(String key);

}
