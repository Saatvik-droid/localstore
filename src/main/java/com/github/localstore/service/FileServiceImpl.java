package com.github.localstore.service;

import com.github.localstore.dto.FileRequestDto;
import com.github.localstore.dto.FileResponseDto;
import com.github.localstore.utils.mappers.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.github.localstore.utils.Constants.DATA_PATH;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileMapper fileMapper;

    private String convertPath(String path) {
        if (path.endsWith("/")) return path;
        return path.concat("/");
    }

    @Override
    public FileResponseDto[] getFilesInDir(String path) throws IOException {
        path = convertPath(path);
        File[] files = new File(DATA_PATH + "/" + path).listFiles();
        FileResponseDto[] fileStructureDtoList = new FileResponseDto[0];
        if (files != null) {
            fileStructureDtoList = new FileResponseDto[files.length];
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                fileStructureDtoList[i] = new FileResponseDto(file.getName(), Path.of(file.getCanonicalPath()), file.isDirectory());
            }
        }
        return fileStructureDtoList;
    }

    @Override
    public FileResponseDto[] getFilesInParentDir(String path) throws IOException {
        File parent = new File(DATA_PATH + "/" + path).getParentFile();
        return getFilesInDir(DATA_PATH.relativize(Path.of(parent.getCanonicalPath())).toString());
    }

    @Override
    public FileResponseDto saveFile(FileRequestDto fileRequestDto) throws IOException {
        MultipartFile file = fileRequestDto.getFile();
        fileRequestDto.setSavePath(convertPath(fileRequestDto.getSavePath()));
        Path absoluteSavePath = Path.of(DATA_PATH + "/" + fileRequestDto.getSavePath() + fileRequestDto.getFile().getOriginalFilename());
        Files.copy(file.getInputStream(), absoluteSavePath, REPLACE_EXISTING);
        return fileMapper.INSTANCE.toFileModel(fileRequestDto);
    }
}
