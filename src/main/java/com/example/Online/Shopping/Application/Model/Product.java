package com.example.Online.Shopping.Application.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Product.
 */
@Document(collection = "product")
public class Product {

    /**
     * The Id.
     */
    @Id
    String id;
    /**
     * The Product name.
     */
    String product_name,
    /**
     * The Price.
     */
    price,
    /**
     * The Added on.
     */
    added_on,
    /**
     * The Category id.
     */
    category_id,
    /**
     * The Product img.
     */
    product_img;
    /**
     * The Amount.
     */
    int amount;
    /**
     * The Manufacturer.
     */
    String Manufacturer;


    /**
     * Instantiates a new Product.
     */
    public Product() {
    }

    /**
     * Instantiates a new Product.
     *
     * @param id           the id
     * @param product_name the product name
     * @param price        the price
     * @param added_on     the added on
     * @param category_id  the category id
     * @param product_img  the product img
     * @param amount       the amount
     * @param manufacturer the manufacturer
     */
    public Product(String id, String product_name, String price, String added_on, String category_id, String product_img, int amount, String manufacturer) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.added_on = added_on;
        this.category_id = category_id;
        this.product_img = product_img;
        this.amount = amount;
        Manufacturer = manufacturer;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     * Sets product name.
     *
     * @param product_name the product name
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Gets added on.
     *
     * @return the added on
     */
    public String getAdded_on() {
        return added_on;
    }

    /**
     * Sets added on.
     *
     * @param added_on the added on
     */
    public void setAdded_on(String added_on) {
        this.added_on = added_on;
    }

    /**
     * Gets category id.
     *
     * @return the category id
     */
    public String getCategory_id() {
        return category_id;
    }

    /**
     * Sets category id.
     *
     * @param category_id the category id
     */
    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Gets product img.
     *
     * @return the product img
     */
    public String getProduct_img() {
        return product_img;
    }

    /**
     * Sets product img.
     *
     * @param product_img the product img
     */
    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    /**
     * Gets manufacturer.
     *
     * @return the manufacturer
     */
    public String getManufacturer() {
        return Manufacturer;
    }

    /**
     * Sets manufacturer.
     *
     * @param manufacturer the manufacturer
     */
    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", price='" + price + '\'' +
                ", added_on='" + added_on + '\'' +
                ", category_id='" + category_id + '\'' +
                ", product_img='" + product_img + '\'' +
                ", amount=" + amount +
                ", Manufacturer='" + Manufacturer + '\'' +
                '}';
    }
}
