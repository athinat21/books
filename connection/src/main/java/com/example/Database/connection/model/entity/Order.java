package com.example.Database.connection.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

//kur krijon nje  @Entity ne spring boot
//jpa automatikisht supozon qe emri i tables eshte i njete me emrin e klases
//por problemi eshte se "ORDER" eshte keyword (reserved word) ne shm databaza
//sepse perooret nje query si ORDER BY
//mese do e linim pa @Tables sql do deshtonte me gabimin: syntax error
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private double price;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;
    //shum porosi (orders) i perkasin nje perdoruesi (useri)
    //do te krijohet nje table orders me nje kolone te re me emrin user_id
    //ne sql qyery
    //create table orders(
    //id biginit autoincrement primary key,
    //order_date DATE
    //total_price DOUBLE
    //user_id BIGINT
    //FOREIGN KEY (user_id) REFERENCES users(id)
}
