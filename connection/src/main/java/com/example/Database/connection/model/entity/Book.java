package com.example.Database.connection.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//kjo klase eshte nje entitet qe perfaqeson nje tabele ne databaze
//hiberante do ta perdore per te menaxhuar dhe krijuar rreshat e tabeles book

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    // kjo fushe eshte celesi primar i tabeles
    //@ID tregon qe id eshte identifikuesi unik i cdo libri
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private int yearPublished;
}
