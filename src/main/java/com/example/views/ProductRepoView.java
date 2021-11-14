package com.example.views;

import java.util.ArrayList;

import com.example.interfaces.RepoView;
import com.example.models.Product;

public class ProductRepoView implements RepoView<Product> {

    @Override
    public void showRepoItems(ArrayList<Product> items) {
        for (Product item : items) {
            System.out.println(item);
        }
    }
}
