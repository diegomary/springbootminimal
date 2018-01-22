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


@RestController
public class TestController {

    @RequestMapping("/test")
    public @ResponseBody  
    List<org.bson.Document> test() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://booksadmin:diegomary@ds061371.mongolab.com:61371/diegomary88"));
        MongoDatabase db = mongoClient.getDatabase("diegomary88");
        MongoCollection<org.bson.Document> mc = db.getCollection("BachFlowers"); 
        List<org.bson.Document> all;
        all = mc.find().into(new ArrayList<>());    

        return all; 
    }   

}