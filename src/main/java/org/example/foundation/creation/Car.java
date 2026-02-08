package org.example.foundation.creation;

import java.util.Locale;

public class Car {
    // required fields
    private final String model;
    private final String manufacturer;

    //Optional fields
    private final String color;
    private final String engineType;
    private final String transmission;
    private final boolean sunroof;
    private final boolean leatherSeats;
    private final boolean navigationSystem;
    private final boolean parkingAssist;
    private final String soundSystem;
    private final int warrantyYears;

    private Car(CarBuilder builder) {
        this.model = builder.model;
        this.manufacturer = builder.manufacturer;
        this.color = builder.color;
        this.engineType = builder.engineType;
        this.transmission = builder.transmission;
        this.sunroof = builder.sunroof;
        this.leatherSeats = builder.leatherSeats;
        this.navigationSystem = builder.navigationSystem;
        this.parkingAssist = builder.parkingAssist;
        this.soundSystem = builder.soundSystem;
        this.warrantyYears = builder.warrantyYears;
    }

    public int getBasePrice() {
        switch (model.toUpperCase(Locale.ROOT)) {
            case "SEDAN" -> {
                return 25000;
            }
            case "SUV" -> {
                return 35000;
            }
            case "TRUCK" -> {
                return 30000;
            }
            case "SPORTS" -> {
                return 50000;
            }

            default -> {
                return 0;
            }
        }

    }

    public int getEnginePrince() {
        int price = 0;
        if (engineType.equalsIgnoreCase("gasoline")) {
            price = 0;
        }

        if (engineType.equalsIgnoreCase("electric")) {
            price = 15000;
        }

        if (engineType.equalsIgnoreCase("hybrid")) {
            price = 8000;
        }

        if (engineType.equalsIgnoreCase("diesel")) {
            price = 3000;
        }


        return price;

    }

    public int getSoundSystemPrice() {
        int price = 0;
        if (soundSystem.equalsIgnoreCase("premium")) {
            price = 1500;
        } else if(soundSystem.equalsIgnoreCase("luxury")) {
            price = 3500;
        }

        return price;
    }

    public int getExtendedWarrantyPrice() {
        int extendedYears = warrantyYears - 3;
        return extendedYears * 500;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        int modelPrice = getBasePrice();
        int enginePrice = getEnginePrince();
        int soundSysPrice = getSoundSystemPrice();
        int extendWarantyPrice = getExtendedWarrantyPrice();
        if (sunroof) {
            totalPrice += 1500;
        }

        if (leatherSeats) {
            totalPrice += 2500;
        }

        if (navigationSystem) {
            totalPrice += 2000;
        }

        if (parkingAssist) {
            totalPrice += 1200;
        }

        totalPrice += modelPrice + enginePrice + soundSysPrice + extendWarantyPrice;

        return totalPrice;

    }

    public String getSpecificationSheet() {
        return "Car Specification Sheet\n" +
                "========================\n" +
                "Model: " + model + "\n" +
                "Manufacturer: " + manufacturer + "\n" +
                "Color: " + color + "\n" +
                "Engine Type: " + engineType + "\n" +
                "Transmission: " + transmission + "\n" +
                "Sunroof: " + (sunroof ? "Yes" : "No") + "\n" +
                "Leather Seats: " + (leatherSeats ? "Yes" : "No") + "\n" +
                "Navigation System: " + (navigationSystem ? "Yes" : "No") + "\n" +
                "Parking Assist: " + (parkingAssist ? "Yes" : "No") + "\n" +
                "Sound System: " + soundSystem + "\n" +
                "Warranty Years: " + warrantyYears + "\n" +
                "========================\n" +
                "Base Price: $" + getBasePrice() + "\n" +
                "Total Price: $" + getTotalPrice();
    }
    public static class CarBuilder {
        // required fields
        private final String model;
        private final String manufacturer;

        // optional fields
        private String color = "WHITE";
        private String engineType = "GASOLINE";
        private String transmission = "AUTOMATIC";
        private boolean sunroof = false;
        private boolean leatherSeats = false;
        private boolean navigationSystem = false;
        private boolean parkingAssist = false;
        private String soundSystem = "BASIC";
        private int warrantyYears = 3;

        public CarBuilder(String model, String manufacturer) {
            this.model = model;
            this.manufacturer = manufacturer;
        }

        // Setter methods
        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder engineType(String engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarBuilder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarBuilder sunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder leatherSeats(boolean leatherSeats) {
            this.leatherSeats = leatherSeats;
            return this;
        }

        public CarBuilder navigationSystem(boolean navSystem) {
            this.navigationSystem = navSystem;
            return this;
        }

        public CarBuilder parkingAssist(boolean parkSys) {
            this.parkingAssist = parkSys;
            return this;
        }

        public CarBuilder soundSystem(String soundSystem) {
            this.soundSystem = soundSystem;
            return this;
        }

        public CarBuilder warrantyYears(int years) {
            this.warrantyYears = years;
            return this;
        }

        // Build method
        public Car build() {
            if (model == null || model.isEmpty()) {
                throw new IllegalArgumentException("Model cannot be empty or null");
            }

            if (manufacturer == null || manufacturer.isEmpty()) {
                throw new IllegalArgumentException("Manufacturer be empty or null");
            }

            if (color == null) {
                throw new IllegalArgumentException("Color cannot be null");
            }

            if (model.equalsIgnoreCase("sports") && transmission.equalsIgnoreCase("manual")) {
                throw new IllegalArgumentException("Transmission must be automatic for sports cars");
            }

            if (warrantyYears < 1 || warrantyYears > 10) {
                throw new IllegalArgumentException("Warranty years must be between 1 and 10");
            }
            return new Car(this);
        }

    }

}
