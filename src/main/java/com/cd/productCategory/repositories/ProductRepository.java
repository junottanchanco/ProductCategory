package com.cd.productCategory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cd.productCategory.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
