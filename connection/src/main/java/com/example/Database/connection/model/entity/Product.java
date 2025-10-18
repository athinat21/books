package com.example.Database.connection.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    //eshte nje anotation ne jackson ->libraria qe perdor springboot per te
    //konvertuar objekte java ne json, dhe perodret
    //per te shmang ciklet e pafundme
    private Category category;
}
