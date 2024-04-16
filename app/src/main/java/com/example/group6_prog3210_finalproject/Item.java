package com.example.group6_prog3210_finalproject;

public class Item {
    private int id;
    private String name;
    private String description;
    private double price;
    private int subcategoryId; // New field for subcategory ID


    // Default constructor
    public Item() {
        // Default values or leave fields uninitialized
    }

    // Constructor
    public Item(int id, String name, String description, double price, int subcategoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.subcategoryId = subcategoryId;

    }


    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }


    // Setter and getter for image data

}