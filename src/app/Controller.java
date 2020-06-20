//=============================================================================
// PROGRAMMER: Cristian Bencomo
// PANTHER ID: 6044774
//
// CLASS: COP3337
// SECTION: Your class section: RVDC
// SEMESTER: The current semester: Summer 2020
// CLASSTIME: Online
//
// Project: Project 2
// DUE: June 21st 2020
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my 
//                own and that none of it is the work of any other person.
//=============================================================================

package app;

import entities.Item;
import entities.Logger;
import entities.Person;
import payments.Cash;
import payments.SecureCash;
import payments.credit.CreditCard;
import payments.credit.MasterCard;
import payments.credit.MasterRewards;
import reports.Reporter;
import transactions.SecureTransaction;


public class Controller {

   
    public static void main(String[] args) {
        
        System.out.println("//////////////////////////////////////////////");    
        System.out.println("Section 1");       
        System.out.println("//////////////////////////////////////////////");  
       

        Item item1 = new Item("Mitutoyo 513-403-10E", 
                "DIAL TEST INDICATOR, BASIC SET, STANDARD, .008 IN, . 0001 IN GRAD, WHITE DIAL ",
                 139.16);

        Item item2 = new Item("Garmin Forerunner 935",
                "Premium GPS running/triathlon watch with wrist-based heart rate ",
                284.49);

        Item item3 = new Item("CROC Classic Clog",
                "Iconic clog that started a comfort revolution around the world", 
                40.99);

        Item item4 = new Item("Adidas Ultra Boost PB",
                "Offers a plush, yet bouncy ride with an updated upper is built for speed.",
                105.95);

        Item item5 = new Item("Macbook Pro 13",
                "1.4GHz quad-core 8th-generation Intel Core i5 processor", 
                1399.00);



        Person person1 = new Person("Ava", "Davis", "704 Brickell Ave", 
                "Superman", 760);

        Person person2 = new Person("John", "Smith", "340 S.W. 13 Street",
                "myPassword123", 680);

        Person person3 = new Person("Bill", "Johnson", "100 Ocean Dr. S.W. ",
                "Mom12345", 530);

       
                
System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 2");       
System.out.println("//////////////////////////////////////////////");  


       //Ava
       Cash cashtemp = new Cash(person1, 400.00);
       MasterCard mastertemp = new MasterCard(person1, 3500.00);
       
       person1.getWallet().add(cashtemp);
       person1.getWallet().add(mastertemp);
       
       person1.financialReport();
        

       //John
       cashtemp = new Cash(person2, 400.00);
       mastertemp = new MasterCard(person2, 500.00);
       MasterRewards rewardtemp = new MasterRewards(person2, 1500.00);
       
       person2.getWallet().add(cashtemp);
       person2.getWallet().add(mastertemp);
       person2.getWallet().add(rewardtemp);

       person2.financialReport();
       
       
       //Bill
       cashtemp = new SecureCash(person3, 1000.00);
       mastertemp = new MasterCard(person3, 1000.00);
       rewardtemp = new MasterRewards(person3, 1500.00);
       
       person3.getWallet().add(cashtemp);
       person3.getWallet().add(mastertemp);
       person3.getWallet().add(rewardtemp);
       
       person3.financialReport();
       
      
System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 3.0");       
System.out.println("//////////////////////////////////////////////");  


System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 3.2");       
System.out.println("//////////////////////////////////////////////");  

        
        //Calling Info Reports
        ((MasterCard)person1.getWallet().get(1)).infoReport();
        ((MasterCard)person2.getWallet().get(1)).infoReport();
        ((MasterCard)person3.getWallet().get(2)).infoReport(); //specified master rewards by assignment
                       
            

System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 4");       
System.out.println("//////////////////////////////////////////////");  


        //=========================================================
        // people buying stuff
        //=========================================================
        
        System.out.println("\n");
        System.out.println("---------------------------------------------");
        System.out.println(person1.getFirstName() + " " + person1.getLastName() + " buying");
        System.out.println("---------------------------------------------");


        ((MasterCard)person1.getWallet().get(1)).makePurchase(item1);
        ((MasterCard)person1.getWallet().get(1)).makePurchase(item2);
        ((Cash)person1.getWallet().get(0)).makePurchase(item2);
        
        
        ((MasterCard)person1.getWallet().get(1)).makePurchase(item5);

         person1.financialReport();



        System.out.println("\n");
        System.out.println("---------------------------------------------");
        System.out.println(person2.getFirstName() + " " + person2.getLastName() + " buying");
        System.out.println("---------------------------------------------");

        
        ((MasterCard)person2.getWallet().get(1)).makePurchase(item1);
        ((MasterCard)person2.getWallet().get(1)).makePurchase(item2);
        ((MasterCard)person2.getWallet().get(1)).makePurchase(item3);
        ((MasterCard)person2.getWallet().get(1)).makePurchase(item4);

        ((Cash)person2.getWallet().get(0)).makePurchase(item2);

        ((MasterRewards)person2.getWallet().get(2)).makePurchase(item1);
        ((MasterRewards)person2.getWallet().get(2)).makePurchase(item2);
        ((MasterRewards)person2.getWallet().get(2)).makePurchase(item3);
        ((MasterRewards)person2.getWallet().get(2)).makePurchase(item4);
        ((MasterRewards)person2.getWallet().get(2)).makePurchase(item5);


        ((MasterRewards)person2.getWallet().get(2)).makePurchase(item1);
        

        person2.financialReport();
         
        
        
        System.out.println("\n");
        System.out.println("---------------------------------------------");
        System.out.println(person3.getFirstName() + " " + person3.getLastName() + " buying");
        System.out.println("---------------------------------------------");
        

        ((SecureCash)person3.getWallet().get(0)).makePurchase(item1);
        ((SecureCash)person3.getWallet().get(0)).makePurchase(item2);
        ((SecureCash)person3.getWallet().get(0)).makePurchase(item5);

        ((MasterCard)person3.getWallet().get(1)).makePurchase(item4);
  
        ((MasterRewards)person3.getWallet().get(2)).makePurchase(item3);

        person3.financialReport();
     




System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 5");       
System.out.println("//////////////////////////////////////////////");          


        //Class Static Info
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println("Class Statistics");
        System.out.println("---------------------------------------------------");
               
        System.out.println("Number of Person in System:\t\t\t" + Person.getPersonCount());
        System.out.println("Number of all Cash type transactions:\t\t" + Cash.getCashTransactionCount());
        System.out.println("Number of all Credit Card type transactions:\t" + CreditCard.getCreditTransactionCount());
        System.out.println("---------------------------------------------------");
 
 


System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 6");       
System.out.println("//////////////////////////////////////////////");  


        System.out.println("\n\n");
        System.out.println("---------------------------------------------------");
        System.out.println("Logger Data");
        System.out.println("---------------------------------------------------");


        Logger logger = new Logger();
        logger.runReports();
        
       
        


System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 7");       
System.out.println("//////////////////////////////////////////////");    


        // USING Interfaces
        System.out.println("\n\n\n");
        System.out.println("---------------------------------------------------");
        System.out.println("REPORTER INTERFACE");
        System.out.println("---------------------------------------------------");
        

        processReports(person1);
        processReports(logger);
        processReports( ((SecureCash)person3.getWallet().get(0)) );
        processReports( ((MasterCard)person1.getWallet().get(1)) );
    
       

System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 8");       
System.out.println("//////////////////////////////////////////////");          


        System.out.println("\n\n\n");
        System.out.println("---------------------------------------------------");
        System.out.println("SECURE INTERFACE");
        System.out.println("---------------------------------------------------");
        

        processSecureTransaction( ((MasterCard)person1.getWallet().get(1)) );
        processSecureTransaction( ((SecureCash)person3.getWallet().get(0)) );
        

    }// end main()
    
