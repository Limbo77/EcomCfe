package project.ecomcfe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "sale")
    private Integer sale;
    @ManyToOne
    @JoinColumn(name = "seller_userEntity_id", nullable = false)
    private UserEntity seller;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
    @Column(name = "imageUrl")
    private String imageUrl;
}
