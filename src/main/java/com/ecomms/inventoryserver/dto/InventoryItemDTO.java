package com.ecomms.inventoryserver.dto;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class InventoryItemDTO {
    private UUID productId;
    private int quantity;
}
