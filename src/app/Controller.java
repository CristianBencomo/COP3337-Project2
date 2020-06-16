//=============================================================================
// PROGRAMMER: Cristian Bencomo
// PANTHER ID: 6044774
//
// CLASS: COP3337
// SECTION: Your class section: RVDC
// SEMESTER: The current semester: Summer 2020
// CLASSTIME: Online
//
// Project: Put what this project is: Project 2
// DUE: June 21st 2020
//
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my 
//                own and that none of it is the work of any other person.
//=============================================================================

package app;

import entities.Item;
import entities.Logger;
import entities.Person;
import java.util.ArrayList;
import java.util.Random;
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

/*
System.out.println("");
System.out.println("//////////////////////////////////////////////");    
System.out.println("Section 3.2");       
System.out.println("//////////////////////////////////////////////");  
*/
        
        //Calling Info Reports
        ((MasterCard)person1.getWallet().get(1)).infoReport();
        ((MasterCard)person2.getWallet().get(1)).infoReport();
        ((MasterCard)person3.getWallet().get(1)).infoReport();
                       
            
/*
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
        // buying items
        // Ava is buying stuff
        // use the makePurchase method for the following
        // Use Ava's master card to buy item1
        // Use Ava's master card to buy item2
        // Use Ava's cash to buy item2
        
       // YOUR CODE HERE
  
        
       
        // look at this difference here
        // finish the code below for Ava to buy item5 using her master card
        // MAKE USE YOU GOT THE RIGHT CARD I WILL CHECK THIS
        // COMPLETED CODE BELOW
        
        ((MasterCard)person1
        
         // run the person financial report on Ava
         // YOUR CODE HERE
         
  
       



        System.out.println("\n");
        System.out.println("---------------------------------------------");
        System.out.println(person2.getFirstName() + " " + person2.getLastName() + " buying");
        System.out.println("---------------------------------------------");
       
        // buying items
        // John is buying stuff
        // use the makePurchase method for the following
        // Use John's master card to buy item1
        // Use John's master card to buy item2
        // Use John's master card to buy item3
        // Use John's master card to buy item4


        // YOUR CODE HERE
        
        // Use John's cash to buy item2
        // YOUR CODE HERE
        
        // Use John's master rewards to buy item1
        // Use John's master rewards to buy item2
        // Use John's master rewards to buy item3
        // Use John's master rewards to buy item4
        // Use John's master rewards to buy item5
        // YOUR CODE HERE

        
        // look at this difference here
        // finish the code below for John to buy item1 using her master rewards
        // MAKE USE YOU GOT THE RIGHT CARD I WILL CHECK THIS
        // COMPLETED CODE BELOW

        ((MasterRewards)person2
        
         // run the person financial report on John
         // YOUR CODE HERE
         
        
        
        
        System.out.println("\n");
        System.out.println("---------------------------------------------");
        System.out.println(person3.getFirstName() + " " + person3.getLastName() + " buying");
        System.out.println("---------------------------------------------");
        
         // buying items
        // Bill is buying stuff
        // use the makePurchase method for the following
        // Use Bill's secure cash to buy item1
        // Use Bill's secure cash to buy item2
        // Use Bill's secure cash to buy item5
        // YOUR CODE HERE
        
        // Use Bill's master card to buy item4
        // YOUR CODE HERE


        // Use Bill's master rewards to buy item3
        // YOUR CODE HERE        
        
       

        // run the person financial report on Bill
        // YOUR CODE HERE
     
*/


/*
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 5");       
System.out.println("//////////////////////////////////////////////");          


        //Class Static Info
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println("Class Statics");
        System.out.println("---------------------------------------------------");
        
        // complete the system.out.println code to get the right output
        // DO NOT CHANGE THE ACCESS MODIFIER OF THE VARAIBLE IN THE CLASS
        // IF YOU DO THIS YOU WILL GET POINTS TAKEN OFF
        // hint: you may need to add method to the some classes... 
        //       you need figure out which classes. Also you may need to add some 
        //       code to some contsructors
        // COMPLETE CODE BELOW 
               
        System.out.println("Number of Person in System:\t\t\t" +
       System.out.println("Number of all Cash type transactions:\t\t" + 
        System.out.println("Number of all Credit Card type transactions:\t" + 
        System.out.println("---------------------------------------------------");
 */
 

