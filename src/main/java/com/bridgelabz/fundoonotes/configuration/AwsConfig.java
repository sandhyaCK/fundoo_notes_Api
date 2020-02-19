import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class AwsConfig {
	@Value("${awsKeyId}")
	private String awsKeyId;
	@Value("${acessKey}")
	private String acessKey;
	@Value("${region}")
	private String region;

	@Bean
	public AmazonS3 amazonS3Client() {
		BasicAWSCredentials awscreds = new BasicAWSCredentials(awsKeyId, acessKey);
		return AmazonS3ClientBuilder.standard().withRegion(Regions.fromName(region))
				.withCredentials(new AWSStaticCredentialsProvider(awscreds)).build();

}
