package com.example.views;

import com.example.interfaces.ProductView;
import com.example.models.Drink;

public class DrinkView implements ProductView<Drink> {

    @Override
    public void showInfo(Drink product) {
        System.out.println();
        System.out.println("ID: " + product.getId());
        System.out.println("Name: " + product.getName());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Type: " + product.getDrinkType().toString());
    }
}
