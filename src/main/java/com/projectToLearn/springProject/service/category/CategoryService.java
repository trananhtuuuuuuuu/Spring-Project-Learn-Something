package com.projectToLearn.springProject.service.category;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Category;
import com.projectToLearn.springProject.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {

  private CategoryRepository categoryRepository;

  @Override
  public void deleteCategoryById(Long id) {
    this.categoryRepository.deleteById(id);  
  }

  @Override
  public List<Category> getAllCategories() {
    return this.categoryRepository.findAll();
  }

  @Override
  public List<Category> getCategoriesByName(String name) {
    List<Category> categories = new ArrayList<>();
    List<Category> categorisFromDb = this.categoryRepository.findAll();
    for(Category c : categorisFromDb){
      if(c.getName().equals(name)){
        categories.add(c);
      }
    }
    return categories;
  }

  @Override
  public Category getCategoryById(Long id) {
    return this.categoryRepository.findById(id).get();
  }

  @Override
  public Category saveCategory(Category category) {
    return this.categoryRepository.save(category);
  }

  @Override
  public Category updateCategory(Long id, Category category) {
    Category categoryFromDb = this.categoryRepository.findById(id).get();
    categoryFromDb.setName(category.getName());
    return categoryFromDb;
  }
  
}
