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

    @Override
    public String toString() {
        return super.toString() + "\n" + "Type: " + drinkType;
    }

    @Override
    public int hashCode() {
        final int prime = 19;
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
        Drink other = (Drink) obj;
        if (drinkType != other.drinkType)
            return false;
        return true;
    }
}
