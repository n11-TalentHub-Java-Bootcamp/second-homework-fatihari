package com.fatihari.homework2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatihari.homework2.dao.ProductRepository;

import com.fatihari.homework2.entity.Product;

@Service
public class ProductService implements IProductService 
{
	private ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> findAll() 
	{
		return this.productRepository.findAll();
	}

	@Override
	public Product findById(Long productId) 
	{
		Optional<Product> result = this.productRepository.findById(productId);
		Product product = null;
		
		if(result.isPresent())
			product = result.get();
		else
			throw new RuntimeException("Did not find product id - " + productId);
		return product;
	}
	
	@Override
	public Product saveOrUpdate(Product product) 
	{
		return this.productRepository.save(product);
	}
	
	public void delete(Product product) 
	{
		this.productRepository.delete(product);
	}

	@Override
	public void deleteById(Long productId) 
	{	
		this.productRepository.deleteById(productId);
	}

	@Override
	public Long count() {
		return this.productRepository.count();
	}
	
	/* @Override
	public List<Product> findAllProductListByPrice(BigDecimal priceGe, BigDecimal priceLe) 
	{	
		return this.productRepository.findAllProductListByPrice(priceGe, priceLe);
	}

	@Override
	public List<Product> findAllProductListByPriceBetween(BigDecimal priceGe, BigDecimal priceLe) 
	{
		return this.productRepository.findAllProductListByPriceBetween(priceGe, priceLe);
	}

	@Override
	public List<Product> findAllProductByCategoryRefractive(Long refractive) 
	{
		return this.productRepository.findAllProductByCategoryRefractive(refractive);
	}

	@Override
	public List<ProductDetailDTO> findAllProductDetailDtoByCategoryRefractive(Long refractive) {
		return this.productRepository.findAllProductDetailDtoByCategoryRefractive(refractive);
	}*/
}
