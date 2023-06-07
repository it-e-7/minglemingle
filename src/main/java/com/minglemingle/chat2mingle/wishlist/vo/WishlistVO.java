package com.minglemingle.chat2mingle.wishlist.vo;

import com.minglemingle.chat2mingle.product.vo.ProductVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistVO {
    private String wishlistId;
    private String memberNickname;
    private List<String> productCodeList;
    private List<ProductVO> productVOList;

    public String getProductCodeList() {
        if (productCodeList == null) return null;
        return String.join(",", productCodeList);
    }
    public List<String> getProductCodeList(boolean toList) {
        return productCodeList;
    }
    public void setProductCodeList(String productCodesString) {
        if (productCodesString == null) return;
        this.productCodeList = new ArrayList<String>(Arrays.asList(productCodesString.split(",")));
    }

    public void productVOList(ArrayList<Object> objects) {
    }
}
