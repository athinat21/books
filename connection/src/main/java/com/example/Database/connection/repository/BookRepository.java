package com.example.Database.connection.repository;


import com.example.Database.connection.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//kjo eshte nje interface qe sherben sirepository per entitetin book
//Trashegon JpaRepository qe do te thot merr auto te gjitha metodat baze
//qe ka kjo klase, bejn manipulime te dhenash me databazen
public interface BookRepository extends JpaRepository<Book, Long> {

}
