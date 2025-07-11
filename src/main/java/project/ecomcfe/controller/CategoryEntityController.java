package project.ecomcfe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.ecomcfe.dto.CategoryEntityDto;
import project.ecomcfe.entity.CategoryEntity;
import project.ecomcfe.service.CategoryEntityService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryEntityController {

    private final CategoryEntityService categoryEntityService;

    public CategoryEntityController(CategoryEntityService categoryEntityService) {
        this.categoryEntityService = categoryEntityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryEntityDto>> getAll() {
        if(categoryEntityService.getAllCategories() == null){
            return ResponseEntity.badRequest().build();
        }
        else return ResponseEntity.ok(categoryEntityService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntityDto> getById(@PathVariable Long id) {
        if(categoryEntityService.getCategoryById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        else return ResponseEntity.ok(categoryEntityService.getCategoryById(id));
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CategoryEntity categoryEntity) {
        if(categoryEntityService.addCategory(categoryEntity)){
            return ResponseEntity.ok("Category has been successfully added");
        }
        return ResponseEntity.badRequest().body("Category must not have an explicit ID");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity) {
        if(categoryEntityService.updateCategory(id, categoryEntity)){
            return ResponseEntity.ok("Category has been successfully updated");
        }
        return ResponseEntity.badRequest().body("Category does not exists");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if(categoryEntityService.deleteCategoryByid(id)){
            return ResponseEntity.ok("Category has been successfully deleted");
        }
        return ResponseEntity.badRequest().body("Category does not exist");
    }

}