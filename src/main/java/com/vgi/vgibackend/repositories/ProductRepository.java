package com.vgi.vgibackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vgi.vgibackend.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("delete from Product u where u.brandId=:brandId")
	public void deleteAllProductByBrand(@Param("brandId") Integer brandId);
	
	public List<Product> findByBrandId(Integer brandId);
	
}