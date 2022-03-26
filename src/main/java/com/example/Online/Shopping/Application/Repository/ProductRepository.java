package com.example.Online.Shopping.Application.Repository;

import com.example.shoppingsite.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends MongoRepository<Product,String> {

//    @Query(value="{ product_name : '?0' }")
//    List<Product> findByName(String name);

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
//    @Query(value="{ product_name : {$regex:'?0', $options : 'i'} }")
//    List<Product> findByName(String name);
    @Query(value="{ product_name : {$regex:'?0', $options : 'i'} }")
    List<Product> findByName(String name);

    /**
     * Find product by category list.
     *
     * @param category_id the category id
     * @return the list
     */
    @Query(value="{ category_id : '?0' }")
    List<Product> findProductByCategory(String category_id);
}
