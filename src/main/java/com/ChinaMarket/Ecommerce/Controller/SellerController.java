package com.ChinaMarket.Ecommerce.Controller;

import com.ChinaMarket.Ecommerce.Exception.SellerNotFoundException;
import com.ChinaMarket.Ecommerce.RequestDto.AddSellerReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.SellerResponedto;
import com.ChinaMarket.Ecommerce.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seller")
public class SellerController {
    @Autowired
    SellerService sellerService;
    @PostMapping("/add")
    public String addSeller(@RequestBody AddSellerReqDto addSellerReqDto){
       return sellerService.addSeller(addSellerReqDto);
    }
    @GetMapping("/find_all")
    public List<SellerResponedto> findAllSeller(){
        return sellerService.findAllSeller();
    }

    @GetMapping("/findByPan")
    public ResponseEntity findByPan(@RequestParam("pan")String panNo){
        SellerResponedto sellerResponedto;
        try {
            sellerResponedto=sellerService.findByPan(panNo);
        } catch (SellerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(sellerResponedto,HttpStatus.FOUND);
    }
    @DeleteMapping("removeSeller")
    public String deleteSellerById(@RequestParam("id")int id){
        return sellerService.deletebyId(id);
    }

}
