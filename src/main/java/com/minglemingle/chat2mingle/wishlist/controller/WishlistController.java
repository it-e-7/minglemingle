package com.minglemingle.chat2mingle.wishlist.controller;

import com.minglemingle.chat2mingle.product.service.ProductService;
import com.minglemingle.chat2mingle.product.vo.ProductVO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("wishlist")
public class WishlistController {

    ProductService productService;

    public WishlistController(ProductService productService) {
        this.productService = productService;
    }



    @GetMapping("createWishlist")
    @ResponseBody
    public ResponseEntity<Boolean> createWishListInSession(@RequestParam("items") String myWishlist,
                                                HttpServletRequest request
                                                ) {
        System.out.println(myWishlist);
        String[] wishProductList = myWishlist.split(",");
        List<ProductVO> productList = new ArrayList<>();
        for (String productCode : wishProductList) {
            ProductVO productVO = new ProductVO(productCode, null, null, null, null, null);
            ProductVO productInfo = productService.getProductInfo(productVO);
            productList.add(productInfo);
        }
//        model.addAttribute("myWishlistProducts", productList);
        HttpSession session = request.getSession();
        session.setAttribute("myWishlistProducts", productList);
        return ResponseEntity.ok(true);
    }

    @GetMapping("myWishlist")
    public String pageWishList() {
        return "wishlist/myWishlist";
    }
}
