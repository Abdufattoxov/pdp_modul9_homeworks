package uz.pdp.modul9.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.modul9.config.FileStorageConfig;
import uz.pdp.modul9.entity.Upload;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class UploadFileController {
    private final FileStorageConfig fileStorageConfig;

    @PostMapping("/upload-file")
    public ResponseEntity<Upload> uploadFile(MultipartFile file) {
        String newName = "file" + "_" + file.getOriginalFilename();
        String uploadedPath = fileStorageConfig.getUploadPath().toString();

        return ResponseEntity.status(HttpStatus.OK)
                .body(Upload.builder()
                        .originalName(file.getOriginalFilename())
                        .generatedName(newName)
                        .size(file.getSize())
                        .mimeType(file.getContentType())
                        .uploadedPath(uploadedPath)
                        .build());
    }
}
