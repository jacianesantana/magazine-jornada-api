package com.magazinejornada.api.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    private String title;
    private String description;
    private Long quantity;
    private Double price;
    private String picture;

}
