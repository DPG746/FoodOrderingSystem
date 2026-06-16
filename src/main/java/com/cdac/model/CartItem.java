package com.cdac.model;

public class CartItem {

    private String foodName;
    private int quantity;
    private double total;

    public CartItem(
            String foodName,
            int quantity,
            double total)
    {
        this.foodName = foodName;
        this.quantity = quantity;
        this.total = total;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }
}