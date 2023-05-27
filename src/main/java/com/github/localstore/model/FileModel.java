package com.github.localstore.model;

import jakarta.persistence.*;

@Entity
public class FileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fileName;
    @Column
    private String savePath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public FileModel() {
    }

    public FileModel(Long id, String fileName, String savePath) {
        this.id = id;
        this.fileName = fileName;
        this.savePath = savePath;
    }
}
