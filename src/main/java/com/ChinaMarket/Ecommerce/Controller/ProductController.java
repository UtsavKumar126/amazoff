package com.ChinaMarket.Ecommerce.Controller;

import com.ChinaMarket.Ecommerce.RequestDto.ProductAddReqDto;
import com.ChinaMarket.Ecommerce.RequestDto.UpdatePriceReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.ProductResponeDto;
import com.ChinaMarket.Ecommerce.Enum.Category;
import com.ChinaMarket.Ecommerce.Exception.SellerNotFoundException;
import com.ChinaMarket.Ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("add")
    public ProductResponeDto addProduct(@RequestBody ProductAddReqDto productAddReqDto) throws SellerNotFoundException {
        return productService.addProduct(productAddReqDto);
    }
    @GetMapping("findByCaterory")
    public List<ProductResponeDto>findByCategory(@RequestParam("category") Category category){
        return productService.findByCategory(category);
    }
    @GetMapping("findFiveLeastValueProduct")
    public List<ProductResponeDto>findLeastFive(){
       return productService.findLeastFive();
    }
    @DeleteMapping("deleteProductById/{Id}")
    public String deleteProduct(@PathVariable("Id")int id){
        return productService.deleteById(id);
    }

    @PutMapping("/changePrice")
    public ProductResponeDto updatePrice(@RequestBody UpdatePriceReqDto updatePriceReqDto){
        return productService.updatePrice(updatePriceReqDto);
    }
}
