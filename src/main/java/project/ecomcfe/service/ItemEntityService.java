package project.ecomcfe.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.ecomcfe.dto.ItemEntityDto;
import project.ecomcfe.entity.ItemEntity;
import project.ecomcfe.mappers.ItemEntityMapper;
import project.ecomcfe.repository.ItemEntityRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ItemEntityService {

    private final ItemEntityRepository itemEntityRepository;
    private final ItemEntityMapper itemEntityMapper;

    public ItemEntityService(ItemEntityRepository itemEntityRepository,
                             ItemEntityMapper itemEntityMapper) {
        this.itemEntityRepository = itemEntityRepository;
        this.itemEntityMapper = itemEntityMapper;
    }

    public List<ItemEntityDto> getAllItems() {
        List<ItemEntity> items = itemEntityRepository.findAll();

        if(items.isEmpty()) {
            return Collections.emptyList();
        }

        return items.stream().map(itemEntityMapper::toItemEntityDto).toList();
    }

    public ItemEntityDto getItemById(Long id) {

        ItemEntity itemEntity = itemEntityRepository.findById(id).orElse(null);

        return itemEntityMapper.toItemEntityDto(itemEntity);
    }

    @Transactional
    public boolean addItem(ItemEntity item) {

        if(item.getId() != null) {
            return false;
        }
        itemEntityRepository.save(item);
        return true;
    }

    @Transactional
    public boolean updateItemById(Long id, ItemEntity  newItem) {
        ItemEntity item = itemEntityRepository.findById(id).orElse(null);
        if(item == null) {
            return false;
        }
        item.setTitle(newItem.getTitle());
        item.setDescription(newItem.getDescription());
        item.setPrice(newItem.getPrice());
        item.setCategory(newItem.getCategory());
        item.setSeller(newItem.getSeller());
        item.setSale(newItem.getSale());
        item.setImageUrl(newItem.getImageUrl());
        itemEntityRepository.save(item);
        return true;
    }

    @Transactional
    public boolean deleteItemById(Long id) {
        if(itemEntityRepository.existsById(id)) {
            itemEntityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
