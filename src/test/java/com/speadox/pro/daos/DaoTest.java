package com.speadox.pro.daos;

import com.speadox.pro.dtos.ProductMainDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DaoTest {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testMain(){
        List<ProductMainDto> dtos = productDao.getMainList("jbl");
        System.out.println(dtos.get(1).getImageName() + "  :  " +dtos.get(1).getPName());
        System.out.println(dtos.size());
    }


}
