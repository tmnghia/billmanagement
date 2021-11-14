package com.example.interfaces;

public interface ProductController<T> {
    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    double getPrice();

    void setPrice(double price);

    void showInfo(T product);
}
