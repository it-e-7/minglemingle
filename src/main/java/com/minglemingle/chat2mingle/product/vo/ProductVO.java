package com.minglemingle.chat2mingle.product.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {

    private String productCode;
    private String productName;
    private String productBrand;
    private Integer productCategory;
    private Integer productPriceWon;
    private String productImagePath;
}
