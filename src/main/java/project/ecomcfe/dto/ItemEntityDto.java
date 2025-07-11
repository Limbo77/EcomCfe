package project.ecomcfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntityDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer sale;
    private Long sellerUserEntityId;
    private Long categoryId;
    private String imageUrl;
}
