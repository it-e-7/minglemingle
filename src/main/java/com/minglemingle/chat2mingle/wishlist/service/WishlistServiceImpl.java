package com.minglemingle.chat2mingle.wishlist.service;


import com.minglemingle.chat2mingle.aspect.transaction.annotation.Transactional;
import com.minglemingle.chat2mingle.product.service.ProductService;
import com.minglemingle.chat2mingle.product.vo.ProductVO;
import com.minglemingle.chat2mingle.wishlist.mapper.WishlistMapper;
import com.minglemingle.chat2mingle.wishlist.vo.WishlistVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistMapper wishlistMapper;
    private final ProductService productService;

    public WishlistServiceImpl(WishlistMapper wishlistMapper, ProductService productService) {
        this.wishlistMapper = wishlistMapper;
        this.productService = productService;
    }

    @Override
    public WishlistVO findWishlistById(WishlistVO vo) {
        WishlistVO wishlistVO = wishlistMapper.selectWishlistById(vo);

        wishlistVO.setProductVOList(new ArrayList<>());

        for (String productCode : wishlistVO.getProductCodeList(true)) {
            ProductVO productInfo = productService.getProductInfo(new ProductVO(productCode, null, null, null, null, null));
            wishlistVO.getProductVOList().add(productInfo);
        }
        return wishlistVO;
    }

    @Transactional
    @Override
    public Integer upsertWishlist(WishlistVO wishlistVO) {
        return wishlistMapper.upsertWishlist(wishlistVO);
    }
}
