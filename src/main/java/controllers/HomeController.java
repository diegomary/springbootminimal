package controllers;
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
import models.Flower;
import repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import repositories.FlowerRepository;
//@RestController
@Controller
public class HomeController {
@Autowired
private CustomerRepository repository;
@Autowired
private FlowerRepository flowerRepository;


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
        
        List<String> AAskills = new ArrayList<String>();
        AAskills.add("Angular 5");
        AAskills.add("React 16");
        AAskills.add("Mean stack");
        Customer AA = new Customer("Alice", "Smith","al@dm.com",AAskills);
        Customer BB = new Customer("Bob", "Smith","bb@al.com",AAskills);
        this.repository.save(AA);
        this.repository.save(BB);
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : this.repository.findAll()) {
            System.out.println(customer);
        }        
        model.addAttribute("name", name + ".............");
        model.addAttribute("title", appName);
        return "home";
    }
     
     @RequestMapping("/api/test")
        public @ResponseBody  
        List<Customer> firstTest() {            
        return this.repository.findAll();
        }        
        
        @RequestMapping("/api/single")
        public @ResponseBody  
        Flower firstTest1() {     
        return this.flowerRepository.findByName("Pine"); 
    }    
        
        @RequestMapping("/api/all")
        public @ResponseBody  
        List<Flower> firstTest2() { 
        List<Flower> result = this.flowerRepository.findAll(new Sort(Sort.Direction.DESC,"Name")); // Sort z -> a by name      
        result.forEach(item->{
            item.setImagePath(item.getImagePath().replaceAll("http://dmm888.com/Images/Flowers/",
            "https://nodehelperstatic-statichelper.7e14.starter-us-west-2.openshiftapps.com/Flowers/"));            
        });
        return result;
    } 
        
        @RequestMapping("/api/one")
        public @ResponseBody  
        Flower firstTest3() { 
        Flower result = this.flowerRepository.findOne("59209a15156ba626f4b2d3b2");
        return result;
    } 
        
      @RequestMapping("/api/nullnotes")
        public @ResponseBody  
        List<Flower> firstTest4() { 
        return  this.flowerRepository.findByNotesIsNullQuery();        
    } 
        
        @RequestMapping("/api/notnullnotes")
        public @ResponseBody  
        List<Flower> firstTest5() { 
        return  this.flowerRepository.findByNotesIsNotNullQuery();        
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