    //----------------------------------------
    // class methods 
    //----------------------------------------  
    
    public static void processReports(Reporter reporter){
        reporter.runReports();
    }
    
    public static void processSecureTransaction(SecureTransaction secureTransaction){
        
        String pin = secureTransaction.generateTransactionSecret();
        
        
        if(secureTransaction instanceof CreditCard){
            String firstName = ((CreditCard)secureTransaction).getCardHolder().getFirstName();
            String lastName = ((CreditCard)secureTransaction).getCardHolder().getLastName();
            
            System.out.println(firstName + " " + lastName + " (MASTER CARD)  secure transaction pin:"  + pin);
            
        }else if(secureTransaction instanceof SecureCash){
            String firstName = ((SecureCash)secureTransaction).getPerson().getFirstName();  
            String lastName = ((SecureCash)secureTransaction).getPerson().getLastName();
            
            System.out.println(firstName + " " + lastName + " (SECURE CASH) secure  transaction pin:"  + pin);
        }//end if-else
           
    }
    
    
    public static void makePurchase(CreditCard creditCard, Item item){
            creditCard.makePurchase(item);  
    }
    
    public static void makePurchase(Cash cash, Item item){
            cash.makePurchase(item);  
    }
    
     public static void makePurchase(Object obj, Item item){
        
            if(obj instanceof CreditCard){
                ((CreditCard)obj).makePurchase(item); 
            }else if (obj instanceof Cash){
                ((Cash)obj).makePurchase(item);
            }//end if-else            
    }

    
}//end class
