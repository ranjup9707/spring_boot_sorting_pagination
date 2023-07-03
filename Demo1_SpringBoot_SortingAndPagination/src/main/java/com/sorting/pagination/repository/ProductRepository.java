package com.sorting.pagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorting.pagination.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
