package com.springlearning.srpingmvc.springmvc.product.controller;

import com.springlearning.srpingmvc.springmvc.product.model.Product;
import com.springlearning.srpingmvc.springmvc.product.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductServices productServices;


    @RequestMapping("/getProducts")
    public String getProducts(Model model) {
        model.addAttribute("products", productServices.listProducts());
        return "product";
    }

    @RequestMapping("getProducts/{id}")
    public String getProductDetail(@PathVariable String id, Model model) {
        final Product productDetail = productServices.getProductDetail(id);
        model.addAttribute("product", productDetail);
        return "productDetail";
    }

    @RequestMapping("updateProduct/{id}")
    public String updateProduct(@PathVariable String id, Model model) {
        final Product productDetail = productServices.getProductDetail(id);
        model.addAttribute("product", productDetail);
        return "editProduct";
    }

    @RequestMapping("editProduct")
    public String editProduct(Product product) {
        final Product product1 = productServices.saveOrUpdate(product);
        return "redirect:/getProducts/" + product1.getId();
    }


    @RequestMapping("addProduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping("saveProduct")
    public String saveProduct(Product product) {
        final Product product1 = productServices.saveOrUpdate(product);
        return "redirect:/getProducts/" + product1.getId();
    }

    @RequestMapping("deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id) {
        productServices.deleteProduct(id);
        return "redirect:/getProducts/";
    }


}
