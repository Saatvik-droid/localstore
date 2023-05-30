package com.github.localstore.controller;

import com.github.localstore.dto.FileRequestDto;
import com.github.localstore.dto.FileResponseDto;
import com.github.localstore.dto.PathDto;
import com.github.localstore.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;

@CrossOrigin()
@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping(path = "/data")
    FileResponseDto[] getFilesInDir(@RequestBody PathDto pathDto) throws IOException {
        return fileService.getFilesInDir(Objects.requireNonNullElse(pathDto.getPath(), ""));
    }

    @PostMapping(path = "/data/parent")
    FileResponseDto[] getFilesInParentDir(@RequestBody PathDto pathDto) throws IOException {
        return fileService.getFilesInParentDir(pathDto.getPath());
    }

    @PostMapping(path = "/upload")
    FileResponseDto uploadFile(FileRequestDto fileRequestDto) throws IOException {
        return fileService.saveFile(fileRequestDto);
    }
}
