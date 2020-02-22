package com.bridgelabz.fundoonotes.implementation;
import java.io.File;
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
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.bridgelabz.fundoonotes.model.ProfilePic;
import com.bridgelabz.fundoonotes.model.UserInformation;
import com.bridgelabz.fundoonotes.repository.ProfilePicRepository;
import com.bridgelabz.fundoonotes.repository.UserRepository;

import com.bridgelabz.fundoonotes.service.ProfilePicService;
import com.bridgelabz.fundoonotes.utility.JwtGenerator;
@Service
public class ProfilePicServiceImplementation implements ProfilePicService {

	@Override
	///public Profile uploadFileTos3Bucket(MultipartFile file, String fileName, String bucketName, String token) {
		s3client.putObject(new PutObjectRequest(bucketName, fileName, (File) file)
	            .withCannedAcl(CannedAccessControlList.PublicRead));
		return null;
	}

	@Override
	public S3Object downloadFileFromS3Buckest(String awsFileName,String bucketName) {
		S3Object object = AmazonS3Client.
		return object;
	}

	@Override
	public void deleteobjectFromS3Object(String awsFileName, String bucketName) {
		// TODO Auto-generated method stub
		
	}

	
}*/
