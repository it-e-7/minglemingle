package com.minglemingle.chat2mingle.wishlist.vo;

import com.minglemingle.chat2mingle.product.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistVO {
    private String wishlistId;
    private String memberNickname;
    private String productCodeString;
    private List<ProductVO> productList;

    public List<String> getProductCodeList(boolean toList) {
        if (productCodeString == null) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(productCodeString.split(",")));
    }

}
