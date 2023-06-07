package com.minglemingle.chat2mingle.wishlist.service;


import com.minglemingle.chat2mingle.product.vo.ProductVO;
import com.minglemingle.chat2mingle.wishlist.vo.WishlistVO;

import java.util.List;

public interface WishlistService {

    WishlistVO findWishlistById(WishlistVO wishlistVO);

    Integer upsertWishlist(WishlistVO wishlistVO);
}
