package com.speadox.pro.daos;

import com.speadox.pro.dtos.ProductListDto;
import com.speadox.pro.dtos.ProductListPageSizeDto;
import com.speadox.pro.dtos.ProductMainDto;
import com.speadox.pro.dtos.ProductPdfDetailDto;
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
                "SELECT NEW com.speadox.pro.dtos.ProductMainDto(p.imageName, p.pName, p.productNo, p.pBrand) FROM ProductNew p WHERE p.pBrand = :company",
                ProductMainDto.class
        );
        query.setParameter("company", company);
        return query.getResultList();
    }

    public ProductListPageSizeDto getListData(String category, int pageNumber){
        // 리스트 데이터 불러오는 쿼리 문
        int pageSize = 20;
        String queryF = "SELECT NEW com.speadox.pro.dtos.ProductListDto(p.imageName, p.category, p.pName, p.pBrand, p.productNo, p.subDescription)" +
                "FROM ProductNew p";

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
        int maxPage = query.getResultList().size();
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);

        return new ProductListPageSizeDto(maxPage, query.getResultList());
    }

    public ProductListPageSizeDto getListBySearch(String category, String keyword, int pageNumber){
        // 검색으로 리스트 데이터 불러오는 로직
        int pageSize = 20;
        String queryString = "SELECT NEW com.speadox.pro.dtos.ProductListDto(p.imageName, p.category, p.pName, p.pBrand, p.productNo, p.subDescription)" +
                "FROM ProductNew p";
        String queryW = "";
        if(category.equals("brand")){
            queryW = " WHERE pBrand like :keyword";
        }
        else if(category.equals("name")){
            queryW = " WHERE pName like :keyword";
        }
        else if(category.equals("spec")){
            queryW = " WHERE spec like :keyword";
        }

        TypedQuery<ProductListDto> query = entityManager.createQuery(queryString + queryW, ProductListDto.class);
        query.setParameter("keyword", "%" + keyword + "%");

        // 페이지네이션 설정
        int firstResult = (pageNumber - 1) * pageSize; // 첫 번째 결과의 인덱스 계산
        int maxPage = query.getResultList().size();
        query.setFirstResult(firstResult);
        query.setMaxResults(pageSize);

        return new ProductListPageSizeDto(maxPage, query.getResultList());
    }

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
