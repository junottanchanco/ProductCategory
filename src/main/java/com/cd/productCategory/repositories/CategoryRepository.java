package com.cd.productCategory.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cd.productCategory.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
