package com.example.models;

public class Drink extends Product {
    public enum DrinkType {
        CLEAN_WATER, SOFT_DRINK, ALCOHIC_WATERS;

        @Override
        public String toString() {
            switch (this.ordinal()) {
            case 0:
                return "Clean water";
            case 1:
                return "Soft drink";
            case 2:
                return "Alcohic waters";
            default:
                return "";
            }
        }
    }

    private DrinkType drinkType;

    public Drink(int id, String name, String description, double price, DrinkType type) {
        super(id, name, description, price);
        setDrinkType(type);
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
    }
}
