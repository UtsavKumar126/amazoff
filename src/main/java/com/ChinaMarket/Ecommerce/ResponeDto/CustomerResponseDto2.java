package com.ChinaMarket.Ecommerce.ResponeDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponseDto2 {

    private String name;
    private int age;
    private String mobNo;
    private String email;
}
