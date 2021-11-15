package com.example.models;

import java.util.ArrayList;

import com.example.interfaces.Repository;

public class OrderRepo implements Repository<Order> {

    @Override
    public boolean addItem(Order item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeItem(Order item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateItem(Order oldItem, Order newItem) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ArrayList<Order> getItems() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
