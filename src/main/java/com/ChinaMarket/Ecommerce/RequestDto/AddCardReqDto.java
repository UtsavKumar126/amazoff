package com.ChinaMarket.Ecommerce.RequestDto;

import com.ChinaMarket.Ecommerce.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddCardReqDto {
    private int customerId;
    private String cardNo;
    private int cvv;
    private CardType cardType;
}
