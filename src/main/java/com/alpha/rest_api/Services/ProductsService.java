package com.alpha.rest_api.Services;



import com.alpha.rest_api.Repository.IProductsRepository;


import com.alpha.rest_api.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductsService implements IProductsService {


    private static Logger logger = LoggerFactory.getLogger(ProductsService.class);

    @Autowired
     private IProductsRepository ProductsRepository;

    @Autowired
    private RestTemplate restTemplate;

    private boolean isEmpty(Product product){

        if(product == null)
            return true;

        return false;
    }

    private Product productValidation(Product product) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String incomingJson = objectMapper.writeValueAsString(product);

        logger.info("{} --> validating the product", incomingJson);

        if(product.getProductName().isBlank()) {
            logger.error("Failed validation product name cannot be empty");
            throw new IOException();

        }

        if(String.valueOf(product.getPrice()).isEmpty()){
                logger.error("Price cannot be empty");
            throw new IOException();
        }

        logger.info("{}---> Passed the validation of following product ", incomingJson);

        return product;

    }




    public List<Product> getAllProducts() {
        logger.info("{} start ------> getAllProducts ");

       List <Product> allProducts =  ProductsRepository.findAll();

       return allProducts;

    }

    public Product saveProduct(Product product) throws IOException {

        logger.info("{} -- > Starting the saveProduct()");

        productValidation(product);

        return ProductsRepository.insert(product);
    }

    public Product getProductById(String id) {

        logger.info("{} start ---> getProductById with id ", id);

        Product item = ProductsRepository.findProductById(id);

        try{
            if (item == null) {
                logger.info("no product found with id", id);
            }
            else {
                ProductsRepository.findProductById(id);
                logger.info("found product by id");
            }
        }catch (Exception e){
            logger.info("{} Error found when trying to find product with id", id);
            e.getMessage();
        }
        return item;
    }

    public void deleteProductById(String id) {

        logger.info("{} start -----> deleteProductById() ", id);

        Product productInfo = ProductsRepository.findProductById(id);

        if (productInfo == null) {
            logger.info("{} --> No event found with id ", id);

        } else {
            ProductsRepository.deleteById(id);

            logger.info("{} checking if product was successfully deleted ", isEmpty(productInfo));

            logger.info("deleted student with ID {}", id);

        }





    }
//    public List<Product> orderByPriceFromHighToLow(){
//
//
//
//    }




    public Product updateProductById(String id, Product Product) {

        return ProductsRepository.save(Product);
    }

    public List<String> getAllProductsNames(){

        List<Product> product = ProductsRepository.findAll();

        List<String> namesOfProducts = new ArrayList<>();

        product.forEach(product1 -> namesOfProducts.add(product1.getProductName()));

        return namesOfProducts;


    }


//   public String tetingweb(String endpoint) throws IOException, InterruptedException {
//
////        String endpoint = "https://jsonplaceholder.typicode.com/posts";
//
//       HttpClient client = HttpClient.newHttpClient();
//
//       HttpRequest request = HttpRequest.newBuilder()
//               .GET().header("accept", "application/json")
//               .uri(URI.create(endpoint))
//               .build();
//
//       HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//
//        return response.body();
//
//   }
}
