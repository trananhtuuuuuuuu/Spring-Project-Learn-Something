package com.projectToLearn.springProject.service.category;


import java.util.List;


import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.exception.AlreadyExistsExeption;
import com.projectToLearn.springProject.exception.ResourceNotFoundException;
import com.projectToLearn.springProject.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public void deleteCategoryById(Long id) {
    Category categoryFromDb = this.categoryRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    categoryFromDb.setName("null"); // avoid warning
    this.categoryRepository.deleteById(id);  
  }

  @Override
  public List<Category> getAllCategories() {
    return this.categoryRepository.findAll();
  }

  @Override
  public Category getCategoriesByName(String name) {
    return this.categoryRepository.findByName(name);
  }

  @Override
  public Category getCategoryById(Long id) {
    return this.categoryRepository.findById(id).get();
  }

  @Override
  public Category saveCategory(Category category) {
    if(this.categoryRepository.existsByName(category.getName())){
      throw new AlreadyExistsExeption(category.getName() + "already exists");
    }
    return this.categoryRepository.save(category);
  }

  @Override
  public Category updateCategory(Long id, Category category) {
    Category categoryFromDb = this.categoryRepository.findById(id)
    .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    categoryFromDb.setName(category.getName());
    return this.categoryRepository.save(categoryFromDb);
  }
  
}
