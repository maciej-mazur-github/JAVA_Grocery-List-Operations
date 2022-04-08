package com.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();
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

        if(scanner.hasNextLine()) {
            String itemToRemove = scanner.nextLine();
            if(removeItem(itemToRemove)) {
                System.out.println(itemToRemove + " has been successfully removed");
            } else {
                System.out.println(itemToRemove + " could not be found in the list");
            }

            return;
        }

        if(scanner.hasNextInt()) {
            int positionToRemove = scanner.nextInt() - 1;

            if(isInList(positionToRemove)) {
                String itemToRemove = groceryList.get(positionToRemove);
                removeItem(positionToRemove);
                System.out.println(itemToRemove + " has been successfully removed");
            } else {
                System.out.println("There is no position " + (positionToRemove + 1) + " on the list");
            }
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

        if(scanner.hasNextLine()) {
            itemToReplace = scanner.nextLine();
            isItString = true;
        } else {
            positionToReplace = scanner.nextInt() - 1;
            isItString = false;
        }

        System.out.print("What item would like to replace the aforementioned one with?: ");
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
        return findItem(item) >= 0 ? true : false;
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

    private boolean isInList(int position) {
        return position >= 0 && position < groceryList.size() ? true : false;
    }

    public void printGroceryList() {
        System.out.println("You currently have " + groceryList.size() + " items in your list:");
        System.out.println("\n*****************************");

        for(int i = 0; i < groceryList.size(); i++) {
            System.out.println("Item " + (i + 1) + ": " + groceryList.get(i));
        }
    }

    public int getListElementCount() {
        return groceryList.size();
    }
}















