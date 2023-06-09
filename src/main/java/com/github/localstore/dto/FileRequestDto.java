package com.github.localstore.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileRequestDto {

    private MultipartFile file;

    private String savePath;

    public FileRequestDto() {
    }

    public FileRequestDto(MultipartFile file, String savePath) {
        this.file = file;
        this.savePath = savePath;
    }

    @Override
    public String toString() {
        return "FileInputDto{" + "file=" + file + ", savePath='" + savePath + '\'' + '}';
    }

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
}
