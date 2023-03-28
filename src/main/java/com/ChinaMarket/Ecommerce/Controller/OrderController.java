package com.ChinaMarket.Ecommerce.Controller;

import com.ChinaMarket.Ecommerce.RequestDto.PlaceOrderReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.OrderRespDto;
import com.ChinaMarket.Ecommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/place_Order")
    public ResponseEntity placeOrder(@RequestBody PlaceOrderReqDto placeOrderReqDto) throws Exception {

        OrderRespDto orderRespDto;
       try {
           orderRespDto=orderService.placeOrder(placeOrderReqDto);
       }
       catch (Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(orderRespDto,HttpStatus.ACCEPTED);
    }

}
