package com.ecomms.inventoryserver.controllers;


import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import com.ecomms.inventoryserver.services.InventoryService;
import com.ecomms.inventoryserver.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class InventoryControllerTest {
    String validProductId ;
    String invalidProductId ;
    Integer validQuantity;
    InventoryItemDTO expectedInventoryItem;


    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        validProductId = "123";
        invalidProductId = "XXXX";
        validQuantity = 10;
        expectedInventoryItem = new InventoryItemDTO(validProductId, validQuantity);
    }

    @Test
    void getShouldReturnItemWhenIdValid() throws Exception {
        // Arrange
        when(inventoryService.getInventoryItem(validProductId)).thenReturn(expectedInventoryItem);

        //Act
        ResponseEntity<InventoryItemDTO> responseItem = (ResponseEntity<InventoryItemDTO>) inventoryController.getInventoryItem(validProductId);

        // Assert
        assertEquals(validProductId, responseItem.getBody().getProductId());
        assertEquals(validQuantity, responseItem.getBody().getQuantity());

        verify(inventoryService, times(1)).getInventoryItem(validProductId);
    }

    @Test
    void getShouldReturnNotFoundWhenIdInvalid() {
        when(inventoryService.getInventoryItem(invalidProductId)).thenThrow(new ResourceNotFoundException(invalidProductId));

        ResponseEntity<?> response = inventoryController.getInventoryItem(invalidProductId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(String.format("Product with id %s not found in the inventory.", invalidProductId), response.getBody());
        verify(inventoryService, times(1)).getInventoryItem(invalidProductId);
    }
}
