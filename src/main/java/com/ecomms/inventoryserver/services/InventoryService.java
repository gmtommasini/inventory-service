package com.ecomms.inventoryserver.services;

import com.ecomms.inventoryserver.repositories.InventoryRepository;
import com.ecomms.inventoryserver.entities.InventoryItem;
import com.ecomms.inventoryserver.dto.InventoryItemDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
//import org.springframework.transaction.annotation.Transactional;


@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

//    private  final InventoryRepository repository;
//    public InventoryService(InventoryRepository repository) {
//        this.repository = repository;
//    }

    @Transactional(readOnly = true)
    public InventoryItemDTO getItemQuantity(String productID){
        InventoryItem obj = repository.findByProductId(productID)
                .orElseThrow(()->new RuntimeException("ERROR finding id"));
//        return new ItemDTO(obj.getProductId(), obj.getQuantity());

        return new InventoryItemDTO().builder().
                quantity(obj.getQuantity()).
                productId(obj.getProductId()).
                build();
    }

}
