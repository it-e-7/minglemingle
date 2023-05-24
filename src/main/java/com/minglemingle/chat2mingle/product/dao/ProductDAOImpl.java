package com.minglemingle.chat2mingle.product.dao;

import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDAOImpl implements ProductDAO{

    private SqlSession session;

    public ProductDAOImpl(SqlSession session) {
        this.session = session;
    }

    Logger logger = LogManager.getLogger("case3");
    @Override
    public List<ProductVO> selectAllProductFromCategory(String id) throws Exception {
        String statement = "product.selectAllProductFromCategory";
//		logger.debug("inside dao");

        List<ProductVO> result = session.selectList(statement);
        return null;
    }

    @Override
    public ProductVO selectOneProduct(String productId) {
        String statement = "product.selectOneProduct";
//		logger.debug("inside dao");

        ProductVO result = session.selectOne(statement);
        return null;
    }
}
