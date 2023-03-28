package com.ChinaMarket.Ecommerce.Service;

import com.ChinaMarket.Ecommerce.Converter.ProductConverter;
import com.ChinaMarket.Ecommerce.RequestDto.ProductAddReqDto;
import com.ChinaMarket.Ecommerce.RequestDto.UpdatePriceReqDto;
import com.ChinaMarket.Ecommerce.ResponeDto.ProductResponeDto;
import com.ChinaMarket.Ecommerce.Enum.Category;
import com.ChinaMarket.Ecommerce.Enum.ProductStatus;
import com.ChinaMarket.Ecommerce.Exception.SellerNotFoundException;
import com.ChinaMarket.Ecommerce.Model.Product;
import com.ChinaMarket.Ecommerce.Model.Seller;
import com.ChinaMarket.Ecommerce.Repository.ProductRepository;
import com.ChinaMarket.Ecommerce.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  ProductService {
    @Autowired
    SellerRepository sellerRepository;
    @Autowired
    ProductRepository productRepository;
    public ProductResponeDto addProduct(ProductAddReqDto productAddReqDto) throws SellerNotFoundException {
        Seller seller;
        try {
            seller = sellerRepository.findById(productAddReqDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Seller doesn't exist");
        }

        Product product= ProductConverter.ProductResponseDtoProduct(productAddReqDto);
        product.setSeller(seller);
        seller.getProductList().add(product);

        sellerRepository.save(seller);

        ProductResponeDto productResponeDto=ProductConverter.ProductToResponseDto(product);

        return productResponeDto;
    }

    public List<ProductResponeDto> findByCategory(Category category) {

        List<Product>productList=productRepository.findByCategory(category);

        List<ProductResponeDto>reqlist=new ArrayList<>();

        for(Product product:productList){
            ProductResponeDto productResponeDto=ProductConverter.ProductToResponseDto(product);
            reqlist.add(productResponeDto);
        }

        return reqlist;
    }

    public List<ProductResponeDto> findLeastFive() {

        List<Product>productList=productRepository.findFiveLeastValueProduct();

        List<ProductResponeDto>returnList=new ArrayList<>();

        for(Product p:productList){
            ProductResponeDto productResponeDto=ProductConverter.ProductToResponseDto(p);

            returnList.add(productResponeDto);
        }
        return returnList;
    }

    public String deleteById(int id) {

        productRepository.deleteById(id);

        return "Product removed successfully";
    }

    public ProductResponeDto updatePrice(UpdatePriceReqDto updatePriceReqDto){

        Product product=productRepository.findById(updatePriceReqDto.getId()).get();
        product.setPrice(updatePriceReqDto.getValue());

        productRepository.save(product);

        ProductResponeDto productResponeDto=ProductConverter.ProductToResponseDto(product);

        return productResponeDto;
    }
}
