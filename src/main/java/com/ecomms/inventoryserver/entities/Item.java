package com.ecomms.inventoryserver.entities;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
}
