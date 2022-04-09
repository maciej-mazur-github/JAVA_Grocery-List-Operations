package com.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryListOperations {
    private final GroceryList groceryList = new GroceryList();
    private final Scanner scanner = new Scanner(System.in);

    public void runShoppingLoop() {
        System.out.println("Welcome to the shopping list operations program!");
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
            System.out.print("\nWhat is your choice? (Press 0 to print the available options) ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0 -> printOptions();
                case 1 -> groceryList.printGroceryList();
                case 2 -> groceryList.addGroceryItem();
                case 3 -> groceryList.modifyGroceryItem();
                case 4 -> groceryList.removeGroceryItem();
                case 5 -> groceryList.searchForItem();
                case 6 -> continueMainLoop = false;
                default -> System.out.println("Invalid choice number. Try again");
            }
        }
    }






    //*********************************************************************************
    //    Made GroceryList inner class (instead of earlier stand alone public class) for encapsulation purposes

    private class GroceryList {
        private final ArrayList<String> groceryList = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        private void addItem(String item) {
            groceryList.add(item);
        }

        public void addGroceryItem() {
            System.out.print("Enter the new item name: ");
            String itemName = scanner.nextLine();
            addItem(itemName);
            System.out.println(itemName + " has been successfully added to the list");
        }

        private boolean removeItem(int position) {
            if(isInList(position)) {
                groceryList.remove(position);
                return true;
            } else {
                return false;
            }

        }

        private boolean removeItem(String item) {
            return removeItem(findItem(item));
        }

        public void removeGroceryItem() {
            System.out.print("What item do you need to remove from your list? ");

            if(scanner.hasNextInt()) {
                int positionToRemove = scanner.nextInt() - 1;

                if(isInList(positionToRemove)) {
                    String itemToRemove = groceryList.get(positionToRemove);
                    removeItem(positionToRemove);
                    System.out.println(itemToRemove + " has been successfully removed");
                } else {
                    System.out.println("There is no position " + (positionToRemove + 1) + " on the list");
                }
            } else {   // when the entered value is not int, therefore will be treated as String
                String itemToRemove = scanner.nextLine();
                if(removeItem(itemToRemove)) {
                    System.out.println(itemToRemove + " has been successfully removed");
                } else {
                    System.out.println(itemToRemove + " could not be found in the list");
                }

                return;
            }



        }

        private boolean modifyItem(int position, String newItem) {
            if(position >= 0 && position < groceryList.size()) {
                groceryList.set(position, newItem);
                return true;
            } else {
                return false;
            }

        }

        private boolean modifyItem(String currentItem, String newItem) {
            return modifyItem(findItem(currentItem), newItem);
        }


        public void modifyGroceryItem() {
            System.out.print("Which item would you like to replace?: ");
            boolean isItString;
            String itemToReplace = null;
            int positionToReplace = 0;


            if(scanner.hasNextInt()) {
                positionToReplace = scanner.nextInt() - 1;
                if(!isInList(positionToReplace)) {
                    System.out.println("There is no position " + positionToReplace + " in the list");
                    return;
                }
                isItString = false;
                itemToReplace = groceryList.get(positionToReplace);
                scanner.nextLine();             // to clear the scanner buffer
            } else {                            // otherwise the entered value will be treated as String
                itemToReplace = scanner.nextLine();
                if (!isInList(itemToReplace)) {
                    System.out.println(itemToReplace + " item could not be found on the list");
                    return;
                }
                isItString = true;
            }

            System.out.print("What item would like to replace the " + itemToReplace + " with?: ");
            String newItem = scanner.nextLine();

            if(isItString) {
                if(modifyItem(itemToReplace, newItem)) {
                    System.out.println(itemToReplace + " item has been successfully replaced with " + newItem);
                } else {
                    System.out.println(itemToReplace + " item could not be found on the list");
                }
            } else {
                if(isInList(positionToReplace)) {
                    itemToReplace = groceryList.get(positionToReplace);
                    modifyItem(positionToReplace, newItem);
                    System.out.println(itemToReplace + " has been successfully replaced with " + newItem);
                } else {
                    System.out.println("There is no position " + positionToReplace + " in the list");
                }
            }
        }

        private int findItem(String item) {
            return groceryList.indexOf(item);
        }

        private boolean isInList(String item) {
            return findItem(item) >= 0;
        }

        private boolean isInList(int position) {
            return position >= 0 && position < groceryList.size();
        }

        public void searchForItem() {
            System.out.print("Presence of which item would you like to check in the list? ");
            String itemToSearch = scanner.nextLine();
            if(isInList(itemToSearch)) {
                System.out.println(itemToSearch + " is present on your list at the position " + (groceryList.indexOf(itemToSearch) + 1));
            } else {
                System.out.println("There is no " + itemToSearch + " on your list");
            }
        }



        public void printGroceryList() {
            System.out.println("You currently have " + groceryList.size() + " items in your list:");
            System.out.println("*****************************");

            for(int i = 0; i < groceryList.size(); i++) {
                System.out.println("Item " + (i + 1) + ": " + groceryList.get(i));
            }
            System.out.println("*****************************");
        }


    }
}


















