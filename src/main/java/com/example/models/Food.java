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

    @Override
    public int hashCode() {
        final int prime = 18;
        int result = super.hashCode();
        result = prime * result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Food other = (Food) obj;
        if (foodType != other.foodType)
            return false;
        return true;
    }
}
