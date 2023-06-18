package com.ecomms.inventoryserver.services;

import com.ecomms.inventoryserver.repositories.InventoryRepository;
import com.ecomms.inventoryserver.entities.InventoryItem;
import com.ecomms.inventoryserver.dto.InventoryItemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class InventoryServiceTest {

    @Mock
    private InventoryRepository repository;

    @InjectMocks
    private InventoryService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetItemQuantity() {
        // Arrange
        String productId = "123";
        int quantity = 10;
        InventoryItem item = new InventoryItem();
        item.setProductId(productId);
        item.setQuantity(quantity);
        when(repository.findByProductId(productId)).thenReturn(Optional.of(item));

        // Act
        InventoryItemDTO result = service.getInventoryItem(productId);

        // Assert
        assertEquals(productId, result.getProductId());
        assertEquals(quantity, result.getQuantity());

        verify(repository, times(1)).findByProductId(productId);
    }
}
