package kz.bitlab.middle.docker.service;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class FileService {

    private final MinioClient minioClient;

    @Value("${minio.bucket}")
    private String bucket;

    public String uploadFile(MultipartFile file) {
        try {
            minioClient.putObject(PutObjectArgs
                    .builder()
                    .bucket(bucket)
                    .object(file.getOriginalFilename())
                    .stream(file.getInputStream(), file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build());
            return "file uploaded successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "error uploading file";
        }
    }

    public ByteArrayResource downloadFile(String filename) {
        try {
            GetObjectArgs getObjectArgs = GetObjectArgs
                    .builder()
                    .bucket(bucket)
                    .object(filename)
                    .build();
            InputStream inputStream = minioClient.getObject(getObjectArgs);
            byte[] bytes = IOUtils.toByteArray(inputStream);
            inputStream.close();
            return new ByteArrayResource(bytes);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
