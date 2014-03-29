/**********************
 * Name: Account
 * Author: Kenneth Hunter <kennyhunter16@gmail.com>
 * Version: 1.0
 * Course: CENG310
 * Purpose: For the ABCD Bank to contain constructor and getter
 *          and setters
 ***********************/
 import java.util.Date;
 
 public class Account
 {
	 private int           id;
	 private double        balance;
	 private static double annualInterestRate = 0.0;
	 private Date          dateCreated;
	 
	 /**
	  * Default Constructor
	  */
	  
	 public Account ()
	 { 
		 this(1, 1.0);
	 }
	 
	  /**
	  * Passed Parameters to create an Account
	  * 
	  * @param int - the id of the bank
	  * @param double - the balance of the account
	  */
 
	 public Account (int id, double balance)
	 {
		 this.id = id;
		 this.balance = balance;
		 dateCreated = new Date();
	 }
	 
	 // -- All the Getters -- 
	 /**
	  * Returns the ID value of Account
	  * 
	  * @return int - the id of the Account 
	  */ 
	 public int getID()  { return id; }
	 
	 /**
	  * Returns the balance of Account
	  * 
	  * @return double   - the balance of the account
	  */
	  public double getBalance() { return balance; }
     
     /**
     * Returns the Annual Interest Rate
     *
     * @return double  - the Annual Interest Rate
     */
     public double getAnnualInterestRate() { return annualInterestRate; }
     
     /**
     * Returns the Date
     *
     * @return Date  - Return Date
     */
     public Date dateCreated() { return dateCreated; }
     
     /**
     * Calculate Interest Rate
     *
     * @returns double - returns monthly interest
     */
     public double getMonthlyInterest() { return balance * (annualInterestRate/1200); }
     
     
     // -- All the Setters --
     
     /**
     * Sets the ID
     *
     * @param int - input ID
     */
     public void setID (int input) { id = input; }
     
     /**
     * Set the Balance of the Account
     *
     * @param double - the input balance
     */
     public void setBalance (double input) { balance = input; }
     
     /**
     * Set the Annual InterestRate
     *
     * @param double - Input the interest Rate
     */
     public static void setAnnualInterestRate (double input) { annualInterestRate = input; }
     
     /**
     * Withdraw money from the account, unless there is no money
     *
     * @param double - How much you want withdrawed from the Account
     */
     public double withdraw (double input)
     {
        if (input > balance) { return 0.0; }
        else { 	
              balance -= input;
              return balance;
              }
     }
     
     /**
     * Deposit money to the account
     *
     * @param double - How much you want deposited to the Account
     */
     public void deposit (double input) { balance = balance + input; } 
     
}
