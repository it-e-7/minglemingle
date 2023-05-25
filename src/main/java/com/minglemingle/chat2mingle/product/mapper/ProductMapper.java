package com.minglemingle.chat2mingle.product.mapper;

import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ProductDAO 인터페이스는 제품에 관련된 데이터베이스 작업을 수행하는 메서드를 정의합니다.
 */
@Mapper
public interface ProductMapper {
    /**
     * 특정 카테고리에서 모든 제품을 선택하여 반환합니다.
     *
     * @author sangwon
     * @param productVO 특정 카테고리의 제품 목록을 검색하기 위해 필요한 ProductVO 커맨드 객체입니다.
     * @return 카테고리에서 선택된 제품 목록을 포함하는 ProductVO 객체의 리스트입니다.
     * @throws Exception 데이터베이스 작업 중 발생한 예외를 처리하기 위해 던져질 수 있습니다.
     */
    List<ProductVO> selectAllProductFromCategory(ProductVO productVO) throws Exception;

    /**
     * 하나의 제품을 선택하여 반환합니다.
     *
     * @author sangwon
     * @param productVO 특정 제품을 상품코드로 검색하기 위해 필요한 ProductVO 커맨드 객체입니다.
     * @return 선택된 제품에 대한 상세 정보를 포함하는 ProductVO 객체입니다.
     * @throws Exception 데이터베이스 작업 중 발생한 예외를 처리하기 위해 던져질 수 있습니다.
     */
    ProductVO selectOneProduct(ProductVO productVO) throws Exception;
}
