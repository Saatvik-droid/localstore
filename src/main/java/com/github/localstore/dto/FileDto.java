package com.github.localstore.dto;

import com.github.localstore.model.FileModel;
import com.github.localstore.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileDto {
    @Autowired
    FileService fileService;

    private MultipartFile file;

    private String savePath;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public FileDto() {
    }

    public FileDto(MultipartFile file, String savePath) {
        this.file = file;
        this.savePath = savePath;
    }
}
