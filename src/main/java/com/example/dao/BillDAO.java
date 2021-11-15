package com.example.dao;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.example.interfaces.FileDAO;
import com.example.models.Order;

public class BillDAO implements FileDAO {
    private final String BILL_DB_FILE = "bill.csv";
    private Order order;

    public BillDAO(Order order) {
        this.order = order;
    }

    @Override
    public void writeToFile() {
        OutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(BILL_DB_FILE);
            bos = new BufferedOutputStream(fos);
            byte[] b = order.toString().getBytes();
            bos.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public void readFromFile() {
        // TODO Auto-generated method stub

    }

}
