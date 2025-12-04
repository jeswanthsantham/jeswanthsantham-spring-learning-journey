package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.productapp.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{
	
	
	//derived queries
	// findBy, queryBy, getBy, readBy
	
	List<Product> findBybrand(String brand);
	List<Product> findByCategoryAndProductNameContains(String category, String productName);
	List<Product> findByPriceLessThan(double price);
	
	//custom query
    //any method name
	//should be annotated with @query annotation-use JPQL 
	//use ONLY entity name- first letter capital and only properties
	
	@Query("from Product p where p.category=?1")
	List<Product> findByCat(String category);
	@Query("from Product p where p.brand=?1 and p.price<?2")
	List<Product> findByBrandPrice(String brand, double price);
	//text block """ """
	@Query("""
			from Product p where p.category=?1 
			and p.productName like ?2
			""")
	List<Product> findByCatAndName(String category, String productName);
	
	@Query("from Product p where p.productName like:name")
	List<Product> findByNameContains(@Param("name") String name);
	
	//native query-- write query in sql
	@Query(value = "select * from product where cost>?1",nativeQuery = true)
	List<Product> findByGreaterPrice(double price);
	
	//namedQuery
	@Query(name = "findByBrandAndCat")
	List<Product> findByBrandAndCategory(String brand, String category);
	
	@Query(value="update product set cost=?2 where product_Id=?1", nativeQuery = true)
	@Modifying
	void updateProduct(long productId, double price);
	

}
