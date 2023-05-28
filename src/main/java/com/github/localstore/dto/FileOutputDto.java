package com.github.localstore.dto;

public class FileOutputDto {
    private String fileName;
    private String savePath;

    public FileOutputDto() {
    }

    public FileOutputDto(String fileName, String savePath) {
        this.fileName = fileName;
        this.savePath = savePath;
    }

    @Override
    public String toString() {
        return "FileOutputDto{" + "fileName='" + fileName + '\'' + ", savePath='" + savePath + '\'' + '}';
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
