package com.speadox.pro.repositories;

import com.speadox.pro.dtos.ProductMainDto;
import com.speadox.pro.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {

//    @Query("SELECT imageName, pName FROM Product WHERE pBrand=:company")
//    public List<ProductMainDto> getMainPage(@Param("company") String company);

}
