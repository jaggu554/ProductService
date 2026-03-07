package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.exception.ProductException;
import com.example.product.Product;
import com.example.repository.ProdcutRepository;

@Service
public class ProductService {

	@Autowired
	private ProdcutRepository repo;
	
	public String saveProductData(Product p) {
		
		repo.save(p);
		
		return "Product saved sucessfully";
	}
	
	public Product fetchProductById(Integer id) {
		
		return repo.findById(id).orElseThrow(()->  new ProductException("Product not find with id :"+id) );
	}
	
	public List<Product> getAllProducts(Integer pageNo,Integer pageSize){
		PageRequest page=PageRequest.of(pageNo, pageSize);
		return repo.findAll(page).getContent();
	}
	
	public int updateProductName(String name,Integer id) {
		return repo.updateProduct(name, id);
	}
	
	public String deleteProductById(Integer id) {
		repo.deleteProduct(id);
		return "Product Saved Successfully,,,";
	}
	
	public String insertProductsBulk(List<Product> product) {
		
		for(Product p:product) {
			repo.insertProduct(p.getProductName(), p.getProductPrice(), p.getProductQuantity());
		}
		return "Multiple Products Saved Successfully...";
	}
}
