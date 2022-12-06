package com.example.fullstackapp.application;

import java.util.Collection;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.fullstackapp.domain.TimeService;
import com.example.fullstackapp.domain.todo.Item;
import com.example.fullstackapp.domain.todo.ItemNotFoundException;
import com.example.fullstackapp.domain.todo.ItemRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final TimeService timeService;

    public Collection<Item> getItems() {
        log.info("Loading all items...");

        return itemRepository.listAll();
    }

    public Item getItemById(@NotNull Long id) {
        log.info("Loading item with id = <{}>", id);

        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public void createItem(@NotNull ItemDetails itemDetails) {
        log.info("Creating item from item details = <{}>", itemDetails);

        final Item item = Item.builder()
                .title(itemDetails.title())
                .content(itemDetails.content())
                .currentTime(timeService.getCurrentZonedDateTime())
                .build();

        final Item createdItem = itemRepository.save(item);

        log.info("Item created successfully = <{}>", createdItem);
    }

    public void updateItem(@NotNull ItemDetails request, @NotNull Long id) {
        log.info("Updating item from item details = <{}> with id = <{}>", request, id);

        final Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));

        // TODO this might be moved to mapstruct
        item.setCompleted(request.completed());
        item.setTitle(request.title());
        item.setContent(request.content());
        item.setUpdateDate(timeService.getCurrentZonedDateTime());

        log.info("Item updated successfully = <{}>", item);
    }

    public void deleteItem(@NotNull Long id) {
        log.info("Deleting item with id = <{}>", id);

        itemRepository.delete(id);

        log.info("Item deleted successfully id = <{}>", id);
    }

}
