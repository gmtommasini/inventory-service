package com.ecomms.inventoryserver.controllers;

import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import com.ecomms.inventoryserver.services.InventoryService;

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

    /**
     * Health check. Does nothing
     * @return 200
     */
    @GetMapping("/")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.ok().body("Controller Working");
    }

    /**
     * Fetches a complete Inventory Item
     * @param productId
     * @return json representing an Inventory Item
     */
    @GetMapping("/{productId}")
    public ResponseEntity<InventoryItemDTO> getInventoryItem(@PathVariable("productId") String productId){
        InventoryItemDTO item =  service.getInventoryItem(productId);
        return ResponseEntity.ok().body(item);
    }
}
