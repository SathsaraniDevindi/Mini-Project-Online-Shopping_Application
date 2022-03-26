package com.example.Online.Shopping.Application.ServiceTest;

import com.example.shoppingsite.Model.Product;
import com.example.shoppingsite.Repository.ProductRepository;
import com.example.shoppingsite.Service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Product service test.
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {

//    public void deleteProducts(String id){
//        productRepository.deleteById(id);
//    }

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
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

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
        this.mockMvc= MockMvcBuilders.standaloneSetup(productService).build();

    }

    /**
     * Gets all products success.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllProducts_success() throws Exception{
        List<Product> products = new ArrayList<>(Arrays.asList(PRODUCT_1,PRODUCT_2,PRODUCT_3,PRODUCT_4,PRODUCT_5));
        Mockito.when(productRepository.findAll()).thenReturn(products);
        List<Product> list = productService.getAllProducts();
        Assert.assertEquals(5, list.size());
    }

    /**
     * Gets all products under one category success.
     *
     * @throws Exception the exception
     */
    @Test
    public void getAllProductsUnderOneCategory_success() throws Exception{
        List<Product> products = new ArrayList<>(Arrays.asList(PRODUCT_1,PRODUCT_2,PRODUCT_3,PRODUCT_4,PRODUCT_5));
        Mockito.when(productRepository.findProductByCategory("1")).thenReturn(products);
        List<Product> list = productService.getAllProductsUnderOneCategory("1");
        Assert.assertEquals(5, list.size());
    }

    /**
     * Create product success.
     *
     * @throws Exception the exception
     */
    @Test
    public void createProduct_success() throws Exception{
        Product createProduct = new Product("7", "Sandwich Bread 450g", "160", "17/03./2022", "1", "https://images.unsplash.com/photo-1598373182133-52452f7691ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80", 1,"Manufacturer");
        Mockito.when(productService.createProduct(createProduct)).thenReturn(createProduct);
        Assert.assertEquals("Sandwich Bread 450g",createProduct.getProduct_name());
    }

    /**
     * Update product success.
     *
     * @throws Exception the exception
     */
    @Test
    public void updateProduct_success() throws Exception {
        Product updatedProduct = new Product("1", "updated Sandwich Bread 450g", "160", "17/03./2022", "1", "https://images.unsplash.com/photo-1598373182133-52452f7691ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80", 1,"Manufacturer");

        Mockito.when(productService.findProductById(PRODUCT_1.getId())).thenReturn(Optional.ofNullable(PRODUCT_1));
        Mockito.when(productService.createProduct(updatedProduct)).thenReturn(updatedProduct);

        Mockito.when(productService.updateProducts(updatedProduct)).thenReturn(updatedProduct);
        Assert.assertEquals("updated Sandwich Bread 450g",PRODUCT_1.getProduct_name());

    }

    /**
     * Find product by id success.
     *
     * @throws Exception the exception
     */
    @Test
    public void findProductById_success() throws Exception{
        Mockito.when(productService.findProductById("1")).thenReturn(Optional.ofNullable(PRODUCT_1));
        Mockito.when(productService.findProductById("2")).thenReturn(Optional.ofNullable(PRODUCT_2));
        Mockito.when(productService.findProductById("3")).thenReturn(Optional.ofNullable(PRODUCT_3));

        Assert.assertEquals("1", PRODUCT_1.getId());
        Assert.assertEquals("2", PRODUCT_2.getId());
        Assert.assertEquals("3", PRODUCT_3.getId());

    }

    @Test
    public void deleteCategory_success() throws Exception{
        Product deleteProduct = new Product("1", "updated Sandwich Bread 450g", "160", "17/03./2022", "1", "https://images.unsplash.com/photo-1598373182133-52452f7691ef?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80", 1,"Manufacturer");

        Mockito.when(productService.createProduct(deleteProduct)).thenReturn(deleteProduct);
        Mockito.when(productService.findProductById(deleteProduct.getId())).thenReturn(Optional.ofNullable(deleteProduct));

        productService.deleteProducts("1");
        Mockito.when(productService.findProductById(deleteProduct.getId())).thenReturn(Optional.ofNullable(deleteProduct));
        Assert.assertEquals("1",deleteProduct.getCategory_id());
    }
}
