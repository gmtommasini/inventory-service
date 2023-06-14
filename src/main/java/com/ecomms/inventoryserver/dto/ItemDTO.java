package com.ecomms.inventoryserver.dto;

import java.util.UUID;
import java.io.Serializable;

public class ItemDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    //private UUID id; // preciso disso?
    private UUID productId;
    private int quantity;

    // Constructor
    public ItemDTO() {    }

    public ItemDTO(UUID productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and setters
    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
