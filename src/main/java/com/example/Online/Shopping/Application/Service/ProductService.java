package com.example.Online.Shopping.Application.Service;

import com.example.shoppingsite.Model.Product;
import com.example.shoppingsite.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Product service.
 */
@Service
public class ProductService {
    /**
     * The Log.
     */
    Logger log = LoggerFactory.getLogger("Name......................");
    /**
     * The Product repository.
     */
    @Autowired
    ProductRepository productRepository;

    /**
     * Create product product.
     *
     * @param product the product
     * @return the product
     */
    public Product createProduct(Product product){
       return productRepository.save(product);
    }

    /**
     * Get all products under one category list.
     *
     * @param category_id the category id
     * @return the list
     */
    public List<Product> getAllProductsUnderOneCategory(String category_id){
        return productRepository.findProductByCategory(category_id);
    }

    /**
     * Update products product.
     *
     * @param product the product
     * @return the product
     * @throws Exception the exception
     */
    public Product updateProducts(Product product) throws Exception{
        if(product == null || product.getId()==null){
            throw new Exception("Product cannot be null");
        }
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if(!optionalProduct.isPresent()){
            throw new Exception("Product id does not exist");
        }
        Product existingProduct = optionalProduct.get();
        existingProduct.setProduct_name(product.getProduct_name());
        existingProduct.setProduct_img(product.getProduct_img());
        existingProduct.setAdded_on(product.getAdded_on());
        existingProduct.setAmount(product.getAmount());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setManufacturer(product.getManufacturer());
        return productRepository.save(product);
    }

    /**
     * Delete products.
     *
     * @param id the id
     * @throws Exception the exception
     */
    public void deleteProducts(String id) throws Exception{
        if(!productRepository.findById(id).isPresent()){
            throw new Exception("Product does not exist");
        }
        productRepository.deleteById(id);

    }

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    public List<Product> findByName(String name){
        log.info(name);
       return productRepository.findByName(name);
    }

    /**
     * Gets all products.
     *
     * @return the all products
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Find product by id optional.
     *
     * @param id the id
     * @return the optional
     */
    public Optional<Product> findProductById(String id) {
        return productRepository.findById(id);
    }

}
