package com.ecomms.inventoryserver.controllers;


import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import com.ecomms.inventoryserver.services.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
public class InventoryControllerTest {

    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetInventoryItem() throws Exception {
        // Arrange
        String productId = "123";
        Integer quantity = 10;
        InventoryItemDTO expectedInventoryItem = new InventoryItemDTO(productId, quantity);
        when(inventoryService.getInventoryItem(productId)).thenReturn(expectedInventoryItem);

        //Act
        ResponseEntity<InventoryItemDTO> responseItem = inventoryController.getInventoryItem(productId);

        // Assert
        assertEquals(productId, responseItem.getBody().getProductId());
        assertEquals(quantity, responseItem.getBody().getQuantity());

        verify(inventoryService, times(1)).getInventoryItem(productId);
    }
}
