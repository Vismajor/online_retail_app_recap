package com.codeclan.example.online_retail_app.repositories;

import com.codeclan.example.online_retail_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByItemsId(Long id);
    User findByName(String name);
}
