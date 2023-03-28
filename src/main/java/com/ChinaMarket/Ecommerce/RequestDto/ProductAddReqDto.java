package com.ChinaMarket.Ecommerce.RequestDto;

import com.ChinaMarket.Ecommerce.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddReqDto {

    private String name;
    private int price;
    private int quantity;
    private Category category;
    private int sellerId;
}
