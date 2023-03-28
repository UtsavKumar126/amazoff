package com.ChinaMarket.Ecommerce.Converter;

import com.ChinaMarket.Ecommerce.Enum.ProductStatus;
import com.ChinaMarket.Ecommerce.Model.Product;
import com.ChinaMarket.Ecommerce.RequestDto.ProductAddReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.ProductResponeDto;

public class ProductConverter {

    public static Product ProductResponseDtoProduct(ProductAddReqDto productAddReqDto){
        return Product.builder()
                .name(productAddReqDto.getName())
                .price(productAddReqDto.getPrice())
                .quantity(productAddReqDto.getQuantity())
                .category(productAddReqDto.getCategory())
                .productStatus(ProductStatus.AVAILABLE)
                .build();

    }
    public static ProductResponeDto ProductToResponseDto(Product product){
        return ProductResponeDto.builder()
                .name(product.getName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .category(product.getCategory()).build();
    }
}
