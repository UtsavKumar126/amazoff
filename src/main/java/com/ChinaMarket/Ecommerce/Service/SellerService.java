package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Converter.SellerConverter;
import com.ChinaMarket.Ecommerce.Exception.SellerNotFoundException;
import com.ChinaMarket.Ecommerce.RequestDto.AddSellerReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.SellerResponedto;
import com.ChinaMarket.Ecommerce.Model.Seller;
import com.ChinaMarket.Ecommerce.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(AddSellerReqDto addSellerReqDto) {

        Seller seller= SellerConverter.SellerReqDtoToSeller(addSellerReqDto);

        sellerRepository.save(seller);
        return "Seller added Successfully with id :- "+seller.getId();
    }

    public List<SellerResponedto> findAllSeller() {

        List<Seller>sellerList=sellerRepository.findAll();

        List<SellerResponedto>reqList=new ArrayList<>();

        for(Seller seller:sellerList){

            SellerResponedto sellerResponedto=SellerConverter.SellertoDto(seller);

            reqList.add(sellerResponedto);
        }
        return reqList;
    }

    public SellerResponedto findByPan(String panNo) throws SellerNotFoundException {

        Seller seller=sellerRepository.findByPanNo(panNo);
        if(seller==null)throw new SellerNotFoundException("Seller doesn't exist");
        else {
            SellerResponedto sellerResponedto = SellerConverter.SellertoDto(seller);
            return sellerResponedto;
        }
    }

    public String deletebyId(int id) {

        sellerRepository.deleteById(id);

        return "Nikal pehli fursat mein nikal";
    }
}
