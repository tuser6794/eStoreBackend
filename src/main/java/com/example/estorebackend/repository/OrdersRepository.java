package com.example.estorebackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.estorebackend.model.Orders;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, Integer> {

}
