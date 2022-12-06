package com.example.fullstackapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.example.fullstackapp.base.AbstractE2ETest;
import com.example.fullstackapp.domain.todo.Item;
import com.fasterxml.jackson.core.type.TypeReference;

public class ItemControllerIE2ETest extends AbstractE2ETest {

    public static final String ITEMS_ENDPOINT = "/items";

    @Test
    void should_create_item_successfully() throws Exception {
        // given
        final String itemJson = "{ \"title\": \"Title\", \"content\": \"Content\" }";

        // when
        final MvcResult postResult = mockMvc.perform(
                post(ITEMS_ENDPOINT)
                        .content(itemJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        final MvcResult getResult = mockMvc.perform(
                get(ITEMS_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();

        final List<Item> responseItems = objectMapper.readValue(
                getResult.getResponse().getContentAsString(),
                new TypeReference<>() {
                }
        );

        // then
        assertThat(postResult.getResponse().getStatus()).isEqualTo(CREATED.value());
        assertThat(getResult.getResponse().getStatus()).isEqualTo(OK.value());

        assertThat(responseItems).isNotEmpty();
        assertThat(responseItems).hasSize(1);

        final Item responseItem = responseItems.get(0);
        assertThat(responseItem.getTitle()).isEqualTo("Title");
        assertThat(responseItem.getContent()).isEqualTo("Content");
        assertThat(responseItem.getId()).isNotNull();
    }

}
