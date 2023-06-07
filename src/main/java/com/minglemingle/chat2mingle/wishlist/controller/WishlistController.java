package com.minglemingle.chat2mingle.wishlist.controller;

import com.google.gson.Gson;
import com.minglemingle.chat2mingle.aspect.annotation.DebugLog;
import com.minglemingle.chat2mingle.product.service.ProductService;
import com.minglemingle.chat2mingle.product.vo.ProductVO;
import com.minglemingle.chat2mingle.wishlist.service.WishlistService;
import com.minglemingle.chat2mingle.wishlist.vo.WishlistVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("wishlist")
public class WishlistController {

    private final ProductService productService;
    private final WishlistService wishlistService;

    private final Gson gson;

    public WishlistController(ProductService productService, WishlistService wishlistService, Gson gson) {
        this.productService = productService;
        this.wishlistService = wishlistService;
        this.gson = gson;
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

    @DebugLog
    @GetMapping("/{wishlistId}")
    public String getWishlistPageById(WishlistVO wishlistVO, Model model) {
        WishlistVO wishlist = wishlistService.findWishlistById(wishlistVO);
        model.addAttribute("wishlist", wishlist);
        return "wishlist/sharedWishlist";
    }

    @PostMapping(value="", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> upsertWishlist(@RequestBody WishlistVO wishlistVO) {
        int upsertResult = wishlistService.upsertWishlist(wishlistVO);
        Map<String, Object> result = new HashMap<>();
        if (upsertResult == 1) {
            result.put("result", "success");
        }
        else {
            result.put("result", "failed");
        }
        return ResponseEntity.ok().body(gson.toJson(result, HashMap.class));
    }
}
