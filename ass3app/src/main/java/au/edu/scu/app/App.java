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

import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;


public class App implements RequestHandler<Map<String, Object>, String>
{
    
    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
    DynamoDB ddb = new DynamoDB(client);
    
    public static void main( String[] args )
    {

    }
    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        
        //initialise variables
        // int id = (int) input.get("id");
      String id = (String) input.get("id");
      int idValue = Integer.valueOf(id); //this code will convert id to string
       String message = "";
      
      
      //retrieve single talbe entry
      try {
      Table table = ddb.getTable("Car"); //access to target ddb table Car
      Item item = table.getItem("Id", idValue);
      
    //  GetItemSpec spec = new GetItemSpec()
    //  .withPrimaryKey("Id", id)
    //  .withProjectionExpression("Id, Make, Model, Year, Colour")
    //  .withConsistentRead(true);

      
    //   Item item = table.getItem(spec);
    //   String make = item.getItem("Make");
    //   String model = item.getItem("Model");
    //   int year = item.getInt("Year");
    //   String colour = item.getItem("Colour");
      
      message = item.toString();
      return message;

      }
       catch (Exception exp) {
         
         return message;
      }

       
        
    }
}
