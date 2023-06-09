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
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String pageProductHome() {
        return "product/home";
    }

    @GetMapping("")
    public String pageForOneProductCategory(@RequestParam("category") String productCategory, Model model) {
        ProductVO productVO = new ProductVO(null, null, null, Integer.parseInt(productCategory), 0, null);
        List<ProductVO> result = productService.getProductListByCategory(productVO);
        model.addAttribute("productList", result);
        return "product/category";
    }

    @GetMapping("/{productCode}")
    public String pageDetailForOneProductCode(@PathVariable("productCode") String productCode, Model model) {
        ProductVO productVO = new ProductVO(productCode, null, null, 0, 0, null);
        ProductVO result = productService.getProductInfo(productVO);
        model.addAttribute("productDetail", result);
        return "product/product-detail";
    }

}
