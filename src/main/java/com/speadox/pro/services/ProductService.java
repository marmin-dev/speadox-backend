package com.speadox.pro.services;

import com.speadox.pro.daos.PdfDao;
import com.speadox.pro.daos.ProductDao;
import com.speadox.pro.dtos.*;
import com.speadox.pro.repositories.PdfRepository;
import com.speadox.pro.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository pRepository;
    private final PdfRepository repository;
    private final ProductDao productDao;
    private final PdfDao pdfDao;

    // 메인페이지 사진 가져오는 로직
    public List<ProductMainDto> getMainList(String company){
        // 랜덤으로 10 개 보여주는 로직
        Random random = new Random();
        List<Integer> randomList = new ArrayList<Integer>();
        List<ProductMainDto> newDtos = new ArrayList<>();
        try{
            List<ProductMainDto> dtos = productDao.getMainList(company);
            while(randomList.size() < 9){
                int rand = random.nextInt(dtos.size() + 1);
                if (randomList.contains(rand)){
                    continue;
                }else{
                    if(!dtos.get(rand).getImageName().isEmpty()){
                        randomList.add(rand);
                        newDtos.add(dtos.get(rand));
                    }
                }
            }
            return newDtos;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(LocalDateTime.now());
            System.out.println("getMainList Exception");
        }
        return newDtos;
    }

    // 리스트 페이지 가져오는 로직
    public ProductListPageSizeDto getProductList(String category, int page){
        try{
            ProductListPageSizeDto dto = productDao.getListData(category, page);
            dto.setMaxPage((int) Math.ceil((double) dto.getMaxPage()/20));
            return dto;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductListPageSizeDto();
    }

    // 디테일 페이지 데이터 가져오는 로직
    public ProductPdfDetailDto getProductDetail(Long id){
        ProductPdfDetailDto dto  = new ProductPdfDetailDto();
        try{
            dto = pdfDao.getProductDetail(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dto;
    }

    // 검색된 페이지 가져오는 로직
    public ProductListPageSizeDto getProductListBySearch(ProductSearchDto dto, int page){
        try{
            ProductListPageSizeDto pDto = productDao.getListBySearch(dto.getCategory(), dto.getKeyword(), page);
            pDto.setMaxPage((int) Math.ceil((double) pDto.getMaxPage()/20));
            return pDto;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ProductListPageSizeDto();
    }


}
