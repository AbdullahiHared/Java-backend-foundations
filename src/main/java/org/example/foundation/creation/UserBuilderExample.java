package org.example.foundation.creation;

public class UserBuilderExample {
    // required parameters
    private final String username;
    private final String email;

    // Option parameters
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;

    // Private constructor - only Builder can create User
    private UserBuilderExample(UserBuilder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
    }

    // Static nested Builder class
    public static class UserBuilder {
        // required parameters
        private final String username;
        private final String email;

        // Option parameters
        private String firstName = "";
        private String lastName = "";
        private int age = 0;
        private String phone = "";

        // Constructor with required parameters
        public UserBuilder(String username, String email) {
            this.username = username;
            this.email = email;
        }

        // Setter methods that return builder itself
        public UserBuilder firsName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        // Build method to create the User object
        public UserBuilderExample build() {
            return new UserBuilderExample(this);
        }

    }

    // Getters
    public String getUserName() {
        return username;
    }

    public String getEmail() {return email;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getAge(){return age;}
    public String getPhone(){return phone;}

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
