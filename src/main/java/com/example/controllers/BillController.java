package com.example.controllers;

import com.example.models.Bill;
import com.example.views.BillView;

public class BillController {
    Bill model;
    BillView view;

    public BillController(Bill model, BillView view) {
        this.model = model;
        this.view = view;
    }

    public void exportToCSV() {
        model.exportToCSV();
    }
}
