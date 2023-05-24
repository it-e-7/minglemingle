package com.minglemingle.chat2mingle.product.service;

import com.minglemingle.chat2mingle.product.vo.ProductVO;

import java.util.List;

public interface ProductService {

    ProductVO getProductInfo(String productId);

    List<ProductVO> getProductList(String id);
}
