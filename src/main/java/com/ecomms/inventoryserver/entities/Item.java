package com.ecomms.inventoryserver.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Entity
@Table(name = "tb_inventory")
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "product_id")
    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    private UUID productId;

    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    private int quantity;

}
