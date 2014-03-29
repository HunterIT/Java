public class FinalExam extends CalculateGrade implements GradeOperations
{
   private int numQuestions;  //Hold # of questions in the exam
   private double eachMarks;  //Hold marks for each question
   private int numMissed;     //Hold # of students missed
   
   public FinalExam() {
   // Default Contructor
   }
   
   public FinalExam (int questions, int missed)
   {
      eachMarks = 100 / questions;
      double NumericMarks = 100 - (missed * eachMarks);
      adjustMarks();
      setMarks(NumericMarks);
   }
   
   /**
   * This is a adjust marks method. This method is used to adjust the marks so its
   * a rounded number
   */
   private void adjustMarks()
   {
      double marks = getMarks();
      double marksCALC = Math.floor(marks);
      if((marks - marksCALC) < 0.5) 
           setMarks(marks);
      else 
         setMarks(Math.ceil(marks));
    }
    
   /**
   * Getter for eachMarks
   *
   *@return eachMarks  - The mark value for each question
   */
    public double getEachMarks(){ return eachMarks; }
    
   /**
   * Getter for NumMissed
   *
   *@return numMissed  - the number of questions missed by student
   */
    public double getNumMissed(){ return numMissed; }
    
   /**
   * Returns if mark is Equal (true/false)
   *
   *@return true/false
   */
    public boolean isEqual(CalculateGrade g)
    {
        return (g.getMarks() == this.getMarks()) ? true : false;
    }
    
    /**
   * Returns if mark is Greater (true/false)
   *
   *@return true/false
   */
    public boolean isGreater(CalculateGrade g)
    {
        return (g.getMarks() > this.getMarks()) ? true : false;
    }
    
   /**
   * Returns if mark isLess (true/false)
   *
   *@return true/false
   */
     public boolean isLess(CalculateGrade g)
    {
        return (g.getMarks() < this.getMarks()) ? true : false;
    }
}