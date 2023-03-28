package com.ChinaMarket.Ecommerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceOrderReqDto {

    private int customerId;
    private int productId;
    private int reqQuantity;

}
