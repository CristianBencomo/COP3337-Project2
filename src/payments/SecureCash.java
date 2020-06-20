package payments;

import entities.Item;
import entities.Logger;
import entities.Person;
import java.text.SimpleDateFormat;
import java.util.Date;
import reports.Reporter;
import transactions.SecureTransaction;

public class SecureCash extends Cash implements Reporter, SecureTransaction{

    //----------------------------------------
    // class variables
    //----------------------------------------    
    private static final String[] letterIndex = { " ", "a", "b", "c", "d", "e", "f", "g", "h", 
                                         "i", "j", "k", "l", "m", "n", "o", "p", "q", 
                                         "r", "s", "t", "u", "v", "w", "x", "y", "z" };
    
    // ------------------------------------------------------
    // Constructor
    // ------------------------------------------------------
    public SecureCash(Person person, double amount) {
        super(person, amount);
    }
    
    // ------------------------------------------------------
    // instance method
    // ------------------------------------------------------
    public void makePurchase(Item item, String pin){
        

        if(item.getPrice() <= super.getAmount()){
            substractCash(item.getPrice());
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "SECURECASH-" + super.getPerson().getLastName()+ "-" + pin;
            String message = "<" + dateStr + ">" + "  Purchased " + item.getName() + " for $" + item.getPrice();
            
            Logger.output(sender, message);
            
            Cash.setCashTransactionCount(Cash.getCashTransactionCount()+1);
            
        }else{
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "SECURECASH-" + super.getPerson().getLastName() + "-" + pin;
            String message = "<" + dateStr + ">" + "  Do not enough cash to buy " + item.getName() + " for $" + item.getPrice();
            Logger.output(sender, message);
        }
        
    }
    
    
    
    // ======================================================
    // Interface Methods
    // ======================================================
    
    // ------------------------------------------------------
    // Reporter Interface
    // ------------------------------------------------------
    
     public void runReports(){
         
     }
     
     
    // ------------------------------------------------------
    // SecureTransaction Interface
    // ------------------------------------------------------
    public String  generateTransactionSecret(){
        
       
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 9");       
System.out.println("//////////////////////////////////////////////");  
        
         String pin = "";
         
         String characters = getPerson().getLastName().substring(0,4);
         String character;
         int pinDigit; 
         

         for (int i=1; i<=characters.length(); i++) {
            
            character = characters.substring(i-1, i);

            for (int j=0; j<letterIndex.length; j++) {

                if ( character.equalsIgnoreCase(letterIndex[j]) ) {
                    pinDigit = j;
                    pinDigit = pinDigit % 10;
                    pin += pinDigit;
                    break;
                }
            }    
        }
        
        return pin;
     }
    
    public void secureTransaction(Item item){
        String pin = generateTransactionSecret();
        makePurchase(item, pin);
    }
    

}
