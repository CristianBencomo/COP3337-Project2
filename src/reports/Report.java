package reports;

import java.util.ArrayList;
import java.util.Map;


public abstract class Report {
 
    //----------------------------------------
    // instance variables 
    //----------------------------------------  

    ArrayList<String> header;
    Map<String, Object> reportData;

    //----------------------------------------
    // constructor 
    //----------------------------------------  
    
    public Report(ArrayList<String> header, Map<String, Object> reportData) {
        this.header = header;
        this.reportData = reportData;
    }
    
    
    //----------------------------------------
    // instance method 
    //----------------------------------------  
    
    public abstract void display();
    
}//end class
