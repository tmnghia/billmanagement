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

    private final String PRODUCT_DB_NAME = "product.dat";
    public static ProductDAO instance = null;
    private ArrayList<Product> productList = null;

    private ProductDAO() {
        productList = new ArrayList<>();
        readFromFile();
    }

    public static ProductDAO getInstance() {
        if (instance == null) {
            synchronized (ProductDAO.class) {
                if (instance == null) {
                    instance = new ProductDAO();
                }
            }
        }

        return instance;
    }

    public boolean addProduct(Product newProduct) {
        for (Product product : productList) {
            if (product.equals(newProduct)) {
                System.err.println("Product ID" + newProduct.getId() + "\nalready exist!");
                return false;
            }
        }
        productList.add(newProduct);
        writeToFile();
        System.out.println("ProductDAO.addProduct()\n" + newProduct);

        return true;
    }

    public Product getProduct(int productID) {
        for (Product product : productList) {
            if (product.hashCode() == productID) {
                return product;
            }
        }
        return null;
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
        System.err.println("Not found Product: " + oldProduct + "\n");

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
            fos = new FileOutputStream(PRODUCT_DB_NAME);
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
            fis = new FileInputStream(PRODUCT_DB_NAME);
            ois = new ObjectInputStream(fis);
            productList = (ArrayList<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nothing to read");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
