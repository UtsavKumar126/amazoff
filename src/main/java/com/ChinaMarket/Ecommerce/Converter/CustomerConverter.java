package com.ChinaMarket.Ecommerce.Converter;

import com.ChinaMarket.Ecommerce.Model.Customer;
import com.ChinaMarket.Ecommerce.RequestDto.AddCustomerReqDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerConverter {

    public static Customer customerDtoToCustomer(AddCustomerReqDto addCustomerReqDto){
        return Customer.builder()
                .name(addCustomerReqDto.getName())
                .age(addCustomerReqDto.getAge())
                .mobNo(addCustomerReqDto.getMobNo())
                .email(addCustomerReqDto.getEmail())
                .build();
    }
}
