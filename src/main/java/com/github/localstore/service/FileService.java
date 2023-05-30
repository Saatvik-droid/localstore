package com.github.localstore.service;

import com.github.localstore.dto.FileRequestDto;
import com.github.localstore.dto.FileResponseDto;

import java.io.IOException;

public interface FileService {

    FileResponseDto[] getFilesInDir(String path) throws IOException;

    FileResponseDto[] getFilesInParentDir(String path) throws IOException;

    FileResponseDto saveFile(FileRequestDto fileRequestDto) throws IOException;
}