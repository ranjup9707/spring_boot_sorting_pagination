package com.sorting.pagination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sorting.pagination.entity.Product;
import com.sorting.pagination.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//To add the products in the db while the application is starting 
	//or any other pre processing logic then can go with this annotation
	//@PostConstruct is same as init method.
	/*
	@PostConstruct
	public void initDB() {
		List<Product> products = IntStream.rangeClosed(1, 200).mapToObj(i -> new Product("product " + i, new Random().nextInt(100), new Random().nextInt(100))).collect(Collectors.toList());
		productRepository.saveAll(products);
	}*/
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public List<Product> findProductsWithSorting(String field){
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	
	public Page<Product> findProductsWithPagination(int offset, int pageSize){
		Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
		return products;
	}
	
	public Page<Product> findProdutsWithPaginationAndSorting(int offset, int pageSize, String field){
		Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)));
		return products;
	}
	
}
