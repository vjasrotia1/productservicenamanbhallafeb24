package com.scaler.productservicenamanbhallafeb24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchProductRequestDto {
String  title;
String description;
Double price;
String image;
String categoryTitle;
}
