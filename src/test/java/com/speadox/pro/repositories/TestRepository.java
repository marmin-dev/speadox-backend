package com.speadox.pro.repositories;

import com.speadox.pro.entities.PdfUrl;
import com.speadox.pro.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
public class TestRepository {

    @Autowired
    private PdfRepository pdfRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void jpaTest(){
        // jpa 테스트 클래스 작성(DB 연결만 확인 가능하도록)
        List<PdfUrl> pdfs = pdfRepository.findAll();
        List<Product> products = productRepository.findAll();
        System.out.println(pdfs.size()  + "    " + products.size() );
    }

}
