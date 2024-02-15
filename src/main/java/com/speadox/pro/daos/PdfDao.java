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
        "(pu.id," +
                "pu.filename," +
                "pu.pName," +
                "pu.url.category," +
                "pu.url.description," +
                "pu.url.imageName," +
                "pu.url.pBrand," +
                "pu.url.subDescription," +
                "pu.url.spec) " +
                "FROM PdfUrl pu " +
                "WHERE pu.id = :id";
        TypedQuery<ProductPdfDetailDto> query = entityManager.createQuery(
                queryString, ProductPdfDetailDto.class
        );
        query.setParameter("id",id);
        return query.getSingleResult();
    }



}
