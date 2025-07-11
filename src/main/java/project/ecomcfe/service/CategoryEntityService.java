package project.ecomcfe.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ecomcfe.dto.CategoryEntityDto;
import project.ecomcfe.entity.CategoryEntity;
import project.ecomcfe.mappers.CategoryEntityMapper;
import project.ecomcfe.repository.CategoryEntityRepository;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryEntityService {

    private final CategoryEntityRepository categoryEntityRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    public CategoryEntityService(CategoryEntityRepository categoryEntityRepository,
                                 CategoryEntityMapper categoryEntityMapper) {
        this.categoryEntityRepository = categoryEntityRepository;
        this.categoryEntityMapper = categoryEntityMapper;
    }

    public List<CategoryEntityDto> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryEntityRepository.findAll();
        if(categoryEntities.isEmpty()){
            return Collections.emptyList();
        }
        return categoryEntities.stream().map(categoryEntityMapper::toCategoryEntityDto).toList();
    }


    public CategoryEntityDto getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryEntityRepository.findById(id).orElse(null);
        if(categoryEntity == null){
            return null;
        }
        return categoryEntityMapper.toCategoryEntityDto(categoryEntity);
    }

    @Transactional
    public boolean addCategory(CategoryEntity categoryEntity) {
        if(categoryEntity.getId() != null){
            return false;
        }
        categoryEntityRepository.save(categoryEntity);
        return true;
    }

    @Transactional
    public boolean deleteCategoryByid(Long id) {
        CategoryEntity categoryEntity = categoryEntityRepository.findById(id).orElse(null);
        if(categoryEntity == null){
            return false;
        }
        categoryEntityRepository.delete(categoryEntity);
        return true;
    }

    @Transactional
    public boolean updateCategory(Long id, CategoryEntity newCategoryEntity) {
        CategoryEntity categoryEntity = categoryEntityRepository.findById(id).orElse(null);
        if(categoryEntity == null){
            return false;
        }
        categoryEntity.setCategoryTitle(newCategoryEntity.getCategoryTitle());
        categoryEntity.setSubCategoryTitle(newCategoryEntity.getSubCategoryTitle());
        categoryEntityRepository.save(categoryEntity);
        return true;
    }

}
