package com.ecomms.inventoryserver.controllers;

import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import com.ecomms.inventoryserver.services.InventoryService;

import com.ecomms.inventoryserver.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
     * @param productId product unique identifier
     * @return json representing an Inventory Item
     */
    @GetMapping("/{productId}")
    public ResponseEntity<?> getInventoryItem(@PathVariable("productId") String productId){
        try {
            InventoryItemDTO item =  service.getInventoryItem(productId);
            return ResponseEntity.ok().body(item);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            // TODO: Create a log here: System.out.println("INTERNAL ERROR: " + e.getMessage());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
