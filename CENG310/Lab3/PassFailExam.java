/************************
 * Name: PassFail.java
 * @author: Kenneth Hunter <kennyhunter16@gmail.com>
 * @since: 2014-03-19
 * @version: 1.0
 **************************/
 
public class PassFailExam extends PassFail
{
   private int numQuestions; //Hold number of questions
   private double eachMarks; //Hold marks of each question
   private int numMissed; //Hold num of questions students missed
   
   public PassFailExam() {
   //Default Contruster
   }
   
   public PassFailExam (int questions, int missed, double minPassing)
   {
      
      super(minPassing); //Calling the superclass constructer
      
      numQuestions = questions;
      numMissed = missed;
      
      eachMarks = (100 / questions);
      double numericMarks = 100 - (numMissed * eachMarks);
      
      setMarks(numericMarks);
     
   }
   
   /**
   * Getter for eachMarks
   *
   *@return eachMarks - Returns marks of each question
   */
   public double getEachMarks() { return eachMarks; }
   
   /**
   * Getter for numMissed
   *
   *@return numMissed - Returns number of questions missed
   */
   public int getNumMissed() { return numMissed; }
   
}

   
   