package com.fatihari.homework2.service;

import java.util.List;
import com.fatihari.homework2.entity.Category;

public interface ICategoryService 
{
	public List<Category> findAll();
	public Category findById(Long categoryId);
	public Category save(Category category);
	public void delete(Category category);
	public void deleteById(Long categoryId);
	public Long count();
}
