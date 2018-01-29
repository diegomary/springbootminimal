package models;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "resumes")
public class Resume implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public Resume() {}

    public Resume(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getId() {return this.id;}    
    public void setId(String _id) {this.id = _id;}

    public String getFirstName(){return this.firstName;}    
    public void setFirstName(String _firstName) { this.firstName = _firstName;}

    public String getLastName(){return this.lastName;}    
    public void setLastName(String _lastName){this.lastName = _lastName;}

    public String getEmail(){return this.email;}    
    public void setEmail(String _email){this.email = _email;}



    @Override
    public String toString() {
        return String.format("User[id=%s, firstName='%s', lastName='%s',email='%s']", id,
                firstName, lastName,email);
    }

}