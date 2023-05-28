package com.github.localstore.utils.mapper;

import com.github.localstore.dto.UserDto;
import com.github.localstore.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "status", ignore = true)
    UserDto toUserDto(UserModel userModel);

}
