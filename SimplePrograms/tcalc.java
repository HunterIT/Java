import javax.swing.JOptionPane;
import java.lang.Math;
import java.util.Random;

public class tcalc
{
	public static void main(String[] args)
	{
		double tickets = 6000;
		int numPeople = Integer.parseInt(JOptionPane.showInputDialog("How Many People?"));
		int maxTicket = Integer.parseInt(JOptionPane.showInputDialog("How Much is the max prize worth?"));
		int minTicket = Integer.parseInt(JOptionPane.showInputDialog("How much is the min prize worth?"));

		//Create People

		int counter = 0;
		int ticketsSold = 0;

		while (counter < numPeople)
		{
			int gamesPlayed = randInt(0, 15);
			int ticketsWon = 0;

			for (int i = 0; i < gamesPlayed; i++)
			{
				 ticketsWon += randInt(minTicket, maxTicket);
			}

			ticketsSold += ticketsWon;  //Get Max Sold

			System.out.println("Person #" + counter + "...Played #" + gamesPlayed +
			" Games.....Won #" + ticketsWon + " tickets");

			counter ++;

	    }
	
	  System.out.println("Total Tickets Sold = " + ticketsSold); 
	}

	public static int randInt(int min, int max) {

		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;

	}
} 
		
