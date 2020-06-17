package entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import reports.LoggerReport;
import reports.Reporter;


public class Logger implements Reporter{
    
    //----------------------------------------
    // class varaivles
    //----------------------------------------
    
    private static int logNumber = 1;
    private static ArrayList<String> messages = new ArrayList<>();
    
    
    //----------------------------------------
    // constructor
    //----------------------------------------
    
    // hack here
    public Logger(){
    
    }
    
    //----------------------------------------
    // class methods
    //----------------------------------------
    
    // why did I make this method final
    public static final void output(String sender, String message){
        
        String output =  String.format("[%d]:[%s] -> %s", logNumber, sender, message);
        
        messages.add(output);
        
        System.out.println("");
        System.out.printf(output);
        System.out.println("");
        logNumber++;
    }
    
    public static ArrayList<String> getMessages(){
        return Logger.messages;
    }
    
    //----------------------------------------
    // istance method
    //----------------------------------------
    
    @Override
    // hacked the OO code to make it work
    public void runReports(){
        
        Map<String, Object> map = new LinkedHashMap<>();

        ArrayList<String> header = new ArrayList<>();
        
        header.add("");
        header.add("=======================================");
        header.add("Logger Report");
        header.add("=======================================");
        
        String value = "";
        for(String str: messages){
            value = value + str + "\n";
        }
        map.put("", value);
        

        LoggerReport loggerReport = new LoggerReport(header, map);
        loggerReport.display();
        
    }

    
    
}// end of class
