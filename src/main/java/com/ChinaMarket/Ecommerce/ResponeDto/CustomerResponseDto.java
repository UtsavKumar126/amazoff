package com.ChinaMarket.Ecommerce.ResponeDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {
    private String name;
    private int age;
    private String mobNo;
    private String email;
    private List<CardDto> cardList;
}
