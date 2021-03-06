package com.example.storeExamp.repository;

import com.example.storeExamp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository <Item, Long>, JpaSpecificationExecutor<Item> {
    List<Item> findAllByName(String name);

}
