package com.alpha.rest_api.Controllers;


import com.alpha.rest_api.Services.ProductsService;
import com.alpha.rest_api.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/products/api")
public class ProductsController {

    private static Logger logger = LoggerFactory.getLogger(ProductsController.class);

    @Autowired
    private ProductsService ProductsService;


    @GetMapping(path = "/home")
    public String Home() {
        return "Welcome to my simple Rest API example";
    }


    @GetMapping("/about")
    String getAbout() {
        return "This is a simple Rest API example that uses mongodb and intellij to add, retrieve and delete Products";
    }

    @GetMapping("/moreinfo")
    String getMoreInfo(){
        return "This is my first ever API example which l was able to connect to the backend ";
    }



    @PostMapping(path = "/saveProduct")
    public Product saveProduct(@RequestBody Product Product) throws IOException {
        logger.info("Saving Product to the mongoDB");
        return ProductsService.saveProduct(Product);
    }

    @GetMapping(path = "/Products")
    public List<Product> getMyProducts() {
        return ProductsService.getAllProducts();
    }

    @GetMapping(path = "/{ID}")
    public Product getProductById(@PathVariable (value = "ID") String id) throws IOException{
        logger.info("Trying to get Product by ID ");
        return ProductsService.getProductById(id);

    }
    @DeleteMapping(path = ("/delete/{ID}"))
    public void deleteProductById(@PathVariable(value = "ID") String id){
        logger.info("Trying to delete the records by id", id);
        ProductsService.deleteProductById(id);

    }

    @GetMapping("/productList")
    public List<String> getAllProductsByName(){
        logger.info("{} Trying to get all product names");
        return ProductsService.getAllProductsNames();
    }

//    @GetMapping(path = ("/{endpoint}"))
//    String Webtest(@PathVariable("endpoint") String https) throws IOException, InterruptedException {
//        return ProductsService.tetingweb(https);
//    }

    @PutMapping(path = "/Product/{id}")
    public Product updateProductById(@RequestBody Product Product, @PathVariable("id") String id) throws IOException{
        logger.info("Trying to update Product by ID ");
        return ProductsService.updateProductById(id, Product);

    }

}





