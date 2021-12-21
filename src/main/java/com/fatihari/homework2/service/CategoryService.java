package com.fatihari.homework2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fatihari.homework2.dao.CategoryRepository;
import com.fatihari.homework2.entity.Category;

@Service
public class CategoryService implements ICategoryService
{	
	private CategoryRepository categoryRepository; 
		
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	//@Transactional //Remove @Transactional since JpaRepository provides this functionality.! :)
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}

	@Override
	public Category findById(Long categoryId) {
		Optional<Category> result = this.categoryRepository.findById(categoryId);
		
		Category category = null;
		if(result.isPresent())
			category = result.get();
		else
			throw new RuntimeException("Did not find category id - " + categoryId);
		return category;
	}

	@Override
	public Category save(Category category) 
	{
		return this.categoryRepository.save(category);
	}
	
	public void delete(Category category) 
	{
		this.categoryRepository.delete(category);
	}

	@Override
	public void deleteById(Long categoryId) 
	{	
		this.categoryRepository.deleteById(categoryId);
	}

	@Override
	public Long count() {
		return this.categoryRepository.count();
	}

}
