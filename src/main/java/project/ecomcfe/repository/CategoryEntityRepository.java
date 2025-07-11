package project.ecomcfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.ecomcfe.entity.CategoryEntity;

@Repository
public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Long> {
}
