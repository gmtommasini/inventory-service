package com.ecomms.inventoryserver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecomms.inventoryserver.entities.Item;
public interface InventoryRepository extends JpaRepository<Item, Long>{
}
