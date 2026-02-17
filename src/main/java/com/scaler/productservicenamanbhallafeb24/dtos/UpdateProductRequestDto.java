package com.scaler.productservicenamanbhallafeb24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/*
DTO fields must match with JSON keys
e.g. if DTO uses "categoryTitle" but JSON sends "category", in this case "categoryTitle" will be null

 */
public class UpdateProductRequestDto {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String categoryTitle;
}
