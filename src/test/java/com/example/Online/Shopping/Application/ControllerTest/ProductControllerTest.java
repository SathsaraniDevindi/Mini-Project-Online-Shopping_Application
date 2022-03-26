package com.example.Online.Shopping.Application.ControllerTest;

import com.example.shoppingsite.Controller.ProductController;
import com.example.shoppingsite.Model.Product;
import com.example.shoppingsite.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Product controller test.
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {

    private MockMvc mockMvc;

    /**
     * The Object mapper.
     */
    ObjectMapper objectMapper = new ObjectMapper();
    /**
     * The Object writer.
     */
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    /**
     * The Product 1.
     */
    Product PRODUCT_1 = new Product("1", "Sandwich Bread 450g", "160", "17/03./2022", "1", "https://images.unsplash.com/photo-1598373182133-52452f7691ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80", 1,"Manufacturer");
    /**
     * The Product 2.
     */
    Product PRODUCT_2 = new Product("2", "Hamburger Buns 2S","90","17/03./2022","1","https://media.istockphoto.com/photos/grilled-burger-bun-isolated-on-white-background-picture-id587226932?s=612x612",1,"Manufacturer");
    /**
     * The Product 3.
     */
    Product PRODUCT_3 = new Product("3", "French Bread", "150", "17/03./2022", "1", "https://media.istockphoto.com/photos/two-baguettes-with-clipping-path-picture-id174893437", 1,"Manufacturer");
    /**
     * The Product 4.
     */
    Product PRODUCT_4 = new Product("4", "Chocolate Cake 1kg", "1550", "17/03./2022", "1", "https://media.istockphoto.com/photos/decadent-chocolate-cake-with-chocolate-ganache-picture-id1150799293?s=612x612", 1,"Manufacturer");
    /**
     * The Product 5.
     */
    Product PRODUCT_5 = new Product("5", "chocolate chunk cookie 2S", "450", "17/03./2022", "1", "https://media.istockphoto.com/photos/warm-chocolate-chunk-cookies-picture-id185111918?s=612x612", 1,"Manufacturer");

    /**
     * Set up.
     */
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(productController).build();

    }

    /**
     * Gets all products success.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllProducts_success() throws Exception{
        List<Product> allProducts = new ArrayList<>(Arrays.asList(PRODUCT_1,PRODUCT_2,PRODUCT_3,PRODUCT_4,PRODUCT_5));

        Mockito.when(productService.getAllProducts()).thenReturn(allProducts);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                         .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(5)));
        //  .andExpect(MockMvcResultMatchers.jsonPath("$[101].category_name",is("Bakery")));
    }

    /**
     * Gets all products under one category success.
     *
     * @throws Exception the exception
     */
    @Test
    public  void getAllProductsUnderOneCategory_success() throws Exception{
        List<Product> products = new ArrayList<>(Arrays.asList(PRODUCT_1,PRODUCT_2,PRODUCT_3,PRODUCT_4,PRODUCT_5));
        String category_id = "1";
        Mockito.when(productService.getAllProductsUnderOneCategory(category_id)).thenReturn(products);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/category/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                       .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(5)));
    }

    /**
     * Find product by id success.
     *
     * @throws Exception the exception
     */
    @Test
    public void findProductById_success() throws Exception{
        List<Product> products = new ArrayList<>(Arrays.asList(PRODUCT_1,PRODUCT_2,PRODUCT_3,PRODUCT_4,PRODUCT_5));

        Mockito.when(productService.findProductById("1")).thenReturn(Optional.ofNullable(PRODUCT_1));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/product/Id/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Create product success.
     *
     * @throws Exception the exception
     */
    @Test
    public void createProduct_success() throws Exception{
        Product product_1 = new Product("10", "Drinking Chocolate 200g", "400", "17/03./2022", "2", "https://media.istockphoto.com/photos/hot-chocolate-picture-id615905680?s=612x612", 1,"Manufacturer");
       // String category_id = "1";
        Mockito.when(productService.createProduct(product_1)).thenReturn(product_1);


        String content = objectWriter.writeValueAsString(product_1);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/category/2/product/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
      //          .andExpect(MockMvcResultMatchers.jsonPath("$",notNullValue()));

    }

    /**
     * Update product success.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateProduct_success() throws Exception {
       Product updatedProduct = new Product("1", "Sandwich Bread 450g", "160", "17/03./2022", "1", "https://images.unsplash.com/photo-1598373182133-52452f7691ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80", 1,"Manufacturer");

        Mockito.when(productController.createProduct(updatedProduct)).thenReturn(updatedProduct);
        String pass= updatedProduct.getCategory_id();
        String content = objectWriter.writeValueAsString(updatedProduct);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/1/product/update")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());


    }

    /**
     * Delete category by id success.
     *
     * @throws Exception the exception
     */
    @Test
    public void deleteProductById_success() throws Exception{
        Mockito.when(productService.findProductById(PRODUCT_5.getId())).thenReturn(Optional.ofNullable(PRODUCT_5));

        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/product/delete/5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
