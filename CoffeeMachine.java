
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class CoffeMaker {
    
    private int water;
    private int milk;
    private int coffeebeans;
    private int cups;
    private int money;
    
    public CoffeMaker() {
        this.water = 400;
        this.milk = 540;
        this.coffeebeans = 120;
        this.cups = 9;
        this.money = 550;
    }
    
    public void printDetails() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water%n",this.water);
        System.out.printf("%d of milk%n",this.milk);
        System.out.printf("%d of coffee beans%n",this.coffeebeans);
        System.out.printf("%d of disposable cups%n",this.cups);
        System.out.printf("%d of money%n",this.money);    
    }
    
    public void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        this.water += addWater;
        
        System.out.println("Write how many ml of milk do you want to add: ");
        int addMilk = scanner.nextInt();
        this.milk += addMilk;
        
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addBeans = scanner.nextInt();
        this.coffeebeans += addBeans;
        
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();
        this.cups += addCups;
    }
    
    public void takeMoney() {
        System.out.printf("I gave you $%d %n",this.money);
        this.money = 0;
    }
    
    public int whatAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String choice = scanner.nextLine();
        int i = 0;
        if ("buy".equals(choice)) {
            i =  1;
        }
        
        if ("fill".equals(choice)) {
            i =  2;
        }
        
        if ("take".equals(choice)) {
            i =  3;
        }
        
        if ("remaining".equals(choice)) {
            i = 4;
        }
        
        if ("exit".equals(choice)) {
            i = 0;
        }
        
        return i;
    }
    
    public void sellCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String resp = scanner.nextLine();
        if ("back".equals(resp)) {
            return;
        }
        
        int key =Integer.parseInt(resp);
        
        switch (key) {
            case 1:
                if (this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (this.coffeebeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return;
                }
                if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    return;
                }

                this.water -= 250;
                this.coffeebeans -= 16;
                this.cups -= 1;
                this.money += 4;
                return;
            case 2:
                if (this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                if (this.coffeebeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return;
                }
                
                if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    return;
                }
                
                System.out.println("I have enough resources, making you a coffee!");
                this.water -= 350;
                this.milk -= 75;
                this.coffeebeans -= 20;
                this.money += 7;
                this.cups -= 1;
                
                return;
                
            case 3:
                if (this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                
                if (this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    return;
                }
                
                if (this.coffeebeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                    return;
                }
                
                if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                    return;
                }
                
                this.water -= 200;
                this.milk -= 100;
                this.coffeebeans -= 12;
                this.money += 6;
                this.cups -= 1;
                
                return;
            
        }   
    }
} 




public class CoffeeMachine {
    public static void main(String[] args) {
        CoffeMaker machine = new CoffeMaker();
        //machine.printDetails();
        
        boolean working = true;
        
        while (working) {
            int key = machine.whatAction();
        
            if (key == 1) {
                machine.sellCoffee();
                //machine.printDetails();
            }
            
            else if (key == 2) {
                machine.fillMachine();
                //machine.printDetails();
            }
            
            else if (key == 3) {
                machine.takeMoney();
                //machine.printDetails();
            }
            
            else if (key == 4) {
                machine.printDetails();
            }
            
            else if (key == 0) {
                working = false;
            }
            
        }
    }
}
