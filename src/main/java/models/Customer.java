package models;

import org.springframework.data.annotation.Id;
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public Customer() {}

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s',email='%s']", id,
                firstName, lastName,email);
    }

}