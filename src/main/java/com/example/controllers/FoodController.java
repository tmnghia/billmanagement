package com.example.controllers;

import com.example.interfaces.ProductController;
import com.example.models.Food;
import com.example.models.Food.FoodType;
import com.example.views.FoodView;

public class FoodController implements ProductController<Food> {
    private Food model;
    private FoodView view;

    public FoodController(Food model, FoodView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public int getId() {
        return model.getId();
    }

    @Override
    public void setId(int id) {
        model.setId(id);
    }

    @Override
    public String getName() {
        return model.getName();
    }

    @Override
    public void setName(String name) {
        model.setName(name);
    }

    @Override
    public String getDescription() {
        return model.getDescription();
    }

    @Override
    public void setDescription(String description) {
        model.setDescription(description);
    }

    @Override
    public double getPrice() {
        return model.getPrice();
    }

    @Override
    public void setPrice(double price) {
        model.setPrice(price);
    }

    @Override
    public void showInfo(Food product) {
        view.showInfo(product);
    }

    public FoodType getType() {
        return model.getFoodType();
    }

    public void setType(FoodType foodType) {
        model.setFoodType(foodType);
    }
}
