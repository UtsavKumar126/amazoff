package com.ChinaMarket.Ecommerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSellerReqDto {

    private String name;
    private String mobNo;
    private String email;
    private String panNo;
}
