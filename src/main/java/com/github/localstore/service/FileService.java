package com.github.localstore.service;

import com.github.localstore.dto.FileInputDto;
import com.github.localstore.dto.FileOutputDto;
import com.github.localstore.dto.PathDto;

import java.io.File;
import java.io.IOException;

public interface FileService {

    File[] getFilesInDir(PathDto pathDto);

    FileOutputDto saveFile(FileInputDto fileInputDto) throws IOException;
}