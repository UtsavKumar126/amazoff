package com.ChinaMarket.Ecommerce.Converter;

import com.ChinaMarket.Ecommerce.Model.Seller;
import com.ChinaMarket.Ecommerce.RequestDto.AddSellerReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.SellerResponedto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConverter {

    public static Seller SellerReqDtoToSeller(AddSellerReqDto addSellerReqDto){
        return   Seller.builder()
                .name(addSellerReqDto.getName())
                .mobNo(addSellerReqDto.getMobNo())
                .email(addSellerReqDto.getEmail())
                .panNo(addSellerReqDto.getPanNo())
                .build();
    }
    public static SellerResponedto SellertoDto(Seller seller){
        return SellerResponedto.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .mobNo(seller.getMobNo())
                .panNo(seller.getPanNo())
                .build();
    }
}
