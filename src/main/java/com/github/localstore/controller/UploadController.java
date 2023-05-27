package com.github.localstore.controller;

import com.github.localstore.dto.FileDto;
import com.github.localstore.model.FileModel;
import com.github.localstore.model.PathModel;
import com.github.localstore.service.FileService;
import com.github.localstore.utils.mapper.FileModelDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


@RestController
public class UploadController {
    @Autowired
    private FileService fileService;

    @Autowired
    private FileModelDtoMapper fileModelDtoMapper;

    @GetMapping(path = "/")
    Object[] getFilesInDir(@RequestBody PathModel pathModel) {
        return Arrays.stream(Objects.requireNonNull(new File(pathModel.getPath()).listFiles())).toArray();
    }

    @PostMapping(path = "/upload")
    FileModel uploadFile(FileDto fileDto) throws IOException {
        MultipartFile file = fileDto.getFile();
        String absoluteSavePath = new File(".").getCanonicalPath() + fileDto.getSavePath() + "/" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Path.of(absoluteSavePath), REPLACE_EXISTING);
        FileModel fileModel = fileModelDtoMapper.INSTANCE.toFileModel(fileDto);
        return fileService.saveFile(fileModel);
    }
}
