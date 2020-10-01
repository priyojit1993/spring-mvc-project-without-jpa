package com.springlearning.srpingmvc.springmvc;

import com.springlearning.srpingmvc.springmvc.product.controller.ProductController;
import com.springlearning.srpingmvc.springmvc.product.model.Product;
import com.springlearning.srpingmvc.springmvc.product.services.ProductServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {
    /*
     * We are going to use annotation based configuration of mock object and injection of those mock dependencies
     * into our mock controller
     * */
    @Mock
    private ProductServices productServices; //Mockito mock object

    @InjectMocks
    private ProductController productController; //setups a controller and inject all the mock objects into it


    private MockMvc mockMvc;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testList() throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());

        //specifies mockito interaction tells stub to return list of products
        Mockito.verifyNoInteractions(productServices);
        Mockito.when(productServices.listProducts()).thenReturn(products);
        mockMvc.perform(MockMvcRequestBuilders.get("/getProducts")).andExpect(
                MockMvcResultMatchers.model().attribute("products", products)
        );


    }

    @Test
    public void testShow() throws Exception {
        String id = "1";
        //Tell Mockito Stub to return new Product for id=1
        Mockito.when(productServices.getProductDetail(id)).thenReturn(new Product());
        mockMvc.perform(MockMvcRequestBuilders.get("/gerProducts/1"))
//                .andExpect(MockMvcResultMatchers.view().name("product/productDetail"))
                .andExpect(MockMvcResultMatchers.model().attribute("product", Product.class));
    }

}
