/*******************
 * Name: PassFail.java
 * @author: Kenneth Hunter <kennyhunter16@gmail.com>
 * @since: 2014-03-19
 * @version: 1.0
 ******************/
 public class PassFail extends CalculateGrade
 {
   private double minPassMarks;     //Holds Pass Mark
   
   public PassFail() {
   //Default Contructor
   }
   
   /**
   * Contructor for Min Pass Marks
   *
   *@param minPassMarks - Input Min Pass Mark
   */
   public PassFail(double minPassMarks) {
      this.minPassMarks = minPassMarks;
   }
   
   
   /**
   * Contructor for Min Pass Marks
   *
   *@return P/F - Returns if it's a Pass(P) or Fail(F) value
   */
   public char getGrade() {
      if (super.getGrade() == 'F') return 'F';
      else return 'P';
      }
} 
   