/*
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 6");       
System.out.println("//////////////////////////////////////////////");  


        System.out.println("\n\n");
        System.out.println("---------------------------------------------------");
        System.out.println("Logger Data");
        System.out.println("---------------------------------------------------");
        
        // I wish to ssee all the messages store in the logger 
        // write the code to do this
        // HINT: create an Logger  instance and use it
        // YOUR CODE HERE


        System.out.println("---------------------------------------------------");
*/       


/*
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 7");       
System.out.println("//////////////////////////////////////////////");    


        // USING Interfaces
        System.out.println("\n\n\n");
        System.out.println("---------------------------------------------------");
        System.out.println("REPORTER INTERFACE");
        System.out.println("---------------------------------------------------");
        
        // Here you are working with interfaces.... 
        // PAY ATTENTION TO TYPES OF AN OBJECT
        // ask yourself the question what are all types the object you are
        // working with can be
        
        
        // processReport is in this class
        // run the process report with Ava (person1)
        // run the process report with the logger object
        // run the process report with Bill's secure cash object
        // run the process report with Ava's master card object
        
        // YOU WILL NEED TO ADD CODE THE NEED CLASSES IN THIS STEP TO MAKE IT WORK
        // YOU NEED FIGURE OUT WHICH CLASSES 
        // Hint: look at the UML Diagrams
        // YOUR CODE HERE
    
*/       


/*
System.out.println("");
System.out.println("//////////////////////////////////////////////");     
System.out.println("Section 8");       
System.out.println("//////////////////////////////////////////////");          


        System.out.println("\n\n\n");
        System.out.println("---------------------------------------------------");
        System.out.println("SECURE INTERFACE");
        System.out.println("---------------------------------------------------");
        
        // Here you are working with interfaces.... 
        // PAY ATTENTION TO TYPES OF AN OBJECT
        // ask yourself the question what are all types the object you are
        // working with can be
        
        // processReport is in this class
       
        // run the process report with Ava's master card object
        // run the process report with BILL's  secure cash object
        
        // WHY DO THESE NOT WORK
        // processSecureTransaction on the person1 object
        // processSecureTransaction no the logger object
       
        // why does this work ----> does it implements SecureTransactions
        // processSecureTransaction on the mcReward3 object
        
        // YOU WILL NEED TO ADD CODE THE NEED CLASSES IN THIS STEP TO MAKE IT WORK
        // YOU NEED FIGURE OUT WHICH CLASSES 
        // YOUR CODE HERE 
        
   
*/

    }// end main()
    
    //----------------------------------------
    // class methods 
    //----------------------------------------  
    
    public static void processReports(Reporter reporter){
        
        // how is this working
        // which object type is excuting this
        // which code is running
        // important you will be tested on this understanding
        reporter.runReports();
           
    }
    
    public static void processSecureTransaction(SecureTransaction secureTransaction){
        
        // how is this working
        // which object type is excuting this
        // which code is running
        // important you will be tested on this understanding
        
        //
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
        
            // how is this working
            // which object type is excuting this
            // which code is running
            // important you will be tested on this understanding
            creditCard.makePurchase(item);  
    }
    
    public static void makePurchase(Cash cash, Item item){
        
            // how is this working
            // which object type is excuting this
            // which code is running
            // important you will be tested on this understanding
            cash.makePurchase(item);  
    }
    
     public static void makePurchase(Object obj, Item item){
        
            // how is this working
            // which object type is excuting this
            // which code is running
            // important you will be tested on this understanding
            if(obj instanceof CreditCard){
                ((CreditCard)obj).makePurchase(item); 
            }else if (obj instanceof Cash){
                ((Cash)obj).makePurchase(item);
            }//end if-else            
    }

    
}//end class
