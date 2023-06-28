package com.ecomms.inventoryserver.services;

import com.ecomms.inventoryserver.repositories.InventoryRepository;
import com.ecomms.inventoryserver.entities.InventoryItem;
import com.ecomms.inventoryserver.dto.InventoryItemDTO;

import com.ecomms.inventoryserver.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    /**
     * Receives a string of ProductID and returns the InventoryItemDTO corresponding
     * @param productID The productId  of the required Inventory Item
     * @return The InventoryItemDTO representing the item with the provided productID
     */
    @Transactional(readOnly = true)
    public InventoryItemDTO getInventoryItem(String productID){
        InventoryItem inventoryItem = repository.findByProductId(productID)
                .orElseThrow(()->new ResourceNotFoundException( productID ));
        return new InventoryItemDTO(inventoryItem.getProductId(), inventoryItem.getQuantity());
    }

}
