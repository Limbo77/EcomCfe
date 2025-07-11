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
import project.ecomcfe.dto.ItemEntityDto;
import project.ecomcfe.entity.ItemEntity;
import project.ecomcfe.service.ItemEntityService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemEntityController {

    private final ItemEntityService itemEntityService;

    public ItemEntityController(ItemEntityService itemEntityService) {
        this.itemEntityService = itemEntityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemEntityDto>> getAllItems(){

        if(itemEntityService.getAllItems() == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(itemEntityService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemEntityDto> getItemById(@PathVariable Long id){
        if(itemEntityService.getItemById(id) == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(itemEntityService.getItemById(id));
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody ItemEntity item){
        if(!itemEntityService.addItem(item)){
            return ResponseEntity.badRequest().body("The item id must not be explicitly declared");
        }
        return ResponseEntity.ok("The item has been successfully added");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateItem(@PathVariable Long id, @RequestBody ItemEntity item){
        if(!itemEntityService.updateItemById(id, item)){
            return ResponseEntity.badRequest().body("The item does not exist");
        }
        return ResponseEntity.ok("The item has been successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        if(!itemEntityService.deleteItemById(id)){
            return ResponseEntity.badRequest().body("The item does not exist");
        }
        return ResponseEntity.ok("The item has been successfully deleted");
    }

}
