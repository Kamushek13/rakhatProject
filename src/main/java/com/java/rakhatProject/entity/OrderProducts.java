package com.java.rakhatProject.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderProducts {

    private ArrayList<Long> id;
    private ArrayList<Integer> quantity;

    public ArrayList<Long> getId() {
        return id;
    }

    public void setId(ArrayList<Long> id) {
        this.id = id;
    }

    public ArrayList<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<Integer> quantity) {
        this.quantity = quantity;
    }
}
