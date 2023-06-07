package com.minglemingle.chat2mingle.wishlist.mapper;

import com.minglemingle.chat2mingle.wishlist.vo.WishlistVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.lang.NonNull;

@Mapper
public interface WishlistMapper {
    WishlistVO selectWishlistById(@NonNull WishlistVO wishlistVO);
    Integer upsertWishlist(@NonNull WishlistVO wishlistVO);
}
