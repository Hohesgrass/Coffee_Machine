package machine;

import java.util.Arrays;
import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int dispoCups = 9;
    static int money = 550;
    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            exit = selectAction();
        }

    }

    private static boolean selectAction() {
        Scanner data = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = data.next();
        switch(action) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                getMachineContent();
                break;
            case "exit":
                exit = true;
                break;
            default:
                System.out.println("Bad action");
        }
        return exit;
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void fillMachine() {
        Scanner data = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        water += data.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += data.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffeeBeans += data.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        dispoCups += data.nextInt();
    }

    private static void buyCoffee() {
        Scanner data = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String coffee = data.next();
        switch (coffee) {
            case "1":
                if (checkResources(1)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    dispoCups -= 1;
                } else{
                    break;
                }
                break;
            case "2":
                if (checkResources(2)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    dispoCups -= 1;
                } else {
                    break;
                }
                break;
            case "3":
                if (checkResources(3)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    dispoCups -= 1;
                } else {
                    break;
                }
                break;
            case "back":
                break;
            default:
                System.out.println("bad number");
        }
    }

    private static void getMachineContent() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(dispoCups + " of disposable cups");
        System.out.println(money + " of money\n");
    }

    private static boolean checkResources(int i) {
        boolean check = false;
        switch (i) {
            case 1:
                if (water - 250 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (coffeeBeans - 16 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (dispoCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    check = true;
                }
                break;
            case 2:
                if (water - 350 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk - 75 < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeans - 20 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (dispoCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    check = true;
                }
                break;
            case 3:
                if (water - 200 < 0) {
                    System.out.println("Sorry, not enough water!");
                } else if (milk - 100 < 0) {
                    System.out.println("Sorry, not enough milk!");
                } else if (coffeeBeans - 12 < 0) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (dispoCups - 1 < 0) {
                    System.out.println("Sorry, not enough disposable cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    check = true;
                }
                break;
            default:
                return false;
        }
        return check;
    }

    public static void getIngredients(int cups) {
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(cups * 200 + " ml of water");
        System.out.println(cups * 50 + " ml of milk");
        System.out.println(cups * 15 + " g of coffee beans");
    }
}

/*
System.out.println("Write how many ml of water the coffee machine has: ");
        int water = data.nextInt();
        int cWater = water / 200;
        System.out.println(cWater);
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = data.nextInt();
        int cMilk = milk / 50;
        System.out.println(cMilk);
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffee = data.nextInt();
        int cCoffee = coffee / 15;
        System.out.println(cCoffee);
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = data.nextInt();
        int[] coffeeData = {cWater, cMilk, cCoffee};

        Arrays.sort(coffeeData);

        int moreCups = coffeeData[0] - cups;
        if (cups <= coffeeData[0]) {
            if (moreCups != 0) {
                System.out.println("Yes, I can make that amount of coffee (and even " + moreCups + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.println("No, I can make only " + coffeeData[0] + " cup(s) of coffee");
        }
 */
