package org.example.ex06.product.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PostRequest(

        @NotBlank
        String name,

        String description,

        @NotNull
        int price
) {
}
