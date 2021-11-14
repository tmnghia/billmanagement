package com.example.models;

import java.util.ArrayList;

import com.example.interfaces.Repository;

public class ProductRepo implements Repository<Product> {
    private static ProductRepo instance = null;
    ArrayList<Product> items = null;

    private ProductRepo() {
        items = new ArrayList<>();
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
    public boolean addItem(Product item) {
        for (Product product : items) {
            if (product.equals(item)) {
                return false;
            }
        }
        items.add(item);

        return true;
    }

    @Override
    public boolean removeItem(Product removeItem) {
        items.removeIf(item -> item.equals(removeItem));

        return false;
    }

    @Override
    public boolean updateItem(Product oldItem, Product newItem) {
        for (Product product : items) {
            if (product.equals(oldItem)) {
                removeItem(oldItem);
                addItem(newItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Product> getItems() {
        return items;
    }

    @Override
    public boolean writeToDB() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean readFromDB() {
        // TODO Auto-generated method stub
        return true;
    }
}
