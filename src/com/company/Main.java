package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String stringInput = "";
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        String[] Items = {"Lettuce", "Tomatoes", "Ground Beef", "Bread", "Cheese", "Onions", "Pickles", "Potatoes"};
        int[] amount = {1,1,1,1,1,1,1,1}; // Parallel array with Items

        while (isRunning){ // Continues to Loop until user chooses to Exit
        for(int i = 0; i < Items.length; i++){ // Prints the List
            System.out.println(amount[i] + " x " + Items[i]);
        }
        System.out.println("Exit");

        System.out.println("Enter the Item you want to change");
        stringInput = scanner.nextLine();

        if(stringInput.equals("Exit")){
            isRunning = false;
            break;
        }

        Integer listNumber = CheckList(stringInput,Items);

        if(listNumber != null)
            {
                ChangeAmount(amount, listNumber);
            }
            else {
                System.out.println("ERROR: Unable to find Item");
                scanner.nextLine();
            }
        }
    }

    // Loops through the list and compares them to the input
    // Return the list number if it finds a match
    public static Integer CheckList(String input, String[] list){
        for(int i = 0; i < list.length; i++){
            if(input.equals(list[i]))
            {
                return i;
            }
        }
        return null;
    }

    // Allows the user to add or subtract the number if items that the user chose
    public static void ChangeAmount(int[] amount, int num){
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        int userAmount = 0;
        boolean isValid = false;

        do {
            System.out.println("Do you want to add or subtract the amount");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Exit");

            userInput = scanner.nextInt();
            switch (userInput){
                case 1:
                    System.out.println("By how much?");
                    userAmount = scanner.nextInt();
                    amount[num] += userAmount;
                    isValid = true;
                    break;
                case 2:
                    System.out.println("By how much?");
                    userAmount = scanner.nextInt();
                    amount[num] -= userAmount;
                    if(amount[num] < 0){
                        System.out.println("ERROR: This will result in a negative amount");
                        System.out.println("Setting amount to 0");
                        amount[num] = 0;
                    }
                    isValid = true;
                    break;
                case 3:
                    isValid = true;
            }
        }while (!isValid);
    }
}

