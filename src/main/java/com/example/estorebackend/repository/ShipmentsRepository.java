package com.example.estorebackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.estorebackend.model.Shipments;

@Repository
public interface ShipmentsRepository extends CrudRepository<Shipments, Integer> {

}
