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
import project.ecomcfe.dto.UserEntityDto;
import project.ecomcfe.entity.UserEntity;
import project.ecomcfe.service.UserEntityService;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserEntityController {

    private final UserEntityService userEntityService;

    public UserEntityController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntityDto>> getAllUsers() {
        if(userEntityService.getAllUsers().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userEntityService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntityDto> getUserById(@PathVariable Long id) {
        if(userEntityService.getUserById(id) == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userEntityService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserEntity user) {
        if(userEntityService.addUser(user)){
            return ResponseEntity.ok("User has been successfully created");
        }
        return ResponseEntity.badRequest().body("User must not have an explicit id");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
        if(userEntityService.updateUser(id, user)){
            return ResponseEntity.ok("User has been successfully updated");
        }
        return ResponseEntity.badRequest().body("User does not exist");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if(userEntityService.deleteUserById(id)){
            return ResponseEntity.ok("User has been successfully deleted");
        }
        return ResponseEntity.badRequest().body("Unable to delete the user");
    }

}