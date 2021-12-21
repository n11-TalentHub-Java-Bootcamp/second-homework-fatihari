package com.fatihari.homework2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatihari.homework2.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>
{
	
}
