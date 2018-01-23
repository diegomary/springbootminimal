package controllers;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.*;
import org.springframework.stereotype.Controller;
import models.Customer;
import repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
//@RestController
@Controller
public class HomeController {
@Autowired
private CustomerRepository repository;
private static final String appName = "ThymeleafTour";
     @GetMapping("/")
     public String home(Model model,@RequestParam(value = "name", required = false,
                        defaultValue = "Diego and Mary") String name) {
        model.addAttribute("name", name);
        model.addAttribute("title", appName);
        return "home";
    }

 @GetMapping("/test")
     public String test(Model model,
                       @RequestParam(value = "name", required = false,
                               defaultValue = "Diego and Mary") String name) {       
        this.repository.deleteAll();
        this.repository.save(new Customer("Alice", "Smith","al@dm.com"));
        this.repository.save(new Customer("Bob", "Smith","bb@al.com"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : this.repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(this.repository.findByFirstName("Alice"));

        // fetch an individual customer searching by email
        System.out.println("Customer found with findByEmail('bb@al.com'):");
        System.out.println("--------------------------------");
        System.out.println(this.repository.findByEmail("bb@al.com"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : this.repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
        model.addAttribute("name", name);
        model.addAttribute("title", appName);
        return "home";
    }


    @RequestMapping("/api/flowers")
    public @ResponseBody  
    List<org.bson.Document> home() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://booksadmin:diegomary@ds061371.mongolab.com:61371/diegomary88"));
        MongoDatabase db = mongoClient.getDatabase("diegomary88");
        MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers"); 
        List<org.bson.Document> all;
        all = mc.find().into(new ArrayList<>());    

        return all; 
    }   

}