package com.example.group6_prog3210_finalproject;

public class CartItem {
    private int cartId;
    private int userId;
    private int itemId;
    private int quantity;
    private double fee;
    private String title;
    private String pic;
    private int numberInCart;

    private double price; // Changed from 'fee'
    private String name; // Changed from 'title'

    // Constructors
    public CartItem() {
    }

    public CartItem(int cartId, int userId, int itemId, int quantity, double fee, String title, String pic, double price, String name) {
        this.cartId = cartId;
        this.userId = userId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.fee = fee;
        this.title = title;
        this.pic = pic;
        this.price = price;
        this.name = name;
    }

    // Getters and setters
    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Getters and setters for numberInCart
    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
