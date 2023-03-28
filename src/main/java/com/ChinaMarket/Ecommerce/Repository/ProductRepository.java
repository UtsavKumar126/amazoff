package com.ChinaMarket.Ecommerce.Repository;

import com.ChinaMarket.Ecommerce.Enum.Category;
import com.ChinaMarket.Ecommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByCategory(Category category);

    @Query(value = "Select * from product_info order by price limit 5",nativeQuery = true)
    List<Product> findFiveLeastValueProduct();
}
