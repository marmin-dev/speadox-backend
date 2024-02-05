package com.speadox.pro.controllers;

import com.speadox.pro.dtos.ProductMainDto;
import com.speadox.pro.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService pService;

    // 메인 리스트 불러오는 로직
    @GetMapping("/main/{company}")
    public ResponseEntity<List<ProductMainDto>> getMainList(@PathVariable String company){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pService.getMainList(company));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }
}
