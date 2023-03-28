package com.ChinaMarket.Ecommerce.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Seller_info")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String mobNo;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String panNo;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> productList=new ArrayList<>();

}
