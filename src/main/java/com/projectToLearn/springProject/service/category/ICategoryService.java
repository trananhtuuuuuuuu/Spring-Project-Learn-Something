package com.projectToLearn.springProject.service.category;

import java.util.List;

import com.projectToLearn.springProject.domain.Category;


public interface ICategoryService {

  List<Category> getAllCategories();



  Category getCategoryById(Long id);




  Category saveCategory(Category category);




  Category updateCategory(Long id, Category category);




  void deleteCategoryById(Long id);


  List<Category> getCategoriesByName(String name);

}
