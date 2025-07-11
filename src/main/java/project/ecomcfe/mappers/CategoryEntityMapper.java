package project.ecomcfe.mappers;

import org.mapstruct.Mapper;
import project.ecomcfe.dto.CategoryEntityDto;
import project.ecomcfe.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryEntityMapper {
    CategoryEntityDto toCategoryEntityDto(CategoryEntity categoryEntity);
    CategoryEntity toCategoryEntity(CategoryEntityDto categoryEntityDto);
}
