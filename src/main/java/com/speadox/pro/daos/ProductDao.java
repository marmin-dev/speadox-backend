package com.speadox.pro.daos;

import com.speadox.pro.dtos.ProductListDto;
import com.speadox.pro.dtos.ProductMainDto;
import com.speadox.pro.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
                "SELECT NEW com.speadox.pro.dtos.ProductMainDto(p.imageName, p.pName, p.id, p.pBrand) FROM Product p WHERE p.pBrand = :company",
                ProductMainDto.class
        );
        query.setParameter("company", company);
        return query.getResultList();
    }

    public List<ProductListDto> getListData(String category, int pageNumber){
        // 리스트 데이터 불러오는 쿼리 문
        int pageSize = 20;
        String queryF = "SELECT NEW com.speadox.pro.dtos.ProductListDto(p.imageName, p.category, p.pName, p.pBrand, p.id, p.subDescription)" +
                "FROM Product p";

        String queryWHERE = "WHERE category= :category";
        String queryString = "";
        if (category.equals("all")){
            queryString = queryF;
        }else{
            queryString = queryF + " " +queryWHERE;
        }
        TypedQuery<ProductListDto> query = entityManager.createQuery(
                queryString, ProductListDto.class
        );
        if (!category.equals("all")){
            query.setParameter("category", category);
        }
        // 페이지네이션 설정
        int firstResult = (pageNumber - 1) * pageSize; // 첫 번째 결과의 인덱스 계산
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);

        return query.getResultList();

    }




}
