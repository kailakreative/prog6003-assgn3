package au.edu.scu.app;


//importing necessary packages

//lambda packages
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


//java packages
import java.util.Map;

//ddb packages
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;


public class App implements RequestHandler<Map<String, Object>, String>
{
    //declaring the ddb client
    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
    DynamoDB ddb = new DynamoDB(client); 
    
    public static void main( String[] args )
    {

    }
    
    //handleRequest for Lambda function
    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        
        //initialise variables
      String id = (String) input.get("id");//require an input paramenter from the API
      int idValue = Integer.valueOf(id); //this code will convert string id to integer
      String message = ""; //declare message variable for returns
     
         //retrieve single table entry
         try {
            
         Table table = ddb.getTable("Car"); //access to target ddb table Car
         Item item = table.getItem("Id", idValue);//takes idValue as Id value in the table
         message = item.toString();//assigns value to message variable
          return message; //prints message
         }
      
            catch (Exception exp) { //executes if Id does not exist in table
            message = "The ID does not exist. Try Again.";//assigns value to message
           return message;//prints message
        }
      
     


       
        
    }
}
