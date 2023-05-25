package com.minglemingle.chat2mingle.product.service;

import com.minglemingle.chat2mingle.product.vo.ProductVO;

import java.util.List;
/**
 * ProductService 인터페이스는 제품 정보 및 목록을 검색하는 메서드를 제공합니다.
 */
public interface ProductService {


    /**
     * 특정 카테고리의 제품 목록을 검색합니다.
     * @author sangwon
     * @param productVO 특정 카테고리의 제품 목록을 검색하기 위해 필요한 ProductVO 커맨드 객체입니다.
     * @return 제품 목록을 포함하는 ProductVO 객체의 리스트입니다.
     */
    List<ProductVO> getProductList(ProductVO productVO);

    /**
     * 특정 제품에 대한 상세 정보를 검색합니다.
     * @author sangwon
     * @param productVO 제품 상세 정보를 상품코드로 검색하기 위해 필요한 ProductVO 커맨드 객체입니다.
     * @return 제품의 상세 정보를 포함하는 ProductVO 객체입니다.
     */
    ProductVO getProductInfo(ProductVO productVO);

}
