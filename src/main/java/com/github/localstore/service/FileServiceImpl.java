package com.github.localstore.service;

import com.github.localstore.dto.FileInputDto;
import com.github.localstore.dto.FileOutputDto;
import com.github.localstore.dto.PathDto;
import com.github.localstore.utils.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;

    @Override
    public File[] getFilesInDir(PathDto pathDto) {
        return new File(pathDto.getPath()).listFiles();
    }

    @Override
    public FileOutputDto saveFile(FileInputDto fileInputDto) throws IOException {
        MultipartFile file = fileInputDto.getFile();
        String absoluteSavePath = new File(".").getCanonicalPath() + "/data/" + fileInputDto.getSavePath() + file.getOriginalFilename();
        Files.copy(file.getInputStream(), Path.of(absoluteSavePath), REPLACE_EXISTING);
        return fileMapper.INSTANCE.toFileModel(fileInputDto);
    }
}
