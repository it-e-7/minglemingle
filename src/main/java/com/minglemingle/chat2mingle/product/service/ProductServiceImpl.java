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

     Logger logger = LogManager.getLogger("case3");

    public ProductServiceImpl(ProductMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<ProductVO> getProductList(ProductVO productVO) {
        List<ProductVO> result = null;
        try {
            result = mapper.selectAllProductFromCategory(productVO);
        } catch(Exception e) {
            logger.error(e);
        }

        return result;
    }
    @Override
    public ProductVO getProductInfo(ProductVO productVO) {
        ProductVO result = null;
        try {
            result = mapper.selectOneProduct(productVO);
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }


}
