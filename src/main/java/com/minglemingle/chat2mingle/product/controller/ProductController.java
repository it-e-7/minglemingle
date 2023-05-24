package com.minglemingle.chat2mingle.product.controller;

import com.minglemingle.chat2mingle.product.service.ProductService;
import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService service;
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/category")
    public String getProductListForOneCategory(@RequestParam("category") String id, Model model) {
        List<ProductVO> result = service.getProductList(id);
        model.addAttribute("productList", result);
        return "product/category";
    }

    @GetMapping("/{id}")
    public String getProductDetail(@PathVariable("id") String productId, Model model) {
        ProductVO result = service.getProductInfo(productId);
        model.addAttribute("productDetail", result);
        return "product/product-detail";
    }

}
