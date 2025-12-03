package com.productapp.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotfoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

//	@Autowired
	private final IProductRepository productRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void addProduct(ProductDto productDto) {
//      Product product = new Product();
//      product.setProductName(productDto.getProductName());
		// convert productdto obj to product obj
		Product product = mapper.map(productDto, Product.class);
		// call the method of repository
		// check if the Id is available
		// if Id is not, Autogenerate the id and save the object as a row
		// if available,check whether there is an existing row then update else create a new row

		productRepository.save(product);

	}

	@Override
	public void updateProduct(ProductDto productDto) {
		// convert productdto obj to productentity obj
		Product product = mapper.map(productDto, Product.class);
		// call the method of repository

		productRepository.save(product);

	}

	@Override
	public void deleteProduct(long productId) {

		productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDto> getAll() {
//		List<ProductDto> productDtos = new ArrayList<>();
//		List<Product> products = productRepository.findAll();
//		for (Product product : products) {
//			//convert entity to dto obj
//			ProductDto productDto = mapper.map(product, ProductDto.class);
//			productDtos.add(productDto);
//			}
//		return productDtos ;
		
		// convert list into a stream
		List<ProductDto> productDtos = productRepository.findAll().stream()
		// convert one by one entity to dto obj
		.map(product->mapper.map(product, ProductDto.class))
		.toList();
     return productDtos;
	}

	@Override
	public ProductDto getById(long productId) throws ProductNotfoundException {
		Product product = productRepository.findById(productId)
		.orElseThrow(()-> new ProductNotfoundException("invalid id"));
		return mapper.map(product, ProductDto.class);
		
	}

	@Override
	public List<ProductDto> getByBrand(String brand) throws ProductNotfoundException {
		List<ProductDto> productDtos = productRepository.findBybrand(brand).stream()
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty()) {
			throw new ProductNotfoundException("product with this brand not found");
		}
		     return productDtos;
	}

	@Override
	public List<ProductDto> getByLesserPrice(double price) throws ProductNotfoundException {
		List<ProductDto> productDtos = productRepository.findByPriceLessThan(price).stream()
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty()) {
			throw new ProductNotfoundException("product with this brand not found");
		}
		     return productDtos;
	}

	@Override
	public List<ProductDto> getBycategoryandNameContains(String category, String name) throws ProductNotfoundException {
		List<ProductDto> productDtos = productRepository.findByCategoryAndProductNameContains(category, name).stream()
				.map(product->mapper.map(product, ProductDto.class))
				.toList();
		if(productDtos.isEmpty()) {
			throw new ProductNotfoundException("product with this brand not found");
		}
		     return productDtos;
	}

}
