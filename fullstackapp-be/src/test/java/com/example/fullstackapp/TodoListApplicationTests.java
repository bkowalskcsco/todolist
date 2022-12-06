package com.example.fullstackapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
class TodoListApplicationTests {

    @Autowired
    Environment environment;

    @Test
    void should_context_load() {
        // expect
        assertThat(environment).isNotNull();
    }

}
