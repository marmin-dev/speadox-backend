package com.speadox.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPdfDetailDto {

    private Long id;

    private String url;

    private String filename;

    private String pName;

    private String category;

    private String description;

    private String imageName;

    private String pBrand;

    private String subDescription;

    private String spec;

}
