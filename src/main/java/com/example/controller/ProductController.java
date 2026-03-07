package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	@PostMapping("/api/product")
	public String saveProduct(@RequestBody Product p) {
		
		return service.saveProductData(p);
	}
	
	@GetMapping("/api/products")
	public List<Product> getAllProducts(@RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize") Integer pageSize){
		return service.getAllProducts(pageNo,pageSize);
	}
	@GetMapping("/api/products/{id}")
	public Product getProductById(@PathVariable Integer id) {
		return service.fetchProductById(id);
	}
	
	
	@PutMapping("/api/price/{name}/{id}")
	public int updateProductName(@PathVariable("name") String name,@PathVariable("id") Integer id) {
		return service.updateProductName(name, id);
	}
	
	@DeleteMapping("/api/delete/{id}")
	public String deleteUpdateName(@PathVariable("id") Integer id) {
		return service.deleteProductById(id);
	}
	
	@PostMapping("/api/products/bulk")
	public String insertProductsBulk(@RequestBody List<Product> products) {
		return service.insertProductsBulk(products);
	}
}
