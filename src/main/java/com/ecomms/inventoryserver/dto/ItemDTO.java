package com.ecomms.inventoryserver.dto;

import java.util.UUID;
import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private UUID productId;
    private int quantity;
}
