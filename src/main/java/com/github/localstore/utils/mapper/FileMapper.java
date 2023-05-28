package com.github.localstore.utils.mapper;

import com.github.localstore.dto.FileInputDto;
import com.github.localstore.dto.FileOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
public interface FileMapper {

    FileMapper INSTANCE = Mappers.getMapper(FileMapper.class);

    @Mapping(target = "fileName", source = "file", qualifiedByName = "fileName")
    FileOutputDto toFileModel(FileInputDto fileInputDto);


    @Named("fileName")
    default String fileName(MultipartFile file) {
        return file.getOriginalFilename();
    }
}
