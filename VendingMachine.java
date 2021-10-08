import java.util.Scanner;
public class VendingMachine {
    private int SN;
    private String location;
    private int water = 0;
    private int coffee = 0;
    private int chips = 0;
    private int chocolate = 0;
    private int name;
    private int gotWater;
    private int gotCoffee;
    private int gotChips;
    private int gotChocolate;
    private double earnings = 0.00;


    public VendingMachine(int Serial, String aLocation){
        SN = Serial;
        location = aLocation;
    }

    public VendingMachine(int Serial){
        SN = Serial;
    }

    public void setLocation(String aLocation){
        location = aLocation;
    }

    public String toString(){
        String output = String.format("Serial Number: %d\n" +
                                      "Location: %s\n" +
                                      "Contents: \n" +
                                      "    Water: %d\n" +
                                      "    Coffee: %d\n"+
                                      "    Chips: %d\n" +
                                      "    Chocolate: %d",SN,location,water,coffee,chips,chocolate);
        return output;
    }

    public boolean equals (VendingMachine otherMachine){
        VendingMachine otherVending = (VendingMachine) otherMachine;

        if (this.water != otherMachine.water){
            return false;
        }
        if (this.coffee != otherMachine.coffee){
            return false;
        }
        if (this.chips != otherMachine.chips){
            return false;
        }
        if (this.chocolate != otherMachine.chocolate){
            return false;
        }
        return true;
    }

    public void setName(int aName){
        name = aName;
    }

    public void reset(int aWater, int aCoffee,int aChips, int aChocolate){
        water = aWater;
        coffee = aCoffee;
        chips = aChips;
        chocolate = aChocolate;
    }
    public void addItems(int aWater, int aCoffee,int aChips, int aChocolate){
        water += aWater;
        coffee += aCoffee;
        chips += aChips;
        chocolate += aChocolate;
    }
    public String displayMenu(){
        String output = String.format("1. Water............$1.50\n" +
                " 2. Coffee...........$2.00\n" +
                " 3. Chips............$1.00\n" +
                " 4. Chocolate........$2.50");

        return output;
    }

    public boolean buyItem(){
        Scanner input = new Scanner(System.in);
        int c;
        int q;
        System.out.print("Select an item number: ");
        c = input.nextInt();
        System.out.print("How many do you want to buy? ");
        q = input.nextInt();
        boolean sufficient = true;
        if (c == 1){
            if(q > water){
                sufficient = false;
                System.out.println("Selection Failed. We don't have enough Water.");
            }
            else {
                System.out.print("You selected Water. Quantity: " + q);
                gotWater = q;
                water -= q;
            }
        }
        if (c == 2){
            if (q > coffee){
                sufficient = false;
                System.out.println("\nSelection Failed. We don't have enough Coffee.");
            }
            else{
                System.out.print("You selected Coffee. Quantity: " + q);
                gotCoffee = q;
                coffee -= q;
            }
        }
        if (c == 3){
            if (q > chips){
                sufficient = false;
                System.out.println("\nSelection Failed. We don't have enough Chips.");
            }
            else {
                System.out.print("You selected Chips. Quantity: " + q);
                gotChips = q;
                chips -= q;
            }
        }
        if (c == 4){
            if (q > chocolate){
                sufficient = false;
                System.out.println("\nSelection Failed. We don't have enough Chocolate.");
            }
            else {
                System.out.print("You selected Chocolate. Quantity: " + q);
                gotChocolate = q;
                chocolate -= q;
            }
        }
        return sufficient;

    }

