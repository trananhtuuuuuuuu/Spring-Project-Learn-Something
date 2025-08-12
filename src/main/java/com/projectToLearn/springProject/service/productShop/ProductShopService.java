package com.projectToLearn.springProject.service.productShop;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectToLearn.springProject.domain.Product;
import com.projectToLearn.springProject.domain.ProductShop;
import com.projectToLearn.springProject.domain.Shop;
import com.projectToLearn.springProject.exception.AlreadyExistsExeption;
import com.projectToLearn.springProject.exception.IdNotFoundException;
import com.projectToLearn.springProject.repository.ProductShopRepository;
import com.projectToLearn.springProject.request.AddProductShopRequest;
import com.projectToLearn.springProject.service.product.ProductService;
import com.projectToLearn.springProject.service.shop.ShopService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductShopService implements IProductShopService{

  private final ProductService productService;
  private final ShopService shopService;
  private final ProductShopRepository productShopRepository;

  
  @Override
  public ProductShop deleteProductShopById(Long id) {
    ProductShop productShop = this.productShopRepository.findById(id)
    .orElseThrow(() -> new IdNotFoundException("Not found"));
    this.productShopRepository.deleteById(id);
    return productShop;
  }

  @Override
  @Transactional
  public ProductShop saveProductShop(AddProductShopRequest addProductShopRequest) {
    List<Product> products = this.productService.getProductsByBrandAndName(addProductShopRequest.getNameBrand(),
     addProductShopRequest.getNameProduct());

    List<Shop> shops = this.shopService.getShopByName(addProductShopRequest.getNameShop());

    if(products.isEmpty() || shops.isEmpty()){
      throw new IllegalArgumentException("Not found");
    }

    ProductShop productShop = new ProductShop();

    productShop.setProduct(products.get(0));
    productShop.setShop(shops.get(0));

    ProductShop savedProduct = this.productShopRepository.save(
      productShop
    );


    return savedProduct;
  }

  @Override
  public ProductShop updateProductShopById(
    Long id, 
    AddProductShopRequest addProductShopRequest
  ) {
    ProductShop productShop = this.productShopRepository.findById(id)
    .orElseThrow(() -> new IdNotFoundException("Not found"));

    Product newProductGetFromRequest = this.productService.getProductsByBrandAndName(
      addProductShopRequest.getNameBrand(), addProductShopRequest.getNameProduct()
      ).get(0);

    Shop newShopGetFromRequest = this.shopService.getShopByName(
      addProductShopRequest.getNameShop()
    ).get(0);

    if(this.productShopRepository.existsByProductAndShop(newProductGetFromRequest, newShopGetFromRequest) &&
      !newProductGetFromRequest.equals(productShop.getProduct()) || 
      !newShopGetFromRequest.equals(productShop.getShop())
    ){
      throw new AlreadyExistsExeption("This product-shop combination already exists");
    }

    productShop.setProduct(newProductGetFromRequest);
    productShop.setShop(newShopGetFromRequest);

  
    
    return this.productShopRepository.save(productShop);
  }
  
}
