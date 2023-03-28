package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Enum.ProductStatus;
import com.ChinaMarket.Ecommerce.Exception.CustomerNotFoundException;
import com.ChinaMarket.Ecommerce.Exception.ProductNotFoundException;
import com.ChinaMarket.Ecommerce.Model.*;
import com.ChinaMarket.Ecommerce.Repository.CustomerRepository;
import com.ChinaMarket.Ecommerce.Repository.ProductRepository;
import com.ChinaMarket.Ecommerce.RequestDto.PlaceOrderReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.ItemResponseDto;
import com.ChinaMarket.Ecommerce.ResponeDto.OrderRespDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemService itemService;
    @Autowired
    ProductRepository productRepository;
    public OrderRespDto placeOrder(PlaceOrderReqDto placeOrderReqDto) throws Exception {


        Customer customer;
        try{
            customer=customerRepository.findById(placeOrderReqDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }

        Product product;
        try {
            product=productRepository.findById(placeOrderReqDto.getProductId()).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Invalid product Id");
        }

        if(product.getQuantity()< placeOrderReqDto.getReqQuantity()){
            throw new Exception("Insufficient Quantity");
        }

        Ordered ordered=new Ordered();

        ordered.setTotalCost(placeOrderReqDto.getReqQuantity()* product.getPrice());
        ordered.setDeliveryCharge(40);

        Card card=customer.getCardList().get(0);
        String cardNo="";

        for(int i=0;i<card.getCardNo().length()-4;i++) {
            cardNo += 'x';
        }
        cardNo+=card.getCardNo().substring(card.getCardNo().length()-4);
        ordered.setCardForPayment(cardNo);

        Item item=new Item();
        item.setRequiredQuantity(placeOrderReqDto.getReqQuantity());
        item.setProduct(product);
        item.setOrdered(ordered);

        ordered.getItems().add(item);
        ordered.setCustomer(customer);

        customer.getOrderedList().add(ordered);

        int leftQuantity= product.getQuantity()-placeOrderReqDto.getReqQuantity();
        if(leftQuantity<=0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }

        product.setQuantity(leftQuantity);

        Customer savedCustomer=customerRepository.save(customer);

        Ordered saved=savedCustomer.getOrderedList().get(savedCustomer.getOrderedList().size()-1);

        OrderRespDto orderRespDto=OrderRespDto.builder()
                .productName(product.getName())
                .orderDate(saved.getOrderDate())
                .orderQuantity(placeOrderReqDto.getReqQuantity())
                .cardForPayment(cardNo)
                .itemPrice(product.getPrice())
                .totalCost(ordered.getTotalCost())
                .deliveryCharge(40)
                .build();

        return orderRespDto;

    }
}
