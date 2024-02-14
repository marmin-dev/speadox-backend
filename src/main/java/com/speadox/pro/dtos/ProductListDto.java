package com.speadox.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductListDto {

    private String imageName;

    private String category;

    private String pName;

    private String pBrand;

    private String subDescription;

}
