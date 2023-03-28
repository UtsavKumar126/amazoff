package com.ChinaMarket.Ecommerce.ResponeDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardResonseDto {
    private String name;
    private List<CardDto> cardList=new ArrayList<>();
}
