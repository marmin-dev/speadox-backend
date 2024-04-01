package com.speadox.pro.controllers;

import com.speadox.pro.dtos.*;
import com.speadox.pro.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class ProductController {

    private final ProductService pService;

    // 메인 리스트 불러오는 로직
    @GetMapping("/main/{company}")
    public ResponseEntity<List<ProductMainDto>> getMainList(@PathVariable String company){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pService.getMainList(company));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    // 기기 리스트 불러오는 로직
    @GetMapping("/list/{category}/{page}")
    public ResponseEntity<ProductListPageSizeDto> getProductList (@PathVariable String category, @PathVariable int page){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pService.getProductList(category, page));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProductListPageSizeDto());
        }
    }

    // 기기 디테일 로직
    @GetMapping("/detail/{id}")
    public ResponseEntity<ProductPdfDetailDto> getProductPdf(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pService.getProductDetail(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProductPdfDetailDto());
        }
    }
    // 기기 검색하는 로직
    @PostMapping("/search/{page}")
    public ResponseEntity<ProductListPageSizeDto> getProductBySearch(@PathVariable int page, @RequestBody ProductSearchDto dto){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(pService.getProductListBySearch(dto, page));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ProductListPageSizeDto());
        }
    }
}
