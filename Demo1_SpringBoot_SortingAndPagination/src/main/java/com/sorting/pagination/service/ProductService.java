package com.sorting.pagination.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorting.pagination.entity.Product;
import com.sorting.pagination.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostConstruct
	public void initDB() {
		List<Product> products = IntStream.rangeClosed(1, 200).mapToObj(i -> new Product("product " + i, new Random().nextInt(100), new Random().nextInt(100))).collect(Collectors.toList());
		productRepository.saveAll(products);
	}
	
}
