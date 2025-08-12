package com.projectToLearn.springProject.service.productShop;


import com.projectToLearn.springProject.domain.ProductShop;
import com.projectToLearn.springProject.request.AddProductShopRequest;

public interface IProductShopService {
  ProductShop saveProductShop(AddProductShopRequest addProductShopRequest);

  ProductShop updateProductShopById(Long id, AddProductShopRequest addProductShopRequest);

  ProductShop deleteProductShopById(Long id);
}
