package com.example.fullstackapp;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.fullstackapp.application.ItemDetails;
import com.example.fullstackapp.application.ItemService;
import com.example.fullstackapp.base.AbstractUnitTest;
import com.example.fullstackapp.domain.TimeService;
import com.example.fullstackapp.domain.todo.Item;
import com.example.fullstackapp.domain.todo.ItemRepository;

public class ItemServiceTest extends AbstractUnitTest {

    @Mock
    ItemRepository itemRepository;

    @Mock
    TimeService timeService;

    @InjectMocks
    ItemService service;

    @Test
    void should_create_item_successfully() {
        // given
        final ItemDetails itemDetails = ItemDetails.builder()
                .title("A title")
                .content("The content")
                .build();
        final ZonedDateTime currentDate = ZonedDateTime.now();

        // and
        final Item item = Item.builder()
                .title(itemDetails.title())
                .content(itemDetails.content())
                .currentTime(currentDate)
                .build();
        when(timeService.getCurrentZonedDateTime()).thenReturn(currentDate);
        when(itemRepository.save(item)).thenReturn(item);

        // when
        service.createItem(itemDetails);

        // then
        verify(itemRepository).save(item);
        verify(timeService).getCurrentZonedDateTime();
    }

}
