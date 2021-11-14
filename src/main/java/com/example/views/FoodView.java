package com.example.views;

import com.example.interfaces.ProductView;
import com.example.models.Food;

public class FoodView implements ProductView<Food> {

    @Override
    public void showInfo(Food product) {
        System.out.println();
        System.out.println("ID: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Type: " + product.getFoodType().toString());
    }
}
