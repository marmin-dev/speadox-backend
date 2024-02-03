package com.speadox.pro.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductDto {

    private String url;

    private String category;

    private String pName;

    private String pBrand;

    private String imageName;

    private String subDescription;

    private String description;

    private String reg_date;

    private String spec;

    private LocalDateTime reg_datetime;

}

