package com.bridgelabz.fundoonotes.implementation;
import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.bridgelabz.fundoonotes.model.ProfilePic;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.ProfilePicRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;

import com.bridgelabz.fundoonotes.service.ProfilePicService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
public class ProfilePicServiceImplementation implements ProfilePicService {

	@Override
	public Profile storeObjectInS3(MultipartFile file, String fileName, String contentType, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public S3Object fetchobject(String awsFileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteobject(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profile update(MultipartFile file, String originalFilename, String contentType, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public S3Object getProfilePic(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
