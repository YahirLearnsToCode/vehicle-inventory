package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class Vehicle {
    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private double price;
    private static int carsCounter = 0;

    public Vehicle(long vehicleId, String makeModel, String color, int odometerReading, double price) {
        this.vehicleId = vehicleId;
        this.price = price;
        this.odometerReading = odometerReading;
        this.color = color;
        this.makeModel = makeModel;
        carsCounter++;
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Vehicle[] cars = new Vehicle[20];

        // preloading the array with vehicle objects and incrementing carCounter
        cars[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        cars[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        cars[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        cars[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        cars[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        cars[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        displayMenu(); // displaying menu choices

        // receiving command
        int command = Integer.parseInt(myScanner.nextLine());
        switch (command) {
            case 1 -> listAllVehicles(cars);
            case 2 -> searchByModel(cars, myScanner);
            case 3 -> searchByPriceRange(cars, myScanner);
            case 4 -> searchByColor(cars,myScanner);
            case 5 -> addVehicle(cars, myScanner);
            case 6 -> System.exit(0);
            default -> System.out.println("Invalid Choice");
        }
    }

    public static void listAllVehicles(Vehicle[] cars) {
        int i = 0;

        while (i < carsCounter && cars != null) {
            System.out.println(cars[i].toString());
            i++;
        }
    }

    public static String searchByPriceRange(Vehicle[] cars, Scanner myScanner) {
        System.out.print("What price range are you searching for? ");
        double priceRange = Double.parseDouble(myScanner.nextLine());

        for (int i = 0; i < carsCounter && cars[i] != null; i++) {
            if (priceRange >= cars[i].getPrice()) {
                return cars[i].toString();
            }
        }
        return "No car under that price range exists";
    }

    public static String searchByModel(Vehicle[] cars, Scanner myScanner) {
        System.out.print("What price range are you looking for? ");
        String makeModel = myScanner.nextLine();

        for (int i = 0; i < carsCounter && cars[i] != null; i++) {

            if (makeModel.equalsIgnoreCase(cars[i].getMakeModel())) {
                return cars[i].toString();
            }
        }
        return "No model of that name exists";
    }

    public static String searchByColor(Vehicle[] cars, Scanner myScanner) {
        System.out.print("What color are you looking for? ");
        String color = myScanner.nextLine();

        for (int i = 0; i < carsCounter && cars[i] != null; i++) {

            if (color.equalsIgnoreCase(cars[i].getColor())) {
                return cars[i].toString();
            }
        }
        return "Sorry, we don't have a car of that color";
    }

    public static void addVehicle(Vehicle[] cars, Scanner myScanner) {
        System.out.print("Enter vehicle ID: ");
        long vehicleId = Long.parseLong(myScanner.nextLine());

        System.out.print("Enter make model: ");
        String makeModel = myScanner.nextLine();

        System.out.print("Enter car color: ");
        String color = myScanner.nextLine();

        System.out.print("Enter car odometer reading: ");
        int odometerReading = Integer.parseInt(myScanner.nextLine());

        System.out.print("Enter car price: ");
        double price = Double.parseDouble(myScanner.nextLine());

        cars[carsCounter] = new Vehicle(vehicleId,makeModel,color,odometerReading,price);

        System.out.println("Your new car has been inputted : " + cars[carsCounter-1].toString());
    }

    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId + ", Model: " + makeModel + ", Color: " + ", Odometer Reading: " + odometerReading + ", Price: " + price;
    }

    public static void displayMenu() {
        String menu = """
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit \n
                Enter your command: 
                """;
        System.out.print(menu);

    }

    //region getters/setters
    public long getVehicleId() {
        return vehicleId;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public String getColor() {
        return color;
    }

    public int getOdometerReading() {
        return odometerReading;
    }

    public double getPrice() {
        return price;
    }

    public void setOdometerReading(int odometerReading) {
        this.odometerReading = odometerReading;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }
//endregion
}