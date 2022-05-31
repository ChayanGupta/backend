package com.vgi.vgibackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vgi.vgibackend.entities.Brand;
import com.vgi.vgibackend.entities.Product;
import com.vgi.vgibackend.services.BrandService;
import com.vgi.vgibackend.services.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Autowired ProductService service;
	@Autowired BrandService brandService;
	
	@GetMapping("/all-products")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@PostMapping("/add-product")
	public Product addProduct(@RequestBody Product product) {
		List<Brand> brandByName = brandService.getBrandByName(product.getBrandname());
		if(brandByName!=null && brandByName.size()!=0)
			product.setBrandId(brandByName.get(0).getId());
		else {
			Brand brand = new Brand();
			brand.setBrandName(product.getBrandname());
			Brand addBrand = brandService.addBrand(brand);
			product.setBrandId(addBrand.getId());
		}
		Product p = service.addProduct(product);
		p.setBrandname(product.getBrandname());
		return p;
	}
	
	@PostMapping("/delete-product")
	public Boolean deleteProduct(@RequestBody Product product) {
		return service.deleteProduct(product.getId());
	}
	
	@PostMapping("/fetch-products")
	public List<Product> fetchProductByBrand(@RequestBody Brand brand){
		return service.fetchAllProductByBrand(brand.getId());
	}
}