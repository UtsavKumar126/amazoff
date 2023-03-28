package com.ChinaMarket.Ecommerce.ResponeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRespDto {

    private String productName;
    private Date orderDate;
    private int totalCost;
    private int deliveryCharge;
    private String cardForPayment;
    private int itemPrice;
    private int orderQuantity;
}
