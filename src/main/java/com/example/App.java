package com.example;

import java.util.ArrayList;

import com.example.controllers.ProductRepoController;
import com.example.models.Drink;
import com.example.models.Food;
import com.example.models.Product;
import com.example.models.Food.FoodType;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("============");
        System.out.println("MVC App Demo");
        System.out.println("============");

        ArrayList<Product> productList = null;
        ProductRepoController controller = ProductRepoController.getInstance();
        System.out.println(controller);

        System.out.println(controller.getItems());

        Product food1 = new Food(1, "food1", "description", 10000, Food.FoodType.MAIN_DISHES);
        Product drink1 = new Drink(1, "drink1", "description", 10000, Drink.DrinkType.ALCOHIC_WATERS);
        controller.addItem(food1);
        controller.addItem(drink1);

        System.out.println("List repo");
        productList = controller.getItems();
        productList = controller.getItems();
        for (Product product : productList) {
            System.out.println(product + "\n");
        }


        // for (Product product : productList) {
        //     if (product.equals(drink1))
        //         controller.removeItem(product);
        // }
        productList.removeIf(product -> product.equals(drink1));

        System.out.println("List repo");
        productList = controller.getItems();
        for (Product product : productList) {
            System.out.println(product + "\n");
        }

        Food food1Updated = new Food(1, "food1 updated", "description", 10000, FoodType.MAIN_DISHES);
        controller.updateItem(food1, food1Updated);
        
        System.out.println("List repo");
        productList = controller.getItems();
        for (Product product : productList) {
            System.out.println(product + "\n");
        }
    }
}
