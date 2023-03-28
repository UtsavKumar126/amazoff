package com.ChinaMarket.Ecommerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePriceReqDto {
    private int id;
    private int value;
}
