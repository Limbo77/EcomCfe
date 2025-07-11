package project.ecomcfe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.ecomcfe.entity.ItemEntity;

public interface ItemEntityRepository extends JpaRepository<ItemEntity, Long> {
}
