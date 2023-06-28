package com.ecomms.inventoryserver.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String productID) {
        super(String.format("Product with id %s not found in the inventory.", productID));
    }

}
