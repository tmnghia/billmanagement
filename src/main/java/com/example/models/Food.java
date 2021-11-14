package com.example.models;

public class Food extends Product {
    public enum FoodType {
        APPETTIZER, MAIN_DISHES, DESSERTS;

        @Override
        public String toString() {
            switch (this.ordinal()) {
            case 0:
                return "Appettizer";
            case 1:
                return "Main Dishes";
            case 2:
                return "Desserts";
            default:
                return "";
            }
        }
    }

    private FoodType foodType;

    Food() {
    }

    public Food(int id, String name, String description, double price, FoodType type) {
        super(id, name, description, price);
        setFoodType(type);
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + foodType;
    }
}
