/**
* Name: PasswordCheck.java
* @author: Kenneth Hunter <kennyhunter16@gmail.com>
* @verison: 1.0
*/
import java.util.Scanner;

public class PasswordCheck
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      
      System.out.print("Enter a String for Password: ");
      String s = sc.nextLine();
      
      /**
      * The requirements for the Password:
      * - Must be 8 charactors in length
      * - Cannot have any speical charactors
      * - Must contain two numbers
      */
      
      if (length(s))
         System.out.println("Password must be at least 8 charactor");
      
      else if (checkLetterDigit(s))
          System.out.println("Password must only be letters and numbers");
          
      else if (checkForDigit(s))
          System.out.println("Password must contain two numbers");
      
      else 
          System.out.println("Alright Password Set!");
     

   }
   
   /**
   * Returns true if the password is 8 in length
   *
   * @return true/false
   */
   
   public static boolean length(String s)
   {
     if (s.length() < 8) return true;
     else return false;
   }
   
   /**
   * Returns true if it contians a speical character
   *
   * @return true/false
   */
   public static boolean checkLetterDigit (String s)
   {
      boolean check = false;
      
      for (int i = 0; i < s.length(); i++){
           if (!Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))) check = true;
          }
      
      return check;
   }
   
    /**
   * Returns true if doesn't contian 2 numbers
   *
   * @return true/false
   */
   public static boolean checkForDigit(String s)
   {
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
          if (Character.isDigit(s.charAt(i))) 
                 count++;
          }
     if (count < 2) return true;
     
     else return false;   
   }
}
