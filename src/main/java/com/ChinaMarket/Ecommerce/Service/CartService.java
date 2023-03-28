package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Exception.CustomerNotFoundException;
import com.ChinaMarket.Ecommerce.Exception.ProductNotFoundException;
import com.ChinaMarket.Ecommerce.Model.Cart;
import com.ChinaMarket.Ecommerce.Model.Customer;
import com.ChinaMarket.Ecommerce.Model.Item;
import com.ChinaMarket.Ecommerce.Model.Product;
import com.ChinaMarket.Ecommerce.Repository.CustomerRepository;
import com.ChinaMarket.Ecommerce.Repository.ProductRepository;
import com.ChinaMarket.Ecommerce.RequestDto.PlaceOrderReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;

    public String addToCart(PlaceOrderReqDto placeOrderReqDto) throws Exception {
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

        Cart cart=customer.getCart();

        cart.setCartTotal(cart.getCartTotal()+placeOrderReqDto.getReqQuantity()* product.getPrice());

        //make item

        Item item=new Item();
        item.setRequiredQuantity(placeOrderReqDto.getReqQuantity());
        item.setCart(cart);
        item.setProduct(product);

        cart.getItemList().add(item);

        customerRepository.save(customer);

        return "item has been added ";
    }

    //view cart

}
