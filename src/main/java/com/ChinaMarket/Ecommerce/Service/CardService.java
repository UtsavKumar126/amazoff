package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Exception.CustomerNotFoundException;
import com.ChinaMarket.Ecommerce.Model.Card;
import com.ChinaMarket.Ecommerce.Model.Customer;
import com.ChinaMarket.Ecommerce.Repository.CardRepository;
import com.ChinaMarket.Ecommerce.Repository.CustomerRepository;
import com.ChinaMarket.Ecommerce.RequestDto.AddCardReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CardDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CardResonseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;
    @Autowired
    CustomerRepository customerRepository;

    public CardResonseDto addCard(AddCardReqDto addCardReqDto) throws CustomerNotFoundException {
        Customer customer;
        try{
            customer=customerRepository.findById(addCardReqDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }

        Card card= Card.builder()
                .cardNo(addCardReqDto.getCardNo())
                .cvv(addCardReqDto.getCvv())
                .cardType(addCardReqDto.getCardType())
                .customer(customer)
                .build();

        customer.getCardList().add(card);

        customerRepository.save(customer);

        CardResonseDto cardResonseDto=new CardResonseDto();
        cardResonseDto.setName(customer.getName());

        List<CardDto> reqList=new ArrayList<>();
        for(Card cards: customer.getCardList()){
            CardDto cardDto=new CardDto();
            cardDto.setCardNo(cards.getCardNo());
            cardDto.setCardType(cards.getCardType());

            reqList.add(cardDto);
        }
        cardResonseDto.setCardList(reqList);
        return cardResonseDto;
    }

    public String removeCard(int cardId) {
        Card card=cardRepository.findById(cardId).get();
        cardRepository.deleteById(cardId);
        return "Card "+card.getCardNo()+" deleted Successfully";
    }
}
