package com.example.estorebackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.estorebackend.model.OrderItems;

@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItems, Integer> {

}
