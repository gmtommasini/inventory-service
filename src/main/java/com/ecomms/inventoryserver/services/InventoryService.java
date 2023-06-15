package com.ecomms.inventoryserver.services;

import com.ecomms.inventoryserver.repositories.InventoryRepository;
import com.ecomms.inventoryserver.entities.Item;
import com.ecomms.inventoryserver.dto.ItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    @Transactional(readOnly = true)
    public ItemDTO getItemQuantity(UUID productID){
        Item obj = repository.findByProductId(productID);
        return new ItemDTO(obj.getProductId(), obj.getQuantity());
    }


}
