package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Ne yapmak istiyorsunuz?");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                case 2:
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
            }
        }
        while (choice != 0);
        scanner.close();

    }
    public static void addItems(String input){
        String[] splitInput = input.split(",");
        for(String thing : splitInput) {
            String trimmed = thing.trim();
            if(checkItemIsInList(trimmed)){
                System.out.println("Ürün zaten listede ->" + thing);
            } else {
                groceryList.add(trimmed);
                printSorted();
            }
        }
    }
    public static void removeItems(String input){
        String[] splitInput = input.split(",");
        for(String thing : splitInput) {
            String trimmed = thing.trim();
            if(checkItemIsInList(trimmed)){
                groceryList.remove(trimmed);
                printSorted();
            } else {
                System.out.println("Ürün zaten listede değil ->" + thing);
            }
        }
    }
    private static boolean checkItemIsInList(String product){
        return groceryList.contains(product);
    }
    public static void printSorted(){
        System.out.println("Grocery List:");
        Collections.sort(groceryList);
        for(String item : groceryList){
            System.out.println(item);
        }
    }

}
