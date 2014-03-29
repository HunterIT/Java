/**************************
 * Name: CalculateGrade.java
 * @author: Kenneth Hunter <kennyhunter16@gmail.com>
 * @since: 2014-03-19
 * @version: 1.0
 *********************/
public class CalculateGrade
{
   protected double marks;
   
   public CalculateGrade() {     //Default Contructor 
   }
   
   /**
   * Setter for Marks Value
   *
   *@param marks - Input Grade/Mark
   */
  public void setMarks(double inputmarks){
      marks = inputmarks;
      }
  
  /**
   * Getter for Marks Value
   *
   *@returns marks   - the student mark.
   */
  public double getMarks(){ return marks; }
   
   /**
   * This function matchs a number grade value to a letter value
   *
   *@return Letter Grade Value
   */
   public char getGrade() {
      if (marks >= 90)        return 'A';
      else if (marks >= 80)   return 'B';
      else if (marks >= 70)   return 'C';
      else if (marks >= 60)   return 'D';
      else                    return 'F';
      } 
}
      
