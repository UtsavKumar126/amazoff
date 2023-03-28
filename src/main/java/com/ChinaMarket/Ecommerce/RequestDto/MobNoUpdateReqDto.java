package com.ChinaMarket.Ecommerce.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobNoUpdateReqDto {
    private int id;
    private String newPhone;
}
