package au.edu.scu.app;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Map;


public class App implements RequestHandler<Map<String, Object>, String>
{
    public static void main( String[] args )
    {

    }
    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        
       int id = (int) input.get("id");
       String message = "";
       
       return message;
        
    }
}
