package org.example;

import org.example.foundation.creation.Car;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Car Builder Exercise ===\n");

        // Test 1: Basic sedan
        System.out.println("Car #1: Economy Sedan");
        Car car1 = new Car.CarBuilder("Sedan", "Toyota")
                .color("Silver")
                .build();
        System.out.println(car1.getSpecificationSheet());
        System.out.println("\n");

        // Test 2: Luxury SUV
        System.out.println("Car #2: Luxury SUV");
        Car car2 = new Car.CarBuilder("SUV", "BMW")
                .color("Black")
                .engineType("HYBRID")
                .sunroof(true)
                .leatherSeats(true)
                .navigationSystem(true)
                .parkingAssist(true)
                .soundSystem("LUXURY")
                .warrantyYears(5)
                .build();
        System.out.println(car2.getSpecificationSheet());
        System.out.println("\n");

        // Test 3: Electric truck
        System.out.println("Car #3: Electric Truck");
        Car car3 = new Car.CarBuilder("Truck", "Tesla")
                .color("White")
                .engineType("ELECTRIC")
                .navigationSystem(true)
                .build();
        System.out.println(car3.getSpecificationSheet());
        System.out.println("\n");

        // Test 4: Sports car with premium features
        System.out.println("Car #4: Sports Car");
        Car car4 = new Car.CarBuilder("Sports", "Porsche")
                .color("Red")
                .engineType("GASOLINE")
                .transmission("AUTOMATIC")
                .leatherSeats(true)
                .soundSystem("PREMIUM")
                .warrantyYears(4)
                .build();
        System.out.println(car4.getSpecificationSheet());
        System.out.println("\n");

        // Test 5: Try to create invalid car (Sports with Manual)
        System.out.println("Test #5: Validation Test - Sports with Manual");
        try {
            Car invalidCar = new Car.CarBuilder("Sports", "Ferrari")
                    .transmission("MANUAL")
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation worked! Error: " + e.getMessage());
        }
        System.out.println("\n");

        // Test 6: Invalid warranty
        System.out.println("Test #6: Validation Test - Invalid Warranty");
        try {
            Car invalidWarranty = new Car.CarBuilder("Sedan", "Honda")
                    .warrantyYears(15)
                    .build();
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation worked! Error: " + e.getMessage());
        }
    }
}