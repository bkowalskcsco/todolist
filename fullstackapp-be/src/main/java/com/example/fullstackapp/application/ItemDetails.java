package com.example.fullstackapp.application;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record ItemDetails(@NotEmpty @Length(max = 128, min = 1) String title,
                          @NotEmpty @Length(max = 1000, min = 1) String content,
                          Boolean completed) {

}
