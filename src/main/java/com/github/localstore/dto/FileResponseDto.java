package com.github.localstore.dto;

import java.nio.file.Path;

import static com.github.localstore.utils.Constants.DATA_PATH;

public class FileResponseDto {
    private String fileName;
    private String savePath;
    private boolean isDir;

    public FileResponseDto(String fileName, Path savePath, boolean isDir) {
        this.fileName = fileName;
        this.isDir = isDir;
        this.savePath = DATA_PATH.relativize(savePath).toString();
    }

    public FileResponseDto() {
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean dir) {
        isDir = dir;
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

    public void setSavePath(Path savePath) {
        this.savePath = DATA_PATH.relativize(savePath).toString();
        ;
    }
}
