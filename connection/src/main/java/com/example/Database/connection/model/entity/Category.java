package com.example.Database.connection.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //nje kategori ka shm produkte
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    //cascade-> kur fshin nje kategori , veprimi aplikohet dhe tk produktet e saj
    //nese fshin nje kategori electronics qe ka 100 produkte, do te fshihen edhe ato

    // orphanRemoval = true, nese nje produkt hiqet nga lista  products, fshihet nga databaza
    //fshihet edhe nga category
    @JsonBackReference
    private List<Product> products = new ArrayList<>();

}
