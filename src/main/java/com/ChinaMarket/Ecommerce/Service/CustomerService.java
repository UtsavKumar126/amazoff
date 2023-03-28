package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Converter.CustomerConverter;
import com.ChinaMarket.Ecommerce.Exception.CustomerNotFoundException;
import com.ChinaMarket.Ecommerce.Model.Card;
import com.ChinaMarket.Ecommerce.Model.Cart;
import com.ChinaMarket.Ecommerce.Model.Customer;
import com.ChinaMarket.Ecommerce.Repository.CardRepository;
import com.ChinaMarket.Ecommerce.Repository.CustomerRepository;
import com.ChinaMarket.Ecommerce.RequestDto.AddCustomerReqDto;
import com.ChinaMarket.Ecommerce.RequestDto.MobNoUpdateReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CardDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CustomerResponseDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CustomerResponseDto2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CardRepository cardRepository;
    public String addCustomer(AddCustomerReqDto addCustomerReqDto) {

        Customer customer= CustomerConverter.customerDtoToCustomer(addCustomerReqDto);

        Cart cart=new Cart();
        cart.setCartTotal(0);
        cart.setCustomer(customer);

        customer.setCart(cart);

        customerRepository.save(customer);

        return "Welcome to China Market...!";

    }

    public CustomerResponseDto findByid(int id) throws CustomerNotFoundException {

        Customer customer;
        try{
            customer=customerRepository.findById(id).get();
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Invalid id");
        }

        List<Card> cardList=customer.getCardList();
        List<CardDto>reqList=new ArrayList<>();

        for(Card card:cardList){
            CardDto cardDto=new CardDto();
            cardDto.setCardNo(card.getCardNo());
            cardDto.setCardType(card.getCardType());

            reqList.add(cardDto);
        }

        CustomerResponseDto customerResponseDto=CustomerResponseDto.builder()
                .name(customer.getName())
                .mobNo(customer.getMobNo())
                .age(customer.getAge())
                .email(customer.getEmail())
                .cardList(reqList)
                .build();

        return customerResponseDto;
    }

    public List<CustomerResponseDto2> findAll() {

        List<Customer>customerList=customerRepository.findAll();

        List<CustomerResponseDto2>reqlist=new ArrayList<>();

        for(Customer customer:customerList){
            CustomerResponseDto2 customerResponseDto2=CustomerResponseDto2.builder()
                    .name(customer.getName())
                    .age(customer.getAge())
                    .email(customer.getEmail())
                    .mobNo(customer.getMobNo())
                    .build();
            reqlist.add(customerResponseDto2);
        }

        return reqlist;
    }

    public String deleteById(int id) {
        customerRepository.deleteById(id);
        return "Khela hobe";
    }

    public CustomerResponseDto2 findbyEmail(String email){

        Customer customer=customerRepository.findByEmail(email);

        CustomerResponseDto2 customerResponseDto2=CustomerResponseDto2.builder()
                .name(customer.getName())
                .mobNo(customer.getMobNo())
                .email(customer.getEmail())
                .age(customer.getAge())
                .build();

        return customerResponseDto2;
    }

    public String updatePhone(MobNoUpdateReqDto mobNoUpdateReqDto) {
        Customer customer=customerRepository.findById(mobNoUpdateReqDto.getId()).get();

        customer.setMobNo(mobNoUpdateReqDto.getNewPhone());

        customerRepository.save(customer);

        return "Dear "+customer.getName()+
                " Your Mobile number has been successfully updated to "
                +mobNoUpdateReqDto.getNewPhone();
    }

    public String removeAllCards(int id) {

        Customer customer=customerRepository.findById(id).get();

        cardRepository.deleteAll(customer.getCardList());
        return "removed successfully";
    }
}
