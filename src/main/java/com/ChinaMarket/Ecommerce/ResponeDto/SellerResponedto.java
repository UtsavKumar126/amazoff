package com.ChinaMarket.Ecommerce.ResponeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerResponedto {
    private String name;
    private String mobNo;
    private String email;
    private String panNo;
}
