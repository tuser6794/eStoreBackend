package com.example.estorebackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.estorebackend.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

}
