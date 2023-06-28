package com.ecomms.inventoryserver.services;

import com.ecomms.inventoryserver.repositories.InventoryRepository;
import com.ecomms.inventoryserver.entities.InventoryItem;
import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import com.ecomms.inventoryserver.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class InventoryServiceTest {
    String validProductId;
    String invalidProductId;
    Integer validQuantity;
    InventoryItem expectedInventoryItem;
    @Mock
    private InventoryRepository repository;

    @InjectMocks
    private InventoryService inventoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validProductId = "123";
        invalidProductId = "invalidProductId";
        validQuantity = 10;
        expectedInventoryItem = new InventoryItem().builder()
                .productId(validProductId)
                .quantity(validQuantity)
                .build();
    }

    @Test
    void getShouldReturnItemWhenIdValid() {
        // Arrange
        when(repository.findByProductId(validProductId)).thenReturn(Optional.of(expectedInventoryItem));

        // Act
        InventoryItemDTO result = inventoryService.getInventoryItem(validProductId);

        // Assert
        assertEquals(validProductId, result.getProductId());
        assertEquals(validQuantity, result.getQuantity());
        verify(repository, times(1)).findByProductId(validProductId);
    }

    @Test
    void getShouldReturnNotFoundWhenIdInvalid() {
        // Arrange
        when(repository.findByProductId(invalidProductId)).thenReturn(Optional.empty());

        // Act
        // Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            inventoryService.getInventoryItem(invalidProductId);
        });
        verify(repository, times(1)).findByProductId(invalidProductId);
    }
}