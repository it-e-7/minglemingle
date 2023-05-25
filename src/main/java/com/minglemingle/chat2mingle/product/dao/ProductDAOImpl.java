package com.minglemingle.chat2mingle.product.dao;

import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{

    private SqlSession session;

    public ProductDAOImpl(SqlSession session) {
        this.session = session;
    }

    @Override
    public List<ProductVO> selectAllProductFromCategory(ProductVO productVO) throws Exception {
        String statement = "product.selectAllProductFromCategory";
        List<ProductVO> result = session.selectList(statement, productVO.getProductCategory());
        return result;
    }

    @Override
    public ProductVO selectOneProduct(ProductVO productVO ) {
        String statement = "product.selectOneProduct";
        ProductVO result = session.selectOne(statement, productVO.getProductCode());
        return result;
    }

}
