package com.minglemingle.chat2mingle.product.controller;

import com.minglemingle.chat2mingle.product.service.ProductService;
import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.ProtectionDomain;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getProductListForOneCategory(@RequestParam("category") String id, Model model) {
        ProductVO prodcutVO = new ProductVO(null, null, null, Integer.parseInt(id), 0, null);
        List<ProductVO> result = service.getProductList(prodcutVO);
        model.addAttribute("productList", result);
        return "product/category";
    }

    @GetMapping("/{id}")
    public String getProductDetail(@PathVariable("id") String productId, Model model) {
        ProductVO productVO = new ProductVO(productId, null, null, 0, 0, null);
        ProductVO result = service.getProductInfo(productVO);
        model.addAttribute("productDetail", result);
        return "product/product-detail";
    }

}
