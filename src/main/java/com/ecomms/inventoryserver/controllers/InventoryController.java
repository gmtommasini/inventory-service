package com.ecomms.inventoryserver.controllers;

import com.ecomms.inventoryserver.dto.ItemDTO;
import com.ecomms.inventoryserver.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping("/{productId}/quantity")
    public ResponseEntity<ItemDTO> getQuantity(@PathVariable("productID") UUID productID){
        ItemDTO item =  service.getItemQuantity(productID);
        return ResponseEntity.ok().body(item);
    }
}
