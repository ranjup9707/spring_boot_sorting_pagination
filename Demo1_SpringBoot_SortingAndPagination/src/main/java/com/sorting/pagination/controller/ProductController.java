package com.sorting.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sorting.pagination.entity.APIResponse;
import com.sorting.pagination.entity.Product;
import com.sorting.pagination.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	private APIResponse<List<Product>> getProducts(){
		List<Product> allProduct = productService.getAllProduct();
		return new APIResponse<>(allProduct.size(), allProduct);
	}
	
	//Sort by field
	@GetMapping("/{field}")
	private APIResponse<List<Product>> getProductsWithSorting(@PathVariable String field){
		List<Product> sortedProduct = productService.findProductsWithSorting(field);
		return new APIResponse<>(sortedProduct.size(), sortedProduct);
	}
	
	//Pagination
	@GetMapping("/pagination/{offset}/{pageSize}")
	private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize){
		return new APIResponse<>(productService.findProductsWithPagination(offset, pageSize).getSize(), productService.findProductsWithPagination(offset, pageSize));
	}
	
	//Sort and Pagination
	@GetMapping("/pagination/{offset}/{pageSize}/{field}")
	private APIResponse<Page<Product>> getProductsWithSortingAndPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		return new APIResponse<>(productService.findProdutsWithPaginationAndSorting(offset, pageSize, field).getSize(), productService.findProdutsWithPaginationAndSorting(offset, pageSize, field));
	}
}
