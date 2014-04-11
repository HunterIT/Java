import javax.swing.JFileChooser;
import java.io.File;
import java.util.Scanner;
import java.lang.Math;
import java.io.*;
import java.util.ArrayList;
import java.lang.StringBuilder;
import javax.swing.JOptionPane;

public class GuessWordGame
{
	public static void main(String [] args) throws Exception
	{
		 /* Ask the User to import a file */
		JFileChooser fileChooser = new JFileChooser();

		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) //IF Selected File
		{
			File file = fileChooser.getSelectedFile();    //Load selected file
			Scanner filesc = new Scanner(file);

			/* Records the amount of Words in file (from first value) */
			int wordCount = filesc.nextInt(); 

			/* Ranges the amount, for random selection mode */
			int randomNum = 1 + (int)(Math.random()*wordCount);

			System.out.println("Random Number = " + randomNum);

			ArrayList<Integer> hints = new ArrayList<Integer>();

			String output = " "; 
			
			/* Go to correct line for the Word */
			for (int i = 0; i < randomNum; i++)
			{
			 	filesc.nextLine();
			}	

			String hiddenWord = filesc.next();  //Saves Hidden Word
			int hintAmount = filesc.nextInt(); // Saves Anmout of Hints

			/* Add all the hints to ArrayList */
			for (int i = 0; i < hintAmount; i++)
			{
				hints.add(i, filesc.nextInt());
			}

			System.out.println("Hidden Word = " + hiddenWord);
			guessWord(hiddenWord, hints); //GUESS THE WORD

	    } 

	    else
			System.out.println("No File Selected");

	}

	public static int guessWord(String hW, ArrayList<Integer> hint) throws Exception
	{
		StringBuilder guessedWord = new StringBuilder();
		for (int i = 0; i < hW.length(); i++)
			guessedWord.append('*');

		Scanner hintFile = new Scanner (new File("hints.txt")); 

		ArrayList<String> hintDef = new ArrayList<String>();   //Create Array of Hint Definations

		// Ouputs everything into ArrayList
		while (hintFile.hasNext()) 
		{
			hintDef.add(hintFile.nextLine()); 
		} 

		hintFile.close(); //Close up the file, We don't need it anymore

		int hintCount = hint.size();
		int hintUsed = 1;

		boolean loop = true;
		boolean bounsAlive = true;

		int a = 0;

		while (loop) 
		{ 
			boolean nothingFound = true;

			String input = JOptionPane.showInputDialog
				("Guess the Letter of the NHL Team < " + guessedWord + ">");

			char inputChar = input.charAt(0);

			/* Checks if the letter was already used and correct */ 
			if (guessedWord.indexOf(inputChar + "") >= 0)
			{ 
				JOptionPane.showMessageDialog(null, inputChar + " is already being used");
				nothingFound = false;
			} 

			else
		 		for (int i = 0; i < guessedWord.length(); i++)
				{
					if (inputChar == hW.charAt(i)) 
					{
						guessedWord.setCharAt(i,inputChar);
						nothingFound = false;
					}
				}

			if (nothingFound)
			{
				if (hintCount == hintUsed)
				{
					JOptionPane.showMessageDialog(null, "SORRY: You've used all availble hints");

					   if (bounsAlive)
					   {
						 	JOptionPane.showMessageDialog(null, "Bonus Hint: ");
							bounsAlive = false;
						}
				}

				else { 
					String yn = JOptionPane.showInputDialog
							("Sorry: " + inputChar + " is not in the team's name.\n"
							+ "Do you need a hint? You'll get in total " + hintCount
							+ " hints\n" + "Enter 'y' or 'n' And it'll be your #" + hintUsed++); 
					char yesno = yn.charAt(0); 

					String hintMessage = "";

						if (yesno == 'y' || yesno == 'Y') 
						{
							int j = 0;
							for (int i = 0; i < hint.get(a); i++) 
								hintMessage = hintDef.get(j++);
							a++;
							JOptionPane.showMessageDialog(null, hintMessage);

						}
						
						else if (yesno == 'n' || yesno == 'N')
							JOptionPane.showMessageDialog(null, "Message will Not Appear Here");

						else 
							JOptionPane.showMessageDialog(null, "Failed Input");
					} 
		}
	
		}
	return 0;
	}
}
