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

//@RestController

@Controller
public class HomeController {
private static final String appName = "ThymeleafTour";
     @GetMapping("/")
     public String home(Model model,
                       @RequestParam(value = "name", required = false,
                               defaultValue = "Diego and Mary") String name) {

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