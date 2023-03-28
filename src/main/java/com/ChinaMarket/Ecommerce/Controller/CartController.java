package com.ChinaMarket.Ecommerce.Controller;

import com.ChinaMarket.Ecommerce.RequestDto.PlaceOrderReqDto;
import com.ChinaMarket.Ecommerce.Service.CardService;
import com.ChinaMarket.Ecommerce.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody PlaceOrderReqDto placeOrderReqDto) throws Exception {
        try {
            return cartService.addToCart(placeOrderReqDto);
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
