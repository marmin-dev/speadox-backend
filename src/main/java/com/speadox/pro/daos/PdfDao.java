package com.speadox.pro.daos;

import com.speadox.pro.dtos.ProductPdfDetailDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PdfDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductPdfDetailDto getProductDetail(Long id){
        // 디테일 페이지
        String queryString = "SELECT NEW com.speadox.pro.dtos.ProductPdfDetailDto" +
        "(p.productNo," +
                "p.url,"+
                "p.pdfName," +
                "p.pName," +
                "p.category," +
                "p.description," +
                "p.imageName," +
                "p.pBrand," +
                "p.subDescription," +
                "p.spec) " +
                "FROM ProductNew p " +
                "WHERE p.productNo = :id";
        TypedQuery<ProductPdfDetailDto> query = entityManager.createQuery(
                queryString, ProductPdfDetailDto.class
        );
        query.setParameter("id",id);
        return query.getSingleResult();
    }



}
