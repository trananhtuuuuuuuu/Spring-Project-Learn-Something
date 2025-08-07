package com.projectToLearn.springProject.service.category;

import java.util.List;
import java.util.Locale.Category;

public interface ICategoryService {

  List<Category> getAllCategories();



  Category getCategoryById(Long id);




  Category saveCategory(Category category);




  Category updateCategory(Category category);




  void deleteCategoryById(Long id);


  List<Category> getCategoriesByName(String name);

}
