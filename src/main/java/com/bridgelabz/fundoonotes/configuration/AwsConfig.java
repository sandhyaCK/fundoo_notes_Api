package com.bridgelabz.fundoonotes.configuration; 
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;


@Configuration

public class AwsConfig {

	private String awsKeyId= System.getenv("AccessKeyId");

	private String acessKey=System.getenv("SecretAccessKey");

	private String region=System.getenv("region");

	@Bean
	public AmazonS3 amazonS3Client() {
		BasicAWSCredentials awscreds = new BasicAWSCredentials(awsKeyId, acessKey);
		return AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(awscreds)).build();

}}
