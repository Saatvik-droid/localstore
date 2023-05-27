package com.github.localstore.utils.mapper;

import com.github.localstore.dto.FileDto;
import com.github.localstore.model.FileModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
public interface FileModelDtoMapper {

    FileModelDtoMapper INSTANCE = Mappers.getMapper(FileModelDtoMapper.class);
    @Mapping(target = "fileName", source = "file", qualifiedByName = "fileName")
    FileModel toFileModel(FileDto fileDto);


    @Named("fileName")
    default String fileName(MultipartFile file) {
        return file.getOriginalFilename();
    }
}
