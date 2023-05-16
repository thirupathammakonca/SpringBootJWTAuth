package com.thiruacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.thiruacademy.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
