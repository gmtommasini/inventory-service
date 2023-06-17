package com.ecomms.inventoryserver.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InventoryItemDTO {
    private String productId;
    private int quantity;
}
