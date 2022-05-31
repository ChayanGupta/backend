package com.vgi.vgibackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vgi.vgibackend.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	public List<Brand> findByBrandName(String brandName);
}