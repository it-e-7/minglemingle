package com.minglemingle.chat2mingle.product.service;

import com.minglemingle.chat2mingle.product.dao.ProductDAO;
import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    private ProductDAO dao;

     Logger logger = LogManager.getLogger("case3");

    public ProductServiceImpl(ProductDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<ProductVO> getProductList(String id) {
        List<ProductVO> result = null;
        try {
            result = dao.selectAllProductFromCategory(id);
        } catch(Exception e) {
            logger.error(e);
        }

        return result;
    }
    @Override
    public ProductVO getProductInfo(String productId) {
        ProductVO result = null;
        try {
            result = dao.selectOneProduct(productId);
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }


}
