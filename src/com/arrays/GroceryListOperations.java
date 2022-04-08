package com.arrays;

import java.util.Scanner;

public class GroceryListOperations {
    private GroceryList groceryList = new GroceryList();
    private Scanner scanner = new Scanner(System.in);

    public void runShoppingLoop() {
        System.out.println("Welcome to the shopping list operations program!");
        System.out.println("***********************************************\n");
        printOptions();
        mainLoop();
        System.out.println("***********************************\n");
        System.out.println("You have decided to quit the program");
    }

    private void printOptions() {
        System.out.println("\n******************************************");
        System.out.println("Press: ");
        System.out.println("\t0 - To print the choice list");
        System.out.println("\t1 - To print current Grocery List status");
        System.out.println("\t2 - To add an item to the list");
        System.out.println("\t3 - To modify an item in the list");
        System.out.println("\t4 - To remove an item from the list");
        System.out.println("\t5 - To search for a specific item");
        System.out.println("\t6 - To quit the program");

    }

    private void mainLoop() {
        int choice;
        boolean continueMainLoop = true;

        while (continueMainLoop) {
            System.out.print("\nWhat is your choice? ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    printOptions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case  2:
                    groceryList.addGroceryItem();
                    break;
                case 3:
                    groceryList.modifyGroceryItem();
                    break;
                case 4:
                    groceryList.removeGroceryItem();
                    break;
                case 5:
                    groceryList.searchForItem();
                    break;
                case 6:
                    continueMainLoop = false;
                    break;
                default:
                    System.out.println("Invalid choice number. Try again");
            }
        }
    }
}


















