package com.ecomms.inventoryserver.entities;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_inventory")
public class InventoryItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "product_id")
    private String productId;

    private int quantity;
}
