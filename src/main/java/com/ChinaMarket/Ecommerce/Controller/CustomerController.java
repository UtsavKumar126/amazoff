package com.ChinaMarket.Ecommerce.Controller;

import com.ChinaMarket.Ecommerce.Converter.CustomerConverter;
import com.ChinaMarket.Ecommerce.Exception.CustomerNotFoundException;
import com.ChinaMarket.Ecommerce.Model.Customer;
import com.ChinaMarket.Ecommerce.RequestDto.AddCustomerReqDto;
import com.ChinaMarket.Ecommerce.RequestDto.MobNoUpdateReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CustomerResponseDto;
import com.ChinaMarket.Ecommerce.ResponeDto.CustomerResponseDto2;
import com.ChinaMarket.Ecommerce.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public String addCustomer(@RequestBody AddCustomerReqDto addCustomerReqDto){
       return customerService.addCustomer(addCustomerReqDto);
    }

    @GetMapping("findCustomerById")
    public ResponseEntity findbyid(@RequestParam("id")int id) throws CustomerNotFoundException {
        CustomerResponseDto customerResponseDto;
        try{
            customerResponseDto=customerService.findByid(id);
        }
        catch (CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerResponseDto, HttpStatus.FOUND);
    }
    @GetMapping("findAllCustomers")
    public List<CustomerResponseDto2> findAll(){
        return customerService.findAll();
    }

    @DeleteMapping("deleteById")
    public String removeCustomer(@RequestParam("id")int id){
        return customerService.deleteById(id);
    }

    @GetMapping("findByEmail")
    public CustomerResponseDto2 findByEmail(@RequestParam("email") String email){
        return customerService.findbyEmail(email);
    }

    @PutMapping("updateMobNo")
    public String updatePhone(@RequestBody MobNoUpdateReqDto mobNoUpdateReqDto){
        return customerService.updatePhone(mobNoUpdateReqDto);
    }

    @DeleteMapping("removeAllcards")
    public String removeAllCardsById(@RequestParam("id") int id){
        return customerService.removeAllCards(id);
    }
}
