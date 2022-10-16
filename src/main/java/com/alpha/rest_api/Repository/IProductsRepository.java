package com.alpha.rest_api.Repository;


import com.alpha.rest_api.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository extends MongoRepository<Product, String> {

    Product findProductById(String id);


}
