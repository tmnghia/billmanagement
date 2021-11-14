package com.example.controllers;

import com.example.interfaces.ProductController;
import com.example.models.Drink;
import com.example.models.Drink.DrinkType;
import com.example.views.DrinkView;

public class DrinkController implements ProductController<Drink> {

    private Drink model;
    private DrinkView view;

    public DrinkController(Drink model, DrinkView view) {
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
    public void showInfo(Drink product) {
        view.showInfo(product);
    }

    public DrinkType getType() {
        return model.getDrinkType();
    }

    public void setType(DrinkType type) {
        model.setDrinkType(type);
    }
}
