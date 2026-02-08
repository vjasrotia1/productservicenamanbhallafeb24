package com.scaler.productservicenamanbhallafeb24.dtos;

import lombok.Getter;
import lombok.Setter;

/*
dto for each request so that in future if the request needs additional params, u can easily add
because this class is being used only for the product controller to receive the params of createproduct

Who owns CreateProductRequestDto?

👉 YOU do.
It represents what Varun/client sends to your API, not what FakeStore expects.

Think of it as:

“This is the shape of data my backend accepts.”
 */
@Getter
@Setter
public class CreateProductRequestDto {


    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    //private Long userId;
}
