package project.ecomcfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ecomcfe.entity.enums.CategoryEnum;
import project.ecomcfe.entity.enums.SubCategoryEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryEntityDto {
    private Long id;
    private CategoryEnum categoryTitle;
    private SubCategoryEnum subCategoryTitle;
}
