package com.minglemingle.chat2mingle.product.service;

import com.minglemingle.chat2mingle.product.mapper.ProductMapper;
import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductMapper mapper;


    public ProductServiceImpl(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductVO> getProductListByCategory(ProductVO productVO) {
        List<ProductVO> result;
        result = mapper.selectAllProductFromCategory(productVO);
        return result;
    }
    @Override
    public ProductVO getProductInfo(ProductVO productVO) {
        ProductVO result;
        result = mapper.selectOneProductByCode(productVO);
        return result;
    }


}
