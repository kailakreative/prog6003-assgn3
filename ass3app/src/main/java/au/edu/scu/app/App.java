package au.edu.scu.app;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;

import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;



public class App implements RequestHandler<Map<String, Object>, String>
{
    public static void main( String[] args )
    {

    }
    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        
      int id = (String) input.get("id");
       String message = "";
       
       
      //retrieve Car table entry
      AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build(); 
      DynamoDB ddb = new DynamoDB(client);
       
      try {
          result = ddb.getTable("Car").getItem("Id", id);
          
          if(result = null) {
           message = "ID does not exist. Try Again.";
           return message;
            
              
          }
          else {

              
            int id = item.getInt(String "Id");
            String make = item.getJSON(String "Make");
            String model = item.getJSON(String "Model");
            int year = item.getString("Year");
            String colour = item.getString("Colour");
            
            message = "Id: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + year + ", Colour: " + color;
            return message;

          }

           
           

      }
      catch(Exception exp) {
           
      }
       
        
    }
}
