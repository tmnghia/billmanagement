package com.example.models;

import java.util.ArrayList;

import com.example.dao.ProductDAO;
import com.example.interfaces.Repository;

public class ProductRepo implements Repository<Product> {
    final String PRODUCT_DB_NAME = "product.dat";
    private static ProductRepo instance = null;
    // ArrayList<Product> items = null;
    public ProductDAO dao = null;

    private ProductRepo() {
        // items = new ArrayList<>();
        dao = ProductDAO.getInstance(PRODUCT_DB_NAME);
    }

    public static ProductRepo getInstance() {
        if (instance == null) {
            synchronized (ProductRepo.class) {
                if (instance == null) {
                    instance = new ProductRepo();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean addItem(Product product) {
        return dao.addProduct(product);
    }

    @Override
    public boolean removeItem(Product product) {
        return dao.removeProduct(product);
    }

    @Override
    public boolean updateItem(Product oldItem, Product newItem) {
        return dao.updateProduct(oldItem, newItem);
    }

    @Override
    public ArrayList<Product> getItems() {
        return dao.getProductList();
    }
}
