package com.minglemingle.chat2mingle.product.dao;

import com.minglemingle.chat2mingle.product.vo.ProductVO;

import java.util.List;

public interface ProductDAO {
    List<ProductVO> selectAllProductFromCategory(String id) throws Exception;

    ProductVO selectOneProduct(String productId) throws Exception;
}
