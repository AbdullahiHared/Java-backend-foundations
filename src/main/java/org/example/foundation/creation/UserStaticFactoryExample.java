package org.example.foundation.creation;
// this is easier to use as it gives flexibility.
public class UserStaticFactoryExample {
    private String name;
    private double id;
    private UserStaticFactoryExample(String name, double id) {
        this.name = name;
        this.id = id;
    };


    public static UserStaticFactoryExample UserWithName(String name) {
        return new UserStaticFactoryExample(name, 0.0);
    }

    public static UserStaticFactoryExample userWithNameAndId(String name, double userId) {
        return new UserStaticFactoryExample(name, userId);
    }
}