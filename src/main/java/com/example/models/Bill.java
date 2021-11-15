package com.example.models;

import com.example.dao.BillDAO;

public class Bill {
    private int id;
    private BillDAO dao;

    public Bill(int id, Order order) {
        this.id = id;
        dao = new BillDAO(order);
    }

    public void exportToCSV() {
        dao.writeToFile();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bill other = (Bill) obj;
        if (id != other.id)
            return false;
        return true;
    }


}
