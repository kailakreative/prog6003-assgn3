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

import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;


public class App implements RequestHandler<Map<String, Object>, String>
{
    public static void main( String[] args )
    {

    }
    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        
       int id = (int) input.get("id");
       String message = "";
       
       
       //retrieve Car table entry
       AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build(); 
       DynamoDB ddb = new DynamoDB(client);
       
       try {
           Table table = ddb.getTable("Car");
           Item item = table.getItem("Id", 0);
           
           for (int = 0; i < carIDs.lenght)
           
           //add if-condition for null object = error message
           //if found get id and attributes assigned
           
        //   String make = item.getString("Make");
        //   int year = item.getInt("Year");
        //   message = "Id: " + id + ", Make: " + make + ", Model: " + model + ", Year: " + year + ", Colour: " + color;
        //   return message;
       }
       catch(Exception exp) {
           
       }
       
       return message;
        
    }
}
