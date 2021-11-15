package com.example.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.example.dao.ProductDAO;

public class Order implements Serializable {
    private ProductDAO productDAO = null;
    private Map<Integer, Integer> orderItems = null;
    private int id;
    private double totalPrice = 0;

    public Order(int id) {
        orderItems = new HashMap<>();
        setId(id);
        productDAO = ProductDAO.getInstance();
    }

    public boolean addOrderItem(int productID, int quantity) {
        Product product = null;
        Integer currentQuantity = 0;

        product = productDAO.getProduct(productID);
        if (product == null) {
            return false;
        }

        currentQuantity = orderItems.get(productID);
        if (currentQuantity == null) {
            orderItems.put(productID, quantity);
        } else {
            orderItems.put(productID, quantity + currentQuantity);
        }
        totalPrice += product.getPrice();

        return true;
    }

    public boolean removeOrderItem(int productID, int quantity) {
        Integer currentQuantity = 0;

        currentQuantity = orderItems.get(productID);
        if (currentQuantity == null) {
            return false;
        }

        if (currentQuantity > quantity) {
            orderItems.put(productID, currentQuantity - quantity);
        } else {
            orderItems.remove(productID);
        }

        return true;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<Integer, Integer> getOrderItems() {
        return orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        String outputString  = "ID: " + id + "\n";
        for (Map.Entry<Integer, Integer> item : orderItems.entrySet()) {
            outputString += "Product ID: " + item.getKey() + " Quantity: " + item.getKey() + "\n";
        }

        return outputString;
    }
}
