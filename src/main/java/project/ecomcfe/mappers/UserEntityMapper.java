package project.ecomcfe.mappers;

import org.mapstruct.Mapper;
import project.ecomcfe.dto.UserEntityDto;
import project.ecomcfe.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntityDto toUserEntityDto(UserEntity userEntity);
    UserEntity toUserEntity(UserEntityDto userEntityDto);
}
