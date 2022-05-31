package com.vgi.vgibackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vgi.vgibackend.entities.Brand;
import com.vgi.vgibackend.entities.Product;
import com.vgi.vgibackend.repositories.BrandRepository;
import com.vgi.vgibackend.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired ProductRepository repository;
	@Autowired BrandRepository brandRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = repository.findAll();
		for(int i=0;i<products.size();++i) {
			Brand b= brandRepository.findById(products.get(i).getBrandId()).get();
			System.out.println(b.getBrandName());
			products.get(i).setBrandname(b.getBrandName());
		}
		return products;
	}
	
	public Product addProduct(Product product) {
		return repository.save(product);
	}
	
	public Boolean deleteProduct(Integer id) {
		Optional<Product> product = repository.findById(id);
		Integer brandId;
		if(product.isPresent()) {
			brandId = product.get().getBrandId();
			repository.deleteById(id);
			List<Product> findById = repository.findByBrandId(brandId);
			if(findById.isEmpty()) {
				brandRepository.deleteById(brandId);
			}
		}
		
		return true;
	}
	
	public Boolean deleteAllProducts(Integer id) {
		repository.deleteAllProductByBrand(id);
		return true;
	}
	
	public List<Product> fetchAllProductByBrand(Integer id){
		List<Product> products = repository.findByBrandId(id);
		for(int i=0;i<products.size();++i) {
			Brand b= brandRepository.findById(products.get(i).getBrandId()).get();
			System.out.println(b.getBrandName());
			products.get(i).setBrandname(b.getBrandName());
		}
		return products;
	}
}