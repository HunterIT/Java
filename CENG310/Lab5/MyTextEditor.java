/**
* Name: MyTextEditor.java
* Author: Kenneth Hunter
* Date: April 26th, 2014
* Course: CENG 310
* Version: 1.0
* Purpose: To create a text editor in Java
*/
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class MyTextEditor extends JFrame implements WindowListener
{
   private JMenuBar menuBar;
   private JMenu fileMenu, editMenu, aboutMenu;
   private JMenuItem aboutItem, newItem, openItem, saveItem, saveAsItem, exitItem,
   				editFontMenu, editStyleMenu;
   private JRadioButtonMenuItem monoItem, serifItem, sansSerifItem;
   private JCheckBoxMenuItem italicItem, boldItem;
   private String filename;     
   private JTextArea editorText;

   /**
   * Creates the Text Editor
   */

   public MyTextEditor()
   {
      // Creating the Text Area
      editorText = new JTextArea(10,30);
      editorText.setLineWrap(true);
      editorText.setWrapStyleWord(true);

      // Create a scroll pane for the Frame
      JScrollPane scrollPane = new JScrollPane(editorText);
      add(scrollPane);

      // Build the menu bar
      buildMenuBar();

      // Set the title.
      setTitle("My Text Editor");

      // Close the application when the close button is clicked
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

      // Pack and display the window
      pack();
      setVisible(true);
      
      // Add window listener
      addWindowListener(this);
   }

   /**
   * This method creates the Menu Bar of the window
   */

   private void buildMenuBar()
   {
      // Build the File, Edit & About Menu
      buildFileMenu();
      buildEditMenu();
      buildAboutMenu();

      // Create the menu bar
      menuBar = new JMenuBar();

      // Adding all of the Menus to the MenuBar
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(aboutMenu);

      // Set the MenuBar
      setJMenuBar(menuBar);
   }

	/**
	* This method creats the FileMenu on the main bar
	*/

   private void buildFileMenu()
   {
      // "New" Menu Item, Set KeyEvent 'N'
      newItem = new JMenuItem("New");
      newItem.setMnemonic(KeyEvent.VK_N);
      newItem.addActionListener(new NewListener());

      // "Open" Menu Item, Set KeyEvent 'O'
      openItem = new JMenuItem("Open");
      openItem.setMnemonic(KeyEvent.VK_O);
      openItem.addActionListener(new OpenListener());

      // "Save" Menu Item, Set KeyEvent 'S'
      saveItem = new JMenuItem("Save");
      saveItem.setMnemonic(KeyEvent.VK_S);
      saveItem.addActionListener(new SaveListener());

      // "Save As" Menu Item, Set KeyEvent 'A'
      saveAsItem = new JMenuItem("Save As");
      saveAsItem.setMnemonic(KeyEvent.VK_A);
      saveAsItem.addActionListener(new SaveListener());

      // "Exit" Menu Item, Set KeyEvent 'X'
      exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic(KeyEvent.VK_X);
      exitItem.addActionListener(new ExitListener());

      // "File" Menu Bar, Set KeyEvent 'F'
      fileMenu = new JMenu("File");
      fileMenu.setMnemonic(KeyEvent.VK_F);

      //Add Everything in "File" to the menu
      fileMenu.add(newItem);
      fileMenu.add(openItem);
      fileMenu.addSeparator();// Sneek in a Separator
      fileMenu.add(saveItem);
      fileMenu.add(saveAsItem);
      fileMenu.addSeparator();// Sneek in a Separator
      fileMenu.add(exitItem);
   }

   /**
   * This method creats the Edit Menu for the main menu bar
   */

   private void buildEditMenu()
   {
	 // "Edit" Menu Option, Set KeyEvent 'E'
     editMenu = new JMenu("Edit");
	 editMenu.setMnemonic(KeyEvent.VK_E);

     //Create the Font Menu
	 buildEditFontMenu();

	 //Create the Style Menu
	 buildEditStyleMenu();

	 //Add Everything in "Edit" Option
	 editMenu.add(editFontMenu);
	 editMenu.addSeparator();
	 editMenu.add(editStyleMenu);
   }

   /** 
   * This method is used to create the Font Menu
   * Style Used: Serif Font
   *   		     Sans Serif Font
   */

   private void buildEditFontMenu()
   {
	   //Create Option for Serif Font
	   serifItem = new JRadioButtonMenuItem("Serif");
	   serifItem.addActionListener(new EditListener());
	   
	   //Create Option for Sans Serif Font
	   sansSerifItem = new JRadioButtonMenuItem("Sans Serif");
	   sansSerifItem.addActionListener(new EditListener());

	   //Group the buttons together to work as a pair
	   ButtonGroup group = new ButtonGroup();
	   group.add(serifItem);
	   group.add(sansSerifItem);

	   //Create Font Menu, Set KeyEvent 'T'
	   editFontMenu = new JMenu("Font");
	   editFontMenu.setMnemonic(KeyEvent.VK_T);

	   //Add Everything into the Font Menu
	   editFontMenu.add(serifItem);
	   editFontMenu.add(sansSerifItem);
	   editMenu.add(editFontMenu);
   }

   /**
   * This method is used to Create the Style Menu, in Edit
   *		-- Style Used: Italic - Bold
   */

	private void buildEditStyleMenu()
	{
		//Create Option for Italic Style of Font
		italicItem = new JCheckBoxMenuItem("Italic");
		italicItem.addActionListener(new EditListener());

		//Create Option for Bold Style of Font
		boldItem = new JCheckBoxMenuItem("Bold");
		boldItem.addActionListener(new EditListener());

		//Create Style Sub-Menu of Edit, Set KeyEvent 'Y'
		editStyleMenu = new JMenu("Style");
		editStyleMenu.setMnemonic(KeyEvent.VK_Y);

		//Add Everything into Style Menu
		editStyleMenu.add(italicItem);
		editStyleMenu.add(boldItem);
		editMenu.add(editStyleMenu);
	}
   
   /**
      The buildAboutMenu method creates the about menu
   */
   private void buildAboutMenu()
   {
	  //Create an About Menu, KeyEvent 'A'
      aboutItem = new JMenuItem("Created by Kenneth Hunter, 821-529-831");
      aboutMenu = new JMenu("About");
      aboutMenu.setMnemonic(KeyEvent.VK_A);
	
	  //Add Everything in "About" to the menu
      aboutMenu.add(aboutItem);
   }

   private class NewListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         editorText.setText("");
         filename = null;
      }
   }

   private class OpenListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int chooserStatus;

         JFileChooser chooser = new JFileChooser();
         chooserStatus = chooser.showOpenDialog(null);
         if (chooserStatus == JFileChooser.APPROVE_OPTION)
         {
            // Ask the User to Choose a File
            File selectedFile = chooser.getSelectedFile();

            // get the location of the file
            filename = selectedFile.getPath();

            // Open the file.
            if (!openFile(filename))
            {
               JOptionPane.showMessageDialog(null, "Error reading " + filename, "Error", JOptionPane.ERROR_MESSAGE);
            }
         }
      }

      /**
      * The openFile method is used to open a file for the user
      * @param filename -- The name of file requested
      * @return done  -- Return when it works.
      */
      private boolean openFile(String filename)
      {
         boolean done;
         String inputLine, editorString = "";
         FileReader freader;
         BufferedReader inputFile;

		 try {
     	 		// Open the file
         		freader = new FileReader(filename);
         		inputFile = new BufferedReader(freader);

    			// Reads the file, so can be used in the editor
        		inputLine = inputFile.readLine();
        		while (inputLine != null)
        		{
            		editorString = editorString + inputLine + "\n";
            		inputLine = inputFile.readLine();
      			}		
        		editorText.setText(editorString);

        		// Close the file, WE DONT NEED IT ANYMORE.
        		inputFile.close();  

        		// Has Completed Task
        		done = true;
         } 
		catch (IOException ex) {
			 	System.out.println("Failed to Open File: Error #1");
				done = false;
		 } 
        return done;
      }
   }

   /**
      When user selects "Save" or "SaveAs" from the menu
   */
   private class SaveListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int chooserStatus;

         if (e.getActionCommand() == "Save As" || filename == null)
         {
            JFileChooser chooser = new JFileChooser();
            chooserStatus = chooser.showSaveDialog(null);
            if (chooserStatus == JFileChooser.APPROVE_OPTION)
            {
               // Get a reference to the selected file
               File selectedFile = chooser.getSelectedFile();

               // Get the path of the selected file
               filename = selectedFile.getPath();
            }
         }

         // Save the file
         if (!saveFile(filename))
         {
            JOptionPane.showMessageDialog(null, "Error saving " + filename, "Error", JOptionPane.ERROR_MESSAGE);
         }
      }

      /**
      * The saveFile method saves the contents of the text area to a file
      * @param filename The name of the file
      * @return success
      */
      private boolean saveFile(String filename)
      {
         boolean success;
         String editorString;
         FileWriter fwriter;
         PrintWriter outputFile;

         try
         {
            // Open the file
            fwriter = new FileWriter(filename);
            outputFile = new PrintWriter(fwriter);

            // Write the contents of the text area to the file
            editorString = editorText.getText();
            outputFile.print(editorString);

            // Close the file
            outputFile.close();

            // Indicate that everything went OK
            success = true;
         }
         catch (IOException e)
         {
            // Catch the error
             success = false;
         }
         
         return success;
      }
   }

   /**
      When the user selects Exit from the file menu
   */
   private class ExitListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }

   /**
      When the user selects an item from the font menu
   */
   private class EditListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Get Font
         Font textFont = editorText.getFont();

         // Get Font Name/Size
         String fontName = textFont.getName();
         int fontSize = textFont.getSize();

         // Start PLANIN Font
         int fontStyle = Font.PLAIN;

         // Determine which font is selected
         if (serifItem.isSelected()) { fontName = "Serif"; }
         else if (sansSerifItem.isSelected()) { fontName = "SansSerif"; }
         
         // Determine whether italic is selected
         if (italicItem.isSelected()) { fontStyle += Font.ITALIC; }
         
         // Determine whether bold is selected
         if (boldItem.isSelected()) { fontStyle += Font.BOLD; }
         
         // Set the font
         editorText.setFont(new Font(fontName, fontStyle, fontSize));
      }
   }
   
   /**
      Where it all starts.
   */
   public static void main(String[] args)
   {
      new MyTextEditor();
   }
   
   // Add the window events constructors
   public void windowActivated(WindowEvent arg) { }
   public void windowClosed(WindowEvent arg0) { }
	//Exit, When the User clicks X
	public void windowClosing(WindowEvent arg0) { System.exit(0); }
	public void windowDeactivated(WindowEvent arg0) { } 
	public void windowDeiconified(WindowEvent arg0) { }
	public void windowIconified(WindowEvent arg0) { }
	public void windowOpened(WindowEvent arg0) { }
}
