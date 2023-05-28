package com.github.localstore.controller;

import com.github.localstore.dto.FileInputDto;
import com.github.localstore.dto.PathDto;
import com.github.localstore.dto.FileOutputDto;
import com.github.localstore.service.FileService;
import com.github.localstore.utils.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;


@RestController
public class UploadController {
    @Autowired
    private FileService fileService;

    @Autowired
    private FileMapper fileMapper;

    @GetMapping(path = "/")
    File[] getFilesInDir(@RequestBody PathDto pathDto) {
        return fileService.getFilesInDir(pathDto);
    }

    @PostMapping(path = "/upload")
    FileOutputDto uploadFile(FileInputDto fileInputDto) throws IOException {
        return fileService.saveFile(fileInputDto);
    }
}   
