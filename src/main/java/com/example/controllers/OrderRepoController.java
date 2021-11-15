package com.example.controllers;

import java.util.ArrayList;

import com.example.interfaces.RepoController;
import com.example.models.Order;

public class OrderRepoController implements RepoController<Order> {

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

    @Override
    public void showAllItems() {
        // TODO Auto-generated method stub
        
    }
    
}
