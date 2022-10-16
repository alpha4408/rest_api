package com.alpha.rest_api.Services;

import com.alpha.rest_api.model.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IProductsService {
    List<Product> getAllProducts();
    Product saveProduct(Product Product) throws IOException;
    Product getProductById(String id);
    void deleteProductById(String id);

}
