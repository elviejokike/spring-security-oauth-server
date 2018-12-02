package com.example.oauth.service.mapping;


import com.example.oauth.api.User;
import com.example.oauth.domain.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(config = AbstractMapperConfig.class, componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    User toResource(UserEntity entity);

    UserEntity toEntity(User resource);

}


