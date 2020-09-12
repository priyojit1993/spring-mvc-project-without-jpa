package com.springlearning.srpingmvc.springmvc.product.services;

import com.springlearning.srpingmvc.springmvc.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServices {

    private Map<String, Product> products;

    public ProductServices() {
        loadProduct();
    }

    public List<Product> listProducts() {
        return new ArrayList<>(products.values());
    }


    private void loadProduct() {
        products = new HashMap<>();
        final Product product = new Product();
        product.setProductName("lux");
        product.setProductDescription("lux");
        product.setPrice(14.25);
        product.setId("1");
        products.put("1", product);

        final Product product2 = new Product();
        product2.setProductName("Colgate");
        product2.setProductDescription("colgate");
        product2.setPrice(24.15);
        product2.setId("2");
        products.put("2", product2);


        final Product product3 = new Product();
        product3.setProductName("Pepsodent");
        product3.setProductDescription("Pepsodent");
        product3.setPrice(74.25);
        product3.setId("3");
        products.put("3", product3);
    }

    public Product getProductDetail(String id) {
        return products.get(id);
    }

    public Product saveOrUpdate(Product product) {
        if (product != null) {
            if (product.getId() == null || product.getId().isEmpty()) {
                product.setId(UUID.randomUUID().toString());
            }
            if (products.containsKey(product.getId())) {
                products.replace(product.getId(), product);
            } else {
                products.put(product.getId(), product);
            }
            return product;
        } else {
            throw new RuntimeException("Product can't be null");
        }
    }

    public void deleteProduct(String id) {
        if (products.containsKey(id)) {
            products.remove(id);
        } else {
            throw new RuntimeException("Product with this id is not present ");
        }
    }


}
