package com.speadox.pro.services;

import com.speadox.pro.dtos.ProductMainDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Test
    public void testGetMainList(){
        List<ProductMainDto> dtos = service.getMainList("jbl");
        System.out.println(dtos.size());
        System.out.println(dtos.toString());
    }




}
