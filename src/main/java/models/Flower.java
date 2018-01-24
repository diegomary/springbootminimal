package models;
import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigInteger;

@Document(collection = "BachFlowers")
public class Flower {      
    @Id private String id;    
    @Field("Name")
    private String name;
    @Field("Description")
    private String description;
    @Field("ImagePath")
    private String ImagePath;
    @Field("FlowerColor")
    private String FlowerColor;
    @Field("Notes")
    private String notes;

    public String getId(){return this.id;}    
    public void setId(String _id) { this.id = _id;}         
    
    public String getName(){return this.name;}    
    public void setName(String _firstName) { this.name = _firstName;}

    public String getDescription(){return this.description;}    
    public void setDescription(String _description){this.description = _description;}

    public String getImagePath(){return this.ImagePath;}    
    public void setImagePath(String _imagePath){this.ImagePath = _imagePath;}
    
    public String getFlowerColor(){return this.FlowerColor;}    
    public void setFlowerColor(String _flowerColor){this.FlowerColor = _flowerColor;}
    
    public String getNotes(){return this.notes;}    
    public void setNotes(String _notes){this.FlowerColor = _notes;} 
    
}









   

   

