package machine;

import java.util.Scanner;


public class CoffeeMachine {
    public static void main(String[] args) {
        boolean isFinish;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String choice = scanner.next();
            Operation operation = Operation.valueOf(choice.toUpperCase());
            isFinish = CoffeeExpress.choiceOperation(operation);
        } while (!isFinish);
    }
}


class CoffeeExpress {

    private static int templateWater = 400;
    private static int templateMilk = 540;
    private static int templateCoffee = 120;
    private static int templateCups = 9;
    private static int templateMoney = 550;
    private static final Scanner scanner = new Scanner(System.in);

    public static boolean choiceOperation(Operation operation) {

        switch (operation) {
            case BUY:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
                String typeOfCoffee = scanner.next();
                doACoffee(typeOfCoffee);
                break;
            case FILL:
                fillExpress();
                break;
            case TAKE:
                takeMoney();
                break;
            case REMAINING:
                displayIngredients();
                break;
            case EXIT:
                return true;
        }
        return false;
    }

    private static void takeMoney() {
        System.out.println("I gave you $" + templateMoney);
        templateMoney = 0;
    }

    private static void fillExpress() {
        System.out.println("Write how many ml of water do you want to add: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee do you want to add: ");
        int coffee = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int cups = scanner.nextInt();
        changeIngredients(water, milk, coffee, cups, 0, false);
    }

    private static void displayIngredients() {
        System.out.println("The coffee machine has:\n" +
                templateWater + " of water\n" +
                templateMilk + " of milk\n" +
                templateCoffee + " of coffee beans\n" +
                templateCups + " of disposable cups\n" +
                "$" + templateMoney + " of money");
    }

    private static boolean doIHaveEnough(int water, int milk, int coffee) {
        if (water > templateWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk > templateMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (coffee > templateCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (1 > templateCups) {
            System.out.println("Sorry, not enough cups of coffee!");
            return false;
        }
        return true;
    }

    private static void doACoffee(String typeOfCoffee) {
        boolean Enough;
        switch (typeOfCoffee) {
            case "1":
                Enough = doIHaveEnough(250, 0, 16);
                if (Enough) {
                    changeIngredients(250, 0, 16, 1, 4, true);
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                Enough = doIHaveEnough(350, 75, 20);
                if (Enough) {
                    changeIngredients(350, 75, 20, 1, 7, true);
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                Enough = doIHaveEnough(200, 100, 12);
                if (Enough) {
                    changeIngredients(200, 100, 12, 1, 6, true);
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "back":
                break;
        }

    }

    /**
     * @param typeOfChange true - buy, false - fill
     */
    private static void changeIngredients(int water, int milk, int coffee, int cups, int money, boolean typeOfChange) {
        templateWater = typeOfChange ? templateWater - water : templateWater + water;
        templateMilk = typeOfChange ? templateMilk - milk : templateMilk + milk;
        templateCoffee = typeOfChange ? templateCoffee - coffee : templateCoffee + coffee;
        templateCups = typeOfChange ? templateCups - 1 : templateCups + cups;
        templateMoney += money;
    }
}

enum Operation {
    BUY,
    FILL,
    TAKE,
    REMAINING,
    EXIT,
}
