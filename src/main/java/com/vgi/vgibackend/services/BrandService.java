package com.vgi.vgibackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vgi.vgibackend.entities.Brand;
import com.vgi.vgibackend.entities.Product;
import com.vgi.vgibackend.repositories.BrandRepository;
import com.vgi.vgibackend.repositories.ProductRepository;

@Service
public class BrandService {
	
	@Autowired BrandRepository repository;
	@Autowired ProductRepository productRepository;
	
	public List<Brand> getAllBrands(){
		return repository.findAll();
	}
	
	public Brand addBrand(Brand brand) {
		return repository.save(brand);
	}
	
	public Boolean deleteBrand(String name) {
		Integer id = repository.findByBrandName(name).get(0).getId();
		List<Product> findAll = productRepository.findAll();
		for(int i=0;i<findAll.size();++i) {
			if(findAll.get(i).getBrandId()==id) {
				productRepository.deleteById(findAll.get(i).getId());
			}
		}
		repository.deleteById(id);
		return true;
	}
	
	public List<Brand> getBrandByName(String name){
		return repository.findByBrandName(name);
	}
}