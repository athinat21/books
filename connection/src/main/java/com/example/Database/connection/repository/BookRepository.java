package com.example.Database.connection.repository;


import com.example.Database.connection.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//kjo eshte nje interface qe sherben sirepository per entitetin book
//Trashegon JpaRepository qe do te thot merr auto te gjitha metodat baze
//qe ka kjo klase, bejn manipulime te dhenash me databazen
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findFirstByOrderByYearPublishedDesc(); // -> where year_published BETWEEN ? AND ?

    //spring data jpa lexon emrin e metodes dhe e perkthen automatikisht ne nje query sql
    //kjo quhet query method derivation
    //find -> tregon qe po behet nje kerkim (SELECT)
    //byorder -> i filtron
    //desc -> renditje

    //findByName -> where name = ? ->variabli qe vendosim ne
    //findByPriceGreaterThan -> where price > ?
}
