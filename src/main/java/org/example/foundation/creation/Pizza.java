package org.example.foundation.creation;

public class Pizza {
    // Required
    private final String size;

    // Optional parameters for addOns
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;
    private final boolean olives;
    private final boolean extraCheese;
    private final String crustType;

    // Private constructor
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.mushrooms = builder.mushrooms;
        this.olives = builder.olives;
        this.extraCheese = builder.extraCheese;
        this.pepperoni = builder.pepperoni;
        this.crustType = builder.crustType;
    }

    // Getters
    public String getSize() { return size; }
    public boolean getCheese() { return cheese; }
    public boolean getPepperoni() { return pepperoni; }
    public boolean getOlives() { return olives; }
    public boolean getMushrooms() { return mushrooms; }
    public String getCrustType() { return crustType; }
    public boolean getExtraCheese() { return extraCheese; }

    public double getPrice() {
        double currentPrice = 0;

        // Base price by size
        switch (size) {
            case "SMALL" -> currentPrice += 8.0;
            case "MEDIUM" -> currentPrice += 10.0;
            case "LARGE" -> currentPrice += 12.0;
        }

        // Toppings ($1.50 each)
        if (cheese) currentPrice += 1.50;
        if (pepperoni) currentPrice += 1.50;
        if (olives) currentPrice += 1.50;
        if (mushrooms) currentPrice += 1.50;

        // Extra cheese ($2)
        if (extraCheese) currentPrice += 2.0;

        // Thick crust ($1.50)
        if (crustType.equalsIgnoreCase("THICK")) {
            currentPrice += 1.50;
        }

        return currentPrice;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", mushrooms=" + mushrooms +
                ", olives=" + olives +
                ", extraCheese=" + extraCheese +
                ", crustType='" + crustType + '\'' +
                ", price=$" + getPrice() +
                '}';
    }

    // Static nested Builder class
    public static class PizzaBuilder {
        // Required parameters
        private final String size;

        // Optional parameters
        private boolean cheese = true;
        private boolean pepperoni = false;
        private boolean mushrooms = false;
        private boolean olives = false;
        private boolean extraCheese = false;
        private String crustType = "REGULAR";

        // Constructor with required fields
        public PizzaBuilder(String size) {
            this.size = size;
        }

        // Setter methods
        public PizzaBuilder cheese(boolean cheeseIsNeeded) {
            this.cheese = cheeseIsNeeded;
            return this;
        }

        public PizzaBuilder pepperoni(boolean pepperoniIsNeeded) {
            this.pepperoni = pepperoniIsNeeded;
            return this;
        }

        public PizzaBuilder mushrooms(boolean mushroomsNeeded) {
            this.mushrooms = mushroomsNeeded;
            return this;
        }

        public PizzaBuilder olives(boolean olivesNeeded) {
            this.olives = olivesNeeded;
            return this;
        }

        public PizzaBuilder extraCheese(boolean extraCheeseNeeded) {  // ← ADDED
            this.extraCheese = extraCheeseNeeded;
            return this;
        }

        public PizzaBuilder crustType(String crustType) {
            this.crustType = crustType;
            return this;
        }

        // Build method - creates Pizza object with validation
        public Pizza build() {
            // Validation
            if (size == null || size.isEmpty()) {
                throw new IllegalStateException("Size cannot be null or empty");
            }

            if (!size.equals("SMALL") && !size.equals("MEDIUM") && !size.equals("LARGE")) {
                throw new IllegalArgumentException("Size must be SMALL, MEDIUM, or LARGE");
            }

            return new Pizza(this);
        }
    }
}