package project.ecomcfe.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.ecomcfe.dto.ItemEntityDto;
import project.ecomcfe.entity.ItemEntity;

@Mapper(componentModel = "spring")
public interface ItemEntityMapper {

    @Mapping(source = "seller.id", target = "sellerUserEntityId")
    @Mapping(source = "category.id", target = "categoryId")
    ItemEntityDto toItemEntityDto(ItemEntity itemEntity);

    @Mapping(target = "seller.id", source = "sellerUserEntityId")
    @Mapping(target = "category.id", source = "categoryId")
    ItemEntity toItemEntity(ItemEntityDto itemEntityDto);
}
