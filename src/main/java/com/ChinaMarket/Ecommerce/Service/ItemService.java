package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Exception.ProductNotFoundException;
import com.ChinaMarket.Ecommerce.Model.Item;
import com.ChinaMarket.Ecommerce.Model.Product;
import com.ChinaMarket.Ecommerce.Repository.ProductRepository;
import com.ChinaMarket.Ecommerce.ResponeDto.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ProductRepository productRepository;
    public ItemResponseDto viewItem(int id) throws ProductNotFoundException {

        Product product;
        try{
            product=productRepository.findById(id).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Sorry ! Invalid product Id");
        }

        Item item=Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();
        //map item to product
        product.setItem(item);

        productRepository.save(product);

        ItemResponseDto itemResponseDto=ItemResponseDto.builder()
                .productName(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;
    }
}
