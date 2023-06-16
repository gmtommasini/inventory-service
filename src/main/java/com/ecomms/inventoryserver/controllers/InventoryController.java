package com.ecomms.inventoryserver.controllers;

import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import com.ecomms.inventoryserver.services.InventoryService;

import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import java.util.UUID;

@RestController
@RequestMapping(value = "/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService service;

//    private final InventoryService service;
//    public InventoryController(InventoryService service) {this.service = service;}

    @GetMapping("/")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok().body("Working");
    }
    @GetMapping("/2")
    public ResponseEntity<InventoryItemDTO> getQuantity(){
        InventoryItemDTO item = service.getItemQuantity2();
        return ResponseEntity.ok().body(item);
    }




//    @GetMapping("/{productId}/quantity")
//    public ResponseEntity<InventoryItemDTO> getQuantity(@PathVariable("productID") UUID productID){
//        InventoryItemDTO item =  service.getItemQuantity(productID);
//        return ResponseEntity.ok().body(item);
//    }


}
