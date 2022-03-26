package com.example.Online.Shopping.Application.Controller;

import com.example.shoppingsite.Model.Product;
import com.example.shoppingsite.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * The type Product controller.
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class ProductController {
    /**
     * The Product service.
     */
    @Autowired
    ProductService productService;

    /**
     * Create product product.
     *
     * @param product the product
     * @return the product
     */
    @RequestMapping(method= RequestMethod.POST, value = "category/{category_id}/product/add")
    public Product createProduct(@RequestBody Product product){
      return  productService.createProduct(product);
    }

    /**
     * Get all products under category list.
     *
     * @param category_id the category id
     * @return the list
     */
// Get All the products under one category
    @RequestMapping(method=RequestMethod.GET, value="category/{category_id}")
    public List<Product> getAllProductsUnderCategory(@PathVariable String category_id){
        return productService.getAllProductsUnderOneCategory(category_id);
    }


    /**
     * Update product product.
     *
     * @param product the product
     * @return the product
     * @throws Exception the exception
     */
    @RequestMapping(method=RequestMethod.POST,value="{category_id}/product/update")
    public Product updateProduct(@RequestBody Product product) throws Exception{
        return productService.updateProducts(product);
    }


    /**
     * Get all products list.
     *
     * @param id the id
     * @return the list
     */
    @RequestMapping(method=RequestMethod.GET, value="products")
    public List<Product> getAllProducts(String id){
        return productService.getAllProducts();
    }

    /**
     * Find product by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws Exception the exception
     */
    @RequestMapping(method=RequestMethod.GET, value="product/Id/{id}")
    public Optional<Product> findProductById(@PathVariable String id) throws Exception{
        return productService.findProductById(id);
    }

    /**
     * Delete product.
     *
     * @param id the id
     * @throws Exception the exception
     */
    @RequestMapping(method = RequestMethod.DELETE,value="product/delete/{id}")
    public void deleteProduct(@PathVariable String id) throws Exception{
        productService.deleteProducts(id);
    }
}
