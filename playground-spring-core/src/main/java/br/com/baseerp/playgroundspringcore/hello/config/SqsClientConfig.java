package br.com.baseerp.playgroundspringcore.hello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class SqsClientConfig {

    private final String accessKey;
    private final String secretKey;

    public SqsClientConfig(@Value("${cloud.aws.credentials.access-key}") String accessKey,
                           @Value("${cloud.aws.credentials.secret-key}") String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(
                        () -> software.amazon.awssdk.auth.credentials.AwsBasicCredentials.create(accessKey, secretKey))
                .build();
    }

}
