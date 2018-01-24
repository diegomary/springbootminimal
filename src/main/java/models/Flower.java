package models;
import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigInteger;

@Document(collection = "BachFlowers")
public class Flower {      
      
    @Id private String Id; 
    
    @Field("Name")
    private String Name;
    @Field("Description")
    private String Description;
    @Field("ImagePath")
    private String ImagePath;
    @Field("FlowerColor")
    private String FlowerColor;

    public String getId(){return this.Id;}    
    public void setId(String _id) { this.Id = _id;}         
    
    public String getName(){return this.Name;}    
    public void setName(String _firstName) { this.Name = _firstName;}

    public String getDescription(){return this.Description;}    
    public void setDescription(String _description){this.Description = _description;}

    public String getImagePath(){return this.ImagePath;}    
    public void setImagePath(String _imagePath){this.ImagePath = _imagePath;}
    
    public String getFlowerColor(){return this.FlowerColor;}    
    public void setFlowerColor(String _flowerColor){this.FlowerColor = _flowerColor;}  
    
}









   

   

