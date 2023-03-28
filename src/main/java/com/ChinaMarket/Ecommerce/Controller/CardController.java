package com.ChinaMarket.Ecommerce.Controller;

import com.ChinaMarket.Ecommerce.Exception.CustomerNotFoundException;
import com.ChinaMarket.Ecommerce.RequestDto.AddCardReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CardResonseDto;
import com.ChinaMarket.Ecommerce.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody AddCardReqDto addCardReqDto) throws CustomerNotFoundException {
        CardResonseDto cardResonseDto;
        try {
            cardResonseDto=cardService.addCard(addCardReqDto);
        }
        catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
       return new ResponseEntity<>(cardResonseDto,HttpStatus.CREATED);
    }

    @DeleteMapping("removeCard")
    public String removeCard(@RequestParam("id")int cardId){
        return cardService.removeCard(cardId);
    }
}
