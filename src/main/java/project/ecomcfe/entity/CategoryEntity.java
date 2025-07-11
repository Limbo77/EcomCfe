package project.ecomcfe.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.ecomcfe.entity.enums.CategoryEnum;
import project.ecomcfe.entity.enums.SubCategoryEnum;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "categoryTitle", nullable = false)
    private CategoryEnum categoryTitle;
    @Enumerated(EnumType.STRING)
    @Column(name = "subCategoryTitle")
    private SubCategoryEnum subCategoryTitle;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> items;

}
