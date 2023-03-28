package com.ChinaMarket.Ecommerce.ResponeDto;

import com.ChinaMarket.Ecommerce.Enum.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponeDto {

    private String name;
    private int price;
    private int quantity;
    private Category category;

}
