package com.example.interfaces;

import java.util.ArrayList;

public interface RepoController<T> {
    boolean addItem(T item);
    boolean removeItem(T item);
    boolean updateItem(T oldItem, T newItem);
    ArrayList<T> getItems();
    void showAllItems();
}
