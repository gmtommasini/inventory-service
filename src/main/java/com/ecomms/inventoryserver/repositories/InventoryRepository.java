package com.ecomms.inventoryserver.repositories;

import com.ecomms.inventoryserver.entities.InventoryItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {

    Optional<InventoryItem> findByProductId(String productId);

}
