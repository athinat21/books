package com.example.Database.connection.repository;

import com.example.Database.connection.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
