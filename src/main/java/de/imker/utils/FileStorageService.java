package de.imker.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileStorageService {

  @Autowired
  private AmazonS3 amazonS3;

  @Value("${aws.s3.bucketName}")
  private String bucketName;


  public List<String> listFilesInSpaces() {
    List<String> fileList = new ArrayList<>();

    ObjectListing objectListing = amazonS3.listObjects(bucketName);
    List<S3ObjectSummary> objectSummaries = objectListing.getObjectSummaries();

    for (S3ObjectSummary objectSummary : objectSummaries) {
      String key = objectSummary.getKey();
      fileList.add(key);
    }

    return fileList;
  }

  public void uploadFile(String key, File file) {
    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
    amazonS3.putObject(putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead));
  }

  public File getFileFromSpaces(String key) throws IOException {
    S3Object s3Object = amazonS3.getObject(bucketName, key);
    S3ObjectInputStream inputStream = s3Object.getObjectContent();

    File file = new File("path_to_save_file"); // Укажите путь для сохранения файла
    try (FileOutputStream outputStream = new FileOutputStream(file)) {
      byte[] buffer = new byte[4096];
      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
      }
    }
    return file;
  }

  public void deleteFileFromSpaces(String key) {
    amazonS3.deleteObject(bucketName, key);
  }
}
