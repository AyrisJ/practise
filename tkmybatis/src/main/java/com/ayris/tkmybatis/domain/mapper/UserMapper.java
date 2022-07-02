package com.ayris.tkmybatis.domain.mapper;

import com.ayris.tkmybatis.domain.TUser;
import com.ayris.tkmybatis.domain.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "username")
    })
    UserDto toDto(TUser user);
}
