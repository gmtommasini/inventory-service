package com.ecomms.inventoryserver.services;

//import com.ecomms.inventoryserver.repositories.InventoryRepository;
//import com.ecomms.inventoryserver.entities.InventoryItem;
import com.ecomms.inventoryserver.dto.InventoryItemDTO;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

//import java.util.UUID;

@Service
public class InventoryService {

//    @Autowired
//    private InventoryRepository repository;

//    private  final InventoryRepository repository;
//
//    public InventoryService(InventoryRepository repository) {
//        this.repository = repository;
//    }
//
//    @Transactional(readOnly = true)
//    public InventoryItemDTO getItemQuantity(UUID productID){
////        Item obj = repository.findByProductId(productID);
////        Item obj = repository.getById(productID);
//        InventoryItem obj = repository.findByProductId(productID)
//                .orElseThrow(()->new RuntimeException("ERROR finding id"));
////        return new ItemDTO(obj.getProductId(), obj.getQuantity());
//
//        return new InventoryItemDTO().builder().
//                quantity(obj.getQuantity()).
//                productId(obj.getProductId()).
//                build();
//    }


    public InventoryItemDTO getItemQuantity2(){
        System.out.println("Service call");
        return new InventoryItemDTO().builder().
                quantity(2).
                build();
    }
}
