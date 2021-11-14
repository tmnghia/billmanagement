package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.example.controllers.DrinkController;
import com.example.controllers.FoodController;
import com.example.controllers.ProductRepoController;
import com.example.models.Drink;
import com.example.models.Food;
import com.example.models.Product;
import com.example.models.Drink.DrinkType;
import com.example.models.Food.FoodType;
import com.example.views.DrinkView;
import com.example.views.FoodView;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    void testApp() {
        assertEquals(1, 1);
    }

    @Test
    void testFoodMVC() {
        int id = 1;
        String name = "Food name";
        String description = "Food description";
        double price = 1000;
        FoodType type = FoodType.APPETTIZER;

        Food model = new Food(id, name, description, price, type);
        FoodController foodController = new FoodController(model, new FoodView());

        assertEquals(id, foodController.getId());
        assertEquals(name, foodController.getName());
        assertEquals(description, foodController.getDescription());
        assertEquals(price, foodController.getPrice());
        assertEquals(type, foodController.getType());

        int newID = 2;
        foodController.setId(newID);
        assertEquals(newID, foodController.getId());

        String newName = "New food name";
        foodController.setName(newName);
        assertEquals(newName, foodController.getName());

        String newDesc = "New food description";
        foodController.setDescription(newDesc);
        assertEquals(newDesc, foodController.getDescription());

        double newPrice = 20000;
        foodController.setPrice(newPrice);
        assertEquals(newPrice, foodController.getPrice());

        FoodType newType = FoodType.DESSERTS;
        foodController.setType(newType);
        assertEquals(newType, foodController.getType());
    }

    @Test
    void testDrinkMVC() {
        int id = 1;
        String name = "Drink name";
        String description = "Drink description";
        double price = 30000;
        DrinkType type = DrinkType.ALCOHIC_WATERS;

        Drink model = new Drink(id, name, description, price, type);
        DrinkController controller = new DrinkController(model, new DrinkView());

        assertEquals(id, controller.getId());
        assertEquals(name, controller.getName());
        assertEquals(description, controller.getDescription());
        assertEquals(price, controller.getPrice());
        assertEquals(type, controller.getType());

        id = 2;
        controller.setId(id);
        assertEquals(id, controller.getId());

        name = "New Drink name";
        controller.setName(name);
        assertEquals(name, controller.getName());

        description = "New Drink description";
        controller.setDescription(description);
        assertEquals(description, controller.getDescription());

        price = 40000;
        controller.setPrice(price);
        assertEquals(price, controller.getPrice());

        type = DrinkType.CLEAN_WATER;
        controller.setType(type);
        assertEquals(type, controller.getType());
    }

    @Test
    void testProductRepoMVC() {
        ArrayList<Product> productList = null;
        boolean found = false;

        ProductRepoController controller = ProductRepoController.getInstance();
        ProductRepoController controller2 = ProductRepoController.getInstance();
        assertEquals(controller.hashCode(), controller2.hashCode());

        Product food1 = new Food(1, "food1", "description", 10000, FoodType.MAIN_DISHES);
        Product drink1 = new Drink(1, "drink1", "description", 10000, DrinkType.ALCOHIC_WATERS);
        controller.addItem(food1);
        productList = controller.getItems();
        found = false;
        for (Product product : productList) {
            if (product.equals(food1)) {
                found = true;
            }
        }
        if (!found)
            assertEquals(true, false);

        controller.addItem(drink1);
        productList = controller.getItems();
        found = false;
        for (Product product : productList) {
            if (product.equals(drink1)) {
                found = true;
            }
        }
        if (!found)
            assertEquals(true, false);

        for (Product product : productList) {
            if (product.equals(food1))
                controller.removeItem(product);
        }

        found = false;
        productList = controller.getItems();
        for (Product product : productList) {
            if (product.equals(food1))
                found = true;
        }
        if (found)
            assertEquals(false, true);

        Product drink1Updated = new Drink(1, "drink1 updated", "description", 10000, DrinkType.ALCOHIC_WATERS);
        controller.updateItem(food1, drink1Updated);
        found = false;
        productList = controller.getItems();
        for (Product product : productList) {
            if (product.equals(food1))
                found = true;
        }
        if (found)
            assertEquals(false, true);

        found = false;
        productList = controller.getItems();
        for (Product product : productList) {
            if (product.equals(drink1Updated))
                found = true;
        }
        if (!found)
            assertEquals(true, false);

    }
}