    public boolean buyItem(int choice,int quantity){
        System.out.print("Select an item number: " + choice);
        System.out.print("\nHow many do you want to buy? " + quantity);
        boolean sufficient = true;
        if (choice == 1){
            if(quantity > water){
                sufficient = false;
                System.out.println("\nSelection Failed. We don't have enough Water.");
            }
            else {
                System.out.print("\nYou selected Water. Quantity: " + quantity);
                gotWater = quantity;
                water -= quantity;
                earnings += 1.50;
            }
        }
        if (choice == 2){
            if (quantity > coffee){
                sufficient = false;
                System.out.println("\nSelection Failed. We don't have enough Coffee.");
            }
            else{
                System.out.print("\nYou selected Coffee. Quantity: " + quantity);
                gotCoffee = quantity;
                coffee -= quantity;
                earnings += 2.00;
            }
        }
        if (choice == 3){
            if (quantity > chips){
                sufficient = false;
                System.out.println("\nSelection Failed. We don't have enough Chips.");
            }
            else {
                System.out.print("\nYou selected Chips. Quantity: " + quantity);
                gotChips = quantity;
                chips -= quantity;
                earnings += 1.00;
            }
        }
        if (choice == 4){
            if (quantity > chocolate){
                sufficient = false;
                System.out.println("\nSelection Failed. We don't have enough Chocolate.");
            }
            else {
                System.out.print("\nYou selected Chocolate. Quantity: " + quantity);
                gotChocolate = quantity;
                chocolate -= quantity;
                earnings += 2.50;
            }
        }
        return sufficient;
    }

    public void returned(int choice, int quantity){
        if (choice == 1){
            water += quantity;
            gotWater -= quantity;
            earnings -= 1.50;
            System.out.print("\nYou selected Water. Quantity: " + quantity);
        }
        if (choice == 2){
            coffee += quantity;
            gotCoffee -= quantity;
            earnings -= 2.00;
            System.out.print("\nYou selected Coffee. Quantity: " + quantity);
        }
        if (choice == 3){
            chips += quantity;
            gotChips -= quantity;
            earnings -= 1.00;
            System.out.print("\nYou selected Chips. Quantity: " + quantity);
        }
        if (choice == 4){
            chocolate += quantity;
            gotChocolate -= quantity;
            earnings -= 2.50;
            System.out.print("\nYou selected Chocolate. Quantity: " + quantity);
        }
    }
    public boolean payment(){
        boolean success = true;
        Scanner input = new Scanner(System.in);
        double money;
        double pay = earnings;
        double tax = pay * 0.10;
        System.out.print("Enter money amount: ");
        money = input.nextDouble();
        if(money < pay){
            System.out.println("Insufficient money. $" + money + " returned");
            success = false;
        }
        System.out.println("Sufficient money. $" + (money - pay) + tax + " returned");

        return success;

    }
    public void displayReceipt(){
        if (gotWater > 0){
            System.out.println("Water: $1.50 X " + gotWater + " = " + 1.50 * gotWater);
        }
        if (gotCoffee > 0){
            System.out.println("Coffee: $2.00 X " + gotCoffee + " = " + 2.00 * gotCoffee);
        }
        if (gotChips > 0){
            System.out.println("Chips: $1.00 X " + gotChips + " = " + 1.00 * gotChips);
        }
        if (gotChocolate > 0){
            System.out.println("Chocolate: $2.50 X " + gotChocolate + " = " + 2.50 * gotChocolate);
        }
        double tax = earnings * 0.10;
        System.out.println("Tax (10.0%): $" + tax);
        System.out.println("Total: $" + earnings + tax);

    }
    public void status(){
        double tax = earnings * 0.10;
        earnings += tax;
        String display = String.format("Serial Number: %d\n" +
                                      "Location: %s\n" +
                                      "Sold Items: \n" +
                                      "    Water: %d\n" +
                                      "    Coffee: %d\n"+
                                      "    Chips: %d\n" +
                                      "    Chocolate: %d\n" +
                                      "Current Contents: \n" +
                                      "    Water: %d\n" +
                                      "    Coffee: %d\n"+
                                      "    Chips: %d\n" +
                                      "    Chocolate: %d\n"+
                                      "Total Earnings: $%2f",SN,location,gotWater,gotCoffee,gotChips,gotChocolate,water,coffee,chips,chocolate,earnings);
        System.out.print(display);
    }

}
