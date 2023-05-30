package com.github.localstore.utils.mappers;

import com.github.localstore.dto.FileRequestDto;
import com.github.localstore.dto.FileResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

import static com.github.localstore.utils.Constants.DATA_PATH;

@Mapper(componentModel = "spring")
public interface FileMapper {

    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    @Mapping(target = "fileName", source = "file", qualifiedByName = "fileName")
    @Mapping(target = "savePath", source = ".", qualifiedByName = "savePath")
    FileResponseDto toFileModel(FileRequestDto fileRequestDto);

    @Named("fileName")
    default String fileName(MultipartFile file) {
        return file.getOriginalFilename();
    }

    @Named("savePath")
    default Path savePath(FileRequestDto fileRequestDto) {
        return Path.of(DATA_PATH + "/" + fileRequestDto.getSavePath() + fileRequestDto.getFile().getOriginalFilename());
    }
}
