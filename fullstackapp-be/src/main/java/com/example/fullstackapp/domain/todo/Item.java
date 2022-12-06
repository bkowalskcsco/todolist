package com.example.fullstackapp.domain.todo;


import java.time.ZonedDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Length(max = 128, min = 1)
    private String title;

    @NotEmpty
    @Length(max = 1000, min = 1)
    private String content;

    private boolean completed;

    @NotNull
    private ZonedDateTime creationDate;

    private ZonedDateTime updateDate;

    @Builder
    private Item(String title, String content, ZonedDateTime currentTime) {
        this.title = title;
        this.content = content;
        this.completed = false;
        this.creationDate = currentTime;
    }

}
