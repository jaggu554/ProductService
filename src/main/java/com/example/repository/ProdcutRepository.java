package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.product.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProdcutRepository extends JpaRepository<Product,Integer> {

	@Modifying
	@Transactional
	@Query(value="update Product as p set p.product_name=:name where p.product_id=:id",nativeQuery = true)
	public int updateProduct(@Param("name") String name,@Param("id") Integer id);
	
	
	@Modifying
	@Transactional
	@Query(value="delete from Product as p where p.product_id=:id",nativeQuery=true)
	public void deleteProduct(@Param("id") Integer id);
	
	@Modifying
	@Transactional
	@Query(value="insert into Product(product_name,product_price,product_quantity) values (:name,:price,:quantity)",nativeQuery=true)
	public void insertProduct(String name,Float price,String quantity);
	
}
	