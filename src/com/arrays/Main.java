package com.arrays;

public class Main {
    public static void main(String[] args) {
        GroceryList groceryList = new GroceryList();
        System.out.println(groceryList.getListElementCount());
        groceryList.addGroceryItem();
        System.out.println(groceryList.getListElementCount());
    }
}
