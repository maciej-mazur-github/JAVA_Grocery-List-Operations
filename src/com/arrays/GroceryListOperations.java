package com.arrays;

public class GroceryListOperations {
    private GroceryList groceryList = new GroceryList();

    public void runShoppingLoop() {
        System.out.println("Welcome to the shopping list operations program!");
        System.out.println("***********************************************\n");
        printOptions();
        mainLoop();
        System.out.println("***********************************\n");
        System.out.println("You have decided to quit the program");
    }

    private void printOptions() {
        System.out.println("******************************************");
        System.out.println("Press: ");
        System.out.println("\t0 - To print the choice list");
        System.out.println("\t1 - To print current Grocery List status");
        System.out.println("\t2 - To add an item to the list");
        System.out.println("\t3 - To modify an item in the list");
        System.out.println("\t4 - To remove an item from the list");
        System.out.println("\t5 - To search for a specific item");
        System.out.println("\t6 - To quit the program");
        System.out.println("******************************************");
    }

    private void mainLoop() {

    }
}


















