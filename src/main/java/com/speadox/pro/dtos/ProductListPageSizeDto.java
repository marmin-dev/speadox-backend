package com.speadox.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListPageSizeDto {

    int maxPage;

    List<ProductListDto> dtos;

}
