package com.back.hostely.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

import java.io.IOException;
import java.net.URI;
import java.util.UUID;

@Service
public class S3Service {

    @Value("${spring.aws.s3.access-key}")
    private String accessKey;

    @Value("${spring.aws.s3.secret-key}")
    private String secretKey;

    @Value("${spring.aws.s3.bucket-name}")
    private String bucketName;

    private S3Client s3;

    @PostConstruct
    public void init() {
        s3 = S3Client.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create(accessKey, secretKey)))
                .build();
    }

    public String uploadFile(MultipartFile file, String folderName) throws IOException {
        String uniqueFileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        String key = folderName + "/" + uniqueFileName;

        PutObjectRequest putRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(file.getContentType())
                .build();

        s3.putObject(putRequest, RequestBody.fromBytes(file.getBytes()));

        return "https://" + bucketName + ".s3.amazonaws.com/" + key;
    }

    public void deleteFileFromUrl(String fileUrl) {
        try {
            URI uri = URI.create(fileUrl);
            String path = uri.getPath();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }

            if (!path.isBlank()) {
                DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
                        .bucket(bucketName)
                        .key(path)
                        .build();

                s3.deleteObject(deleteRequest);
            }
        } catch (Exception e) {
            System.err.println("No se pudo eliminar el archivo de S3: " + e.getMessage());
        }
    }
}
