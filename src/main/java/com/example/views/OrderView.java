package com.example.views;

import java.util.Map;

import com.example.dao.ProductDAO;
import com.example.models.Product;

public class OrderView {
    public void showOrder(int orderID, Map<Integer, Integer> orderItems) {
        ProductDAO productDAO = ProductDAO.getInstance();
        double orderTotalPrice = 0;

        System.out.println("Order ID: " + orderID);
        System.out.println("========== ORDER ITEMS ==========");
        for (Map.Entry<Integer, Integer> item : orderItems.entrySet()) {
            Product product = productDAO.getProduct(item.getKey());
            String productName = product.getName();
            int quantity = item.getValue();
            double totalPrice = quantity * product.getPrice();
            orderTotalPrice += totalPrice;
            
            System.out.println("Product: " + productName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total price: " + totalPrice);
        }

        System.out.println("Order total price: " + orderTotalPrice);
    }
}
