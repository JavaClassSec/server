package org.example.ex06.product.dto.request;

public record UpdatePostRequest(
        Long id,
        String name,
        String description,
        int price
) {
}
