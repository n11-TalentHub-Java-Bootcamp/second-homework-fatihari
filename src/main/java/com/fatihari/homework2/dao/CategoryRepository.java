package com.fatihari.homework2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatihari.homework2.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
	
}
