package reports;

import java.util.ArrayList;
import java.util.Map;

public class PersonReport extends Report{
  
    //----------------------------------------
    // constructor 
    //----------------------------------------  
    
    public PersonReport(ArrayList<String> header, Map<String, Object> reportData) {
        super(header, reportData);
    }

    //----------------------------------------
    // instance method
    //----------------------------------------  
    
    public void display() {
        
        for(String str:header){
            System.out.println(str);
        }
        
        for (Map.Entry<String, Object> entry : reportData.entrySet()) {
            System.out.println(entry.getKey() + ":\t\t" + entry.getValue().toString());
        }
        
        System.out.println("");
        
    }
   
}
