package com.example.controllers;

import com.example.models.Order;
import com.example.views.OrderView;

public class OrderController {
    Order model = null;
    OrderView view = null;

    public OrderController(Order model, OrderView view) {
        this.model = model;
        this.view = view;
    }

    public boolean addOrderItem(int productID, int quantity) {
        return model.addOrderItem(productID, quantity);
    }

    public boolean removeOrderItem(int productID, int quantity) {
        return model.removeOrderItem(productID, quantity);
    }

    public void showOrders() {
        System.out.println("OrderController.showOrders()" + model.getTotalPrice());
        view.showOrder(model.getId(), model.getOrderItems());
    }
}
