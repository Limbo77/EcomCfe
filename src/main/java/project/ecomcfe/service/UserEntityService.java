package project.ecomcfe.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ecomcfe.dto.UserEntityDto;
import project.ecomcfe.entity.UserEntity;
import project.ecomcfe.mappers.UserEntityMapper;
import project.ecomcfe.repository.UserEntityRepository;

import java.util.Collections;
import java.util.List;

@Service
@Data
public class UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityMapper userEntityMapper;

    public UserEntityService(UserEntityRepository userEntityRepository,
                             UserEntityMapper userEntityMapper) {
        this.userEntityRepository = userEntityRepository;
        this.userEntityMapper = userEntityMapper;
    }

    public List<UserEntityDto> getAllUsers() {
        List<UserEntity> users = userEntityRepository.findAll();
        if(users.isEmpty()){
            return Collections.emptyList();
        }
        return users.stream().map(userEntityMapper::toUserEntityDto).toList();
    }

    public UserEntityDto getUserById(Long id) {

        UserEntity userEntity = userEntityRepository.findById(id).orElse(null);
        if(userEntity == null){
            return null;
        }
        return userEntityMapper.toUserEntityDto(userEntity);
    }

    @Transactional
    public boolean addUser(UserEntity user) {
        if(user.getId() != null){
            return false;
        }
        userEntityRepository.save(user);
        return true;
    }

    @Transactional
    public boolean updateUser(Long id, UserEntity newUser) {
        UserEntity user = userEntityRepository.findById(id).orElse(null);
        if(user != null){
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setPhoneNumber(newUser.getPhoneNumber());
            userEntityRepository.save(user);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteUserById(Long id) {
        if(userEntityRepository.existsById(id)){
            userEntityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
