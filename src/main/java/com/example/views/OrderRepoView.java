package com.example.views;

import java.util.ArrayList;

import com.example.interfaces.RepoView;
import com.example.models.Order;

public class OrderRepoView implements RepoView<Order> {

    @Override
    public void showRepoItems(ArrayList<Order> items) {
        for (Order order : items) {
            System.out.println(order);
        }
    }
}
