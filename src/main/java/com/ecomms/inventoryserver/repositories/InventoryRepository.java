package com.ecomms.inventoryserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecomms.inventoryserver.entities.Item;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Item, Long>{
    Item findByProductId(UUID productId);
}
