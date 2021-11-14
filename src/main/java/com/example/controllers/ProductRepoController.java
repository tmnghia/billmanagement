package com.example.controllers;

import java.util.ArrayList;

import com.example.interfaces.RepoController;
import com.example.models.Product;
import com.example.models.ProductRepo;
import com.example.views.ProductRepoView;

public class ProductRepoController implements RepoController<Product> {
    private ProductRepo model;
    private ProductRepoView view;
    private static ProductRepoController instance;

    private ProductRepoController() {
        model = ProductRepo.getInstance();
        view = new ProductRepoView();
    }

    public static ProductRepoController getInstance() {
        if (instance == null) {
            synchronized (ProductRepo.class) {
                if (instance == null) {
                    instance = new ProductRepoController();
                }
            }
        }
        return instance;
    }

    @Override
    public boolean addItem(Product item) {
        return model.addItem(item);
    }

    @Override
    public boolean removeItem(Product item) {
        return model.removeItem(item);
    }

    @Override
    public boolean updateItem(Product oldItem, Product newItem) {
        return model.updateItem(oldItem, newItem);
    }

    @Override
    public ArrayList<Product> getItems() {
        return model.getItems();
    }

    @Override
    public void showAllItems() {
        view.showRepoItems(model.getItems());
    }
}
