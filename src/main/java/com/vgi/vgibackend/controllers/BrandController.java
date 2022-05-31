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
import com.vgi.vgibackend.services.BrandService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {

	@Autowired BrandService service;
	
	@GetMapping("/all-brand")
	public List<Brand> getAllBrands(){
		return service.getAllBrands();
	}
	
	@PostMapping("/add-brand")
	public Brand addBrand(@RequestBody Brand brand) {
		return service.addBrand(brand);
	}
	
	@PostMapping("/delete-brand")
	public Boolean deleteBrand(@RequestBody Brand brand) {
		return service.deleteBrand(brand.getBrandName());
	}
}