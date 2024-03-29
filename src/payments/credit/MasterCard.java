package payments.credit;
import entities.Item;
import entities.Logger;
import entities.Person;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import reports.CreditCardReport;
import reports.Reporter;
import transactions.SecureTransaction;


public class MasterCard  extends CreditCard implements Reporter, SecureTransaction{

    //----------------------------------------
    // class variables
    //----------------------------------------  
    private static ArrayList<String> issuedNumbers = new ArrayList<>(); 
    
    //----------------------------------------
    // instance variables
    //----------------------------------------  
    private double interestRate;
    protected String cardNumber; 
    protected double totalFees;
    
    protected ArrayList<Item> purchases;
    protected ArrayList<Date> transactionTime;
    
    
    //----------------------------------------
    // constructor 
    //----------------------------------------  
    
    public MasterCard(Person cardHolder, double creditLimit) {
        
        super(cardHolder, creditLimit, 0);
        
        type = "MasterCard";
        totalFees = 0;
        

System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 2.1");       
System.out.println("//////////////////////////////////////////////");  

        
        if(cardHolder.getCreditScore() >= 740){
            interestRate = 10.99;
        }else if (cardHolder.getCreditScore() >= 670){
            interestRate = 12.50;
        }else{
            interestRate = 14.99;
        }
        
       generateCardNumber();
        
        purchases = new ArrayList<Item>();
        transactionTime = new ArrayList<Date>();
    
    }
    
    //----------------------------------------
    // instance method 
    //----------------------------------------  
    
    
    private void generateCardNumber(){
        
        Random ranGen = new Random();
        boolean hasBeenIssued = false;
        
        cardNumber = "";
        
System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 3.1");       
System.out.println("//////////////////////////////////////////////");  
      

        while (!hasBeenIssued) { //While card has not been issued

            for (int i=1; i<=19; i++) { //Desired lenght of the card number string including spaces
               
                if (i%5 == 0) {
                    cardNumber += " "; //Add spaces
                }

                else {
                    cardNumber += ranGen.nextInt(10); //add random numbers
                }

            }

            if (!issuedNumbers.contains(cardNumber)) { //if card number has not been issued
                hasBeenIssued = true; //Issue the card
                issuedNumbers.add(cardNumber);
            }
        }
    }
    
    protected  void fees(){
        
        double fee =0;
       
        if(purchases.size() > 0 && purchases.size()%3 == 0){
            fee = balance * interestRate/500;
            totalFees +=fee;
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            
            String sender = "MC-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + String.format("  $%-5.2f fee charged", fee);
            Logger.output(sender, message);
            
        }//end if
       
        
    }
    
    public void makePurchase(Item item){
        
        if(item.getPrice() <= (creditLimit - balance)){
            
            Date date = new Date();
            
            balance += item.getPrice();
            purchases.add(item);
            transactionTime.add(date);
            
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + "  Charged " + item.getName() + " for $" + item.getPrice();
            
            Logger.output(sender, message);
            
            fees();
            
            //CreditCard.setCreditTransactionCount(CreditCard.getCreditTransactionCount()+ 1);
            //I implemented a different personalized method
            super.addToTransactionCount();
        }
        else{
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + " Charge declined due to credit limits";
            Logger.output(sender, message);
        }//end if-else

        
    }
    
    
        public void makePurchase(Item item, String pin){
        
        if(item.getPrice() <= (creditLimit - balance)){
            
            Date date = new Date();
            
            balance += item.getPrice();
            purchases.add(item);
            transactionTime.add(date);
            
            
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC:SECURE-" + cardHolder.getLastName()+ "-" + pin;;
            String message = "<" + dateStr + ">" + "  Charged " + item.getName() + " for $" + item.getPrice();
            
            Logger.output(sender, message);
            
            fees();
            
        }else{
            String pattern = "MM-dd-YYYY|HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String dateStr = simpleDateFormat.format(new Date());
            
            String sender = "MC:SECURE-" + cardHolder.getLastName();
            String message = "<" + dateStr + ">" + " Charge declined due to credit limits";
            Logger.output(sender, message);
        }//end if-else
    }
    

    public void infoReport(){
        
          Map<String, Object> map = new LinkedHashMap<>();
        
       
        
        ArrayList<String> header = new ArrayList<>();
        
        header.add("");
        header.add("=======================================");
        header.add(type + " Info Report");
        header.add("=======================================");

        
        map.put("Card Holder", cardHolder.getFirstName() + " " + cardHolder.getLastName());
        map.put("Number", "\t"+ cardNumber);
        map.put("Interest Rate", String.format("%-4.2f%%",interestRate));
        map.put("Credit Limit", String.format("%-10.2f", creditLimit));
        map.put("Balance", String.format("%-10.2f",  balance));
        map.put("Remaining Credit", String.format("%-10.2f", (creditLimit - balance)) );
        map.put("Fees", String.format("\t%-10.2f", totalFees ));
        map.put("Transaction Count", transactionTime.size());
        
     
       CreditCardReport creditCardReport = new CreditCardReport(header, map);
       creditCardReport.display();
        
        
    }

    public double getInterestRate() {
        return interestRate;
    }
    
    
    
    //==============================================
    // reporter interface methods
    //==============================================
    public void runReports(){
        infoReport();
    }
    
    // ------------------------------------------------------
    // SecureTransaction Interface
    // ------------------------------------------------------


    public void secureTransaction(Item item) {
         String pin = generateTransactionSecret();
         makePurchase(item, pin);
    }
    
    
        public String  generateTransactionSecret(){
            
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 10");       
System.out.println("//////////////////////////////////////////////");  

        String pin = "";
         
        char cardNumberArray [] = cardNumber.toCharArray();
        for (int i=0; i<=cardNumberArray.length; i++) {

            if (i%5 == 0) {
                pin += cardNumberArray[i];
            }
        }
       
        return pin;
     }
    
}//end class
