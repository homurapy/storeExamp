package com.example.storeExamp.repository;

import com.example.storeExamp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
Category getByName(String name);
}
