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


@RestController
@RequestMapping(value = "/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService service;

//    private final InventoryService service;
//    public InventoryController(InventoryService service) {this.service = service;}

    @GetMapping("/")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok().body("Controller Working");
    }

    @GetMapping("/{productId}")
    public ResponseEntity<InventoryItemDTO> getQuantity(@PathVariable("productId") String productId){
        System.out.println("ProductID" + productId);
        InventoryItemDTO item =  service.getItemQuantity(productId);
        return ResponseEntity.ok().body(item);
    }
}
