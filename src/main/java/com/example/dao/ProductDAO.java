package com.example.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.example.interfaces.FileDAO;
import com.example.models.Product;

public class ProductDAO implements FileDAO {

    private String dbPath;
    public static ProductDAO instance = null;
    private ArrayList<Product> productList = null;

    private ProductDAO(String dbPath){
        this.dbPath = dbPath;
        productList = new ArrayList<>();
        readFromFile();
    }

    public static ProductDAO getInstance(String dbPath) {
        if (instance == null) {
            synchronized (ProductDAO.class) {
                if (instance == null) {
                    instance = new ProductDAO(dbPath);
                }
            }
        }

        return instance;
    }

    public boolean addProduct(Product newProduct) {
        for (Product product : productList) {
            if (product.equals(newProduct)) {
                System.err.println("Product " + newProduct + "\nalready exist!");
                return false;
            }
        }
        productList.add(newProduct);
        writeToFile();
        System.out.println("ProductDAO.addProduct()\n" + newProduct);

        return true;
    }

    public boolean updateProduct(Product oldProduct, Product newProduct) {
        for (Product product : productList) {
            if (product.equals(oldProduct)) {
                removeProduct(oldProduct);
                addProduct(newProduct);
                writeToFile();

                return true;
            }
        }
        System.err.println("Not found \n" + oldProduct);

        return false;
    }

    public boolean removeProduct(Product removeProduct) {
        if (productList.removeIf(product -> product.equals(removeProduct))) {
            writeToFile();
            System.out.println("ProductDAO.removeProduct()\n" + removeProduct);
            return true;
        }

        return false;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    @Override
    public void writeToFile() {
        OutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(dbPath); 
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromFile() {
        InputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(dbPath);
            ois = new ObjectInputStream(fis);
            productList = (ArrayList<Product>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
