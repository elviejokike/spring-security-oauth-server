package com.example.oauth.service.mapping;

import com.example.oauth.api.Resource;
import com.example.oauth.domain.AbstractEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG
)
public interface AbstractMapperConfig {

    Resource toResource(AbstractEntity entity);

    @Mapping(target = "id", ignore = true)
    AbstractEntity toEntity(Resource resource);
}