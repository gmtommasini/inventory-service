package com.ecomms.inventoryserver.entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name = "tb_inventory")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "product_id")
    private UUID productId;

    private int quantity;

    //Constructors
    public Item() {    }
    public Item(UUID productId, int quantity) {
        super();
        this.productId=productId;
        this.quantity=quantity;
    }


    //Getters and Setters
    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public UUID getProductId() {
        return productId;
    }
}
