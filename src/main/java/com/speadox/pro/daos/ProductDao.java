package com.speadox.pro.daos;

import com.speadox.pro.dtos.ProductMainDto;
import com.speadox.pro.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ProductMainDto> getMainList(String company) {
        // 메인 페이지 스피커 리스트
        TypedQuery<ProductMainDto> query = entityManager.createQuery(
                "SELECT NEW com.speadox.pro.dtos.ProductMainDto(p.imageName, p.pName, p.pBrand) FROM Product p WHERE p.pBrand = :company",
                ProductMainDto.class
        );
        query.setParameter("company", company);
        return query.getResultList();
    }

//    public List
}
