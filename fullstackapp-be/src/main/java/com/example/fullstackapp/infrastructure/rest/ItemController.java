package com.example.fullstackapp.infrastructure.rest;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.example.fullstackapp.application.ItemDetails;
import com.example.fullstackapp.application.ItemService;
import com.example.fullstackapp.domain.todo.Item;

@RequiredArgsConstructor
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    Collection<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping(value = "/{id}")
    public Item getById(@PathVariable("id") Long id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createItem(@RequestBody @Valid ItemDetails itemDetails) {
        itemService.createItem(itemDetails);
    }

    @PutMapping("/{id}")
    void createItem(@PathVariable("id") Long id, @RequestBody @Valid ItemDetails itemDetails) {
        itemService.updateItem(itemDetails, id);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
    }

}
