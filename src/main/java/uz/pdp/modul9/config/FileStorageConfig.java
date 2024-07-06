package uz.pdp.modul9.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileStorageConfig {
    @Value("${file.uploadDir}")
    private String uploadPath;

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(Paths.get(uploadPath));
        } catch (Exception e) {
            throw new RuntimeException("Couldn't create upload directory", e);
        }
    }

    public Path getUploadPath() {
        return Paths.get(uploadPath);
    }
}
