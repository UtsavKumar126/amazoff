package com.ChinaMarket.Ecommerce.ResponeDto;

import com.ChinaMarket.Ecommerce.Enum.Category;
import com.ChinaMarket.Ecommerce.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {


    private String productName;
    private int price;
    private Category category;
    private ProductStatus productStatus;

}