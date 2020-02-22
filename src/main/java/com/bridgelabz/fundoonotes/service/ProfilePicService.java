package com.bridgelabz.fundoonotes.service;

import org.springframework.context.annotation.Profile;
import org.springframework.web.multipart.MultipartFile;

public interface ProfilePicService {
	Profile uploadFileTos3Bucket(MultipartFile file, String fileName,String bucketName,String token);

	S3Object downloadFileFromS3Buckest(String awsFileName,String bucketName);

	void deleteobjectFromS3Object(String awsFileName,String bucketName);


}
