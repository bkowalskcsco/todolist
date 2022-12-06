package com.example.fullstackapp.domain.todo;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long id) {
        super(String.format("Item with id=<%s> not found!", id));
    }

}
