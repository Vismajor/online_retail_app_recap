package com.codeclan.example.online_retail_app.repositories;

import com.codeclan.example.online_retail_app.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByUsersId(long id);
}
