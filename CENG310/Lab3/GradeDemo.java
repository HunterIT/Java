import javax.swing.*;

public class GradeDemo
{
   public static void main(String[] args)
   {
     int questions = Integer.parseInt(JOptionPane.showInputDialog("How Many Questions are on the Pass/Fail Exam?"));
     double passScore = Double.parseDouble(JOptionPane.showInputDialog("What is the minimum pass score in Pass/Fail Exam"));
     int joeMissedPF = Integer.parseInt(JOptionPane.showInputDialog("How many questions did Joe miss?"));
     
     PassFailExam passFailJoe = new PassFailExam(questions,joeMissedPF,passScore);
   
     JOptionPane.showMessageDialog(null,
         "Each Question Counts: " + passFailJoe.getEachMarks() + " points" +
         "\nJoe's Pass/Fail Exam Score: " + passFailJoe.getMarks() + 
         "\nJoe's Pass/Fail Exam Score: " + passFailJoe.getGrade(),
         "Joe's Pass/Fail Exam", 
         JOptionPane.INFORMATION_MESSAGE);
         
      int donMissedPF = Integer.parseInt(JOptionPane.showInputDialog("How many questions did Don miss?"));
      
      PassFailExam passFailDon = new PassFailExam(questions,donMissedPF,passScore);
      
        JOptionPane.showMessageDialog(null,
         "Each Question Counts: " + passFailDon.getEachMarks() + " points" +
         "\nDon's Pass/Fail Exam Score: " + passFailDon.getMarks() + 
         "\nDon's Pass/Fail Exam Score: " + passFailDon.getGrade(),
         "Don's Pass/Fail Exam", 
         JOptionPane.INFORMATION_MESSAGE);
         
         JOptionPane.showMessageDialog(null,
         "End of operations for Pass/Fail Exam",
         "End of Operations", 
         JOptionPane.INFORMATION_MESSAGE);
         
         int examQuestions = Integer.parseInt(JOptionPane.showInputDialog("How many questions on Final Exam"));
         int joeMissedExam = Integer.parseInt(JOptionPane.showInputDialog("How many questions did Joe miss on the Final Exam"));
         
         FinalExam finalJoe = new FinalExam (examQuestions, joeMissedExam);
         
         JOptionPane.showMessageDialog(null,
         "Each Question Counts: " + finalJoe.getEachMarks() + " points" + 
         "\nJoe's Final Exam Score: " + finalJoe.getMarks() + 
         "\nJoe's Final Exam Score: " + finalJoe.getGrade(),
         "Joe's Final Exam", 
         JOptionPane.INFORMATION_MESSAGE);
         
         
         int donMissedExam = Integer.parseInt(JOptionPane.showInputDialog("How many questions did Don miss on the Final Exam"));
         
         FinalExam finalDon = new FinalExam (examQuestions, donMissedExam);
         
         JOptionPane.showMessageDialog(null,
         "Each Question Counts: " + finalDon.getEachMarks() +  " points" +
         "\nDon's Final Exam Score: " + finalDon.getMarks() + 
         "\nDon's Final Exam Score: " + finalDon.getGrade(),
         "Don's Final Exam", 
         JOptionPane.INFORMATION_MESSAGE);
         
         JOptionPane.showMessageDialog(null,
         "End of operations for Final Exam",
         "End of Operations", 
         JOptionPane.INFORMATION_MESSAGE);
         
         if (finalJoe.isEqual(finalDon))
               JOptionPane.showMessageDialog(null,
                "Joe's Final Exam marks(" + finalJoe.getMarks() + ") are equal to Don's(" + finalDon.getMarks() + ")",
                "Final Result", 
               JOptionPane.INFORMATION_MESSAGE);
               
         else if (finalJoe.isGreater(finalDon))
              JOptionPane.showMessageDialog(null,
                "Don's Final Exam marks(" + finalDon.getMarks() + ") are higher then Joe's(" + finalJoe.getMarks() + ")",
                "Final Result", 
               JOptionPane.INFORMATION_MESSAGE);
               
         else if(finalJoe.isLess(finalDon))
            JOptionPane.showMessageDialog(null,
                "Joe's Final Exam marks(" + finalJoe.getMarks() + ") are higher then Don's(" + finalDon.getMarks() + ")",
                "Final Result", 
               JOptionPane.INFORMATION_MESSAGE);
         
         

    }
}