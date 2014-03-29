/**********************
 * Name: ABCD Bank
 * Author: Kenneth Hunter <kennyhunter16@gmail.com>
 * Version: 1.0
 * Course: CENG310
 * Purpose: An Example Bank to learn about Objects and class files
 ***********************/
 import javax.swing.JOptionPane;
 
 public class ABCDBank{
   public static void main(String[] args){
   
      int choice; 
      double input, output;
      
      //Ask for InterestRate, for a static value
      Account.setAnnualInterestRate(
         Double.parseDouble(JOptionPane.showInputDialog("Enter Annual Interest Rate:"))
      );
      
      //Ask for ID & Balance of Joe
      int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Joe's Account ID"));
      double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter Joe's Balance"));
      
      Account accountJoe = new Account(id, balance);  //Calling the Object
      
        // A text box showing all the Information about Joes Account
      	JOptionPane.showMessageDialog(null,
         "Joe's account details" +
         "\nAccount ID: " + accountJoe.getID() +
         "\nAccount Balance: " + accountJoe.getBalance() +
         "\nJoe's Account was created at  " + accountJoe.dateCreated() +
         "\nMonthly Interest Amount: " + accountJoe.getMonthlyInterest(),
         "Joe's Account Information -- ABCD BANK",
         JOptionPane.PLAIN_MESSAGE
         );
         
      //Clearing ID and Balance, incase of error
      id = 0;
      balance = 0;
      
      //Ask for ID & Balance of Don.
      id = Integer.parseInt(JOptionPane.showInputDialog("Enter Don's Account ID"));
      balance = Double.parseDouble(JOptionPane.showInputDialog("Enter Don's Balance"));
      
      Account accountDon = new Account(id, balance); //Calling the Object
      
      //A text box showing all the Information about Don's Account
      	JOptionPane.showMessageDialog(null,
         "Don's account details" +
         "\nAccount ID: " + accountDon.getID() +
         "\nAccount Balance: " + accountDon.getBalance() +
         "\nDon's Account was created at  " + accountDon.dateCreated() +
         "\nMonthly Interest Amount: " + accountDon.getMonthlyInterest(),
         "Don's Account Information -- ABCD BANK",
         JOptionPane.PLAIN_MESSAGE
         );
         
      //Deposit or Withdraw for Joe.
   double tempValue = accountJoe.getBalance(); //Keeps Old Balance backup for Display
   	do {
            choice = Integer.parseInt(JOptionPane.showInputDialog("Choose your choice for Joe's Account (1 - Deposit, 0 - Withdraw)"));
           
            if(choice != 0 && choice != 1)   //if 1 or 0, are not selected
                  JOptionPane.showMessageDialog(null,
                  "Invalid choice.",
                  "ERROR: Invalid Choice",
                  JOptionPane.PLAIN_MESSAGE
                  );
           } while (choice != 0 && choice != 1);
 
     if(choice == 1) {
      //Ask the User Amout to Deposit Money into Joe Accounts
      input = Double.parseDouble(JOptionPane.showInputDialog("Amount to Deposit"));
      accountJoe.deposit(input);          //Deposit the Money
      
      //Display Information about Updated Balance
      JOptionPane.showMessageDialog(
      null,
      "Original Balance: " + tempValue +
      "\nDeposited: $" + input +
      "\nUpdated Balance: " + accountJoe.getBalance(),
      "Deposit Successful",
      JOptionPane.PLAIN_MESSAGE
      );
      }

   else {
         do {
         //Ask the User Amount to  Withdraw Money into Joe Accounts
         input = Double.parseDouble(JOptionPane.showInputDialog("Amount to Withdraw"));
         output = accountJoe.withdraw(input);  //Withdraw Money

         //If output is zero, then doesn't have enough money to withdraw
         if(output != 0) {
            JOptionPane.showMessageDialog(null,
            "Original Balance: " + tempValue +
            "\nWithdrew: $" + output +
            "\nUpdated Balance: " + accountJoe.getBalance(),
            "Successful operation",
            JOptionPane.PLAIN_MESSAGE
            );
         break;
         }
         else {
            JOptionPane.showMessageDialog(null,
            "Insufficient funds.",
            "ERROR: No Funds.",
            JOptionPane.PLAIN_MESSAGE
            );
            }
         } while (output == 0);
      
     
}

 //Deposit or Withdraw for Don
  tempValue = accountDon.getBalance(); //Keeps Old Balance backup for Display
   	do {
            choice = Integer.parseInt(JOptionPane.showInputDialog("Choose your choice for Don's Account (1 - Deposit, 0 - Withdraw)"));
            
            if(choice != 0 && choice != 1)   //if 1 or 0, are not selected
                  JOptionPane.showMessageDialog(null,
                  "Invalid choice.",
                  "ERROR: Invalid Choice",
                  JOptionPane.PLAIN_MESSAGE
                  );
           } while (choice != 0 && choice != 1);
 
     if(choice == 1) {
      //Ask the User Amout to Deposit Money into Don Accounts
      input = Double.parseDouble(JOptionPane.showInputDialog("Amount to Deposit"));
      accountDon.deposit(input);          //Deposit the Money
      
      //Display Information about Updated Balance
      JOptionPane.showMessageDialog(
      null,
      "Original Balance: " + tempValue +
      "\nDeposited: $" + input +
      "\nUpdated Balance: " + accountDon.getBalance(),
      "Deposit Successful",
      JOptionPane.PLAIN_MESSAGE
      );
      }

   else {
         do {
         //Ask the User Amount to  Withdraw Money into Don Accounts
         input = Double.parseDouble(JOptionPane.showInputDialog("Amount to Withdraw"));
         output = accountDon.withdraw(input);  //Withdraw Money

         //If output is zero, then doesn't have enough money to withdraw
         if(output != 0) {
            JOptionPane.showMessageDialog(null,
            "Original Balance: " + tempValue +
            "\nWithdrew: $" + output +
            "\nUpdated Balance: " + accountDon.getBalance(),
            "Withdraw Successful",
            JOptionPane.PLAIN_MESSAGE
            );
         break;
         }
         else {
            JOptionPane.showMessageDialog(null,
            "Insufficient funds.",
            "ERROR: No Funds.",
            JOptionPane.PLAIN_MESSAGE
            );
            }
         } while (output == 0);
     
     
     //Check to see whos Balance is Higher
     
     String temphigh = new String(); 
     if (accountJoe.getBalance() > accountDon.getBalance())
            temphigh = "Joe has the higher bank account";
     else
            temphigh = "Don has the higer bank account";
       
     //Display Results.     
     	JOptionPane.showMessageDialog(null,
      temphigh,
      "Who's got more money!!!",
      JOptionPane.PLAIN_MESSAGE
      );      
}

}
}
