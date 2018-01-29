package models;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.ArrayList;

@Document(collection = "customers")
public class Customer implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> skills = new ArrayList<String>();

    public Customer() {}

    public Customer(String firstName, String lastName, String email,List<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skills = skills;
    }

    public String getId() {return this.id;}    
    public void setId(String _id) {this.id = _id;}

    public String getFirstName(){return this.firstName;}    
    public void setFirstName(String _firstName) { this.firstName = _firstName;}

    public String getLastName(){return this.lastName;}    
    public void setLastName(String _lastName){this.lastName = _lastName;}

    public String getEmail(){return this.email;}    
    public void setEmail(String _email){this.email = _email;}

    public List<String> getSkills(){return this.skills;}    
    public void setSkills(List<String> _skills){this.skills = _skills;}

    @Override
    public String toString() {
        return String.format("Customer[id=%s, firstName='%s', lastName='%s',email='%s']", id,
                firstName, lastName,email);
    }

}