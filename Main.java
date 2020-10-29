import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
	JLabel firstLabel;
	JLabel secondLabel;
	JLabel thirdLabel; 

	JTextField firstInput;
  JTextField secondInput;
  JTextField thirdInput;

	JButton validateButton;
  JButton resetButton;

	JTextArea outputText;
  JTextArea instructionText;

	Font biggerText;




  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("My First Program");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

	 //initialize the main Jpanel
	 mainPanel = new JPanel();
	 //disable any layout helpers 
	 mainPanel.setLayout(null);

	 // create the side labels
	 firstLabel = new JLabel("Enter the first side:");
	 secondLabel = new JLabel("Enter the second side:");
	 thirdLabel = new JLabel("Enter the third side:");

	 //layout the labels by setting the coordinate and size
	 //set bounds(x,y,width,height) 
	 firstLabel.setBounds(10,10,150,20);
	 secondLabel.setBounds(10,40,175,20);
	 thirdLabel.setBounds(10,70,150,20);

	 //initialize the input text field
	 firstInput = new JTextField();
	 secondInput = new JTextField();
	 thirdInput = new JTextField();

	 //set the location and size
	 firstInput.setBounds(220, 10, 100, 20);
	 secondInput.setBounds(220,40,100,20);
	 thirdInput.setBounds(220,70,100,20);

	 //initialize the buttons
	 validateButton = new JButton("Validate");
	 resetButton = new JButton("Reset");

	 //set the size and location of the buttons
	 validateButton.setBounds(330, 10, 100, 35);
	 resetButton.setBounds(330,55,100,35);

	 //add an action listener top the buttons
	 validateButton.addActionListener(this);
	 resetButton.addActionListener(this);

	 //set the action commands to the buttons
	 validateButton.setActionCommand("validate");
	 resetButton.setActionCommand("reset");

	 // initialize the JButtons
   outputText = new JTextArea();
   instructionText = new JTextArea();

   //create a string that holds the instructiosn;
	 String instructions = "This is a simple triangle detector. \nEnter an Integer in each of the text fields above. \nPress the \"Validate Button\" to find out wether you have made a valid triangle or not. \nYou can press Reset to clear everythign out.";

	 //set the text in the instruction area 
	 instructionText.setText(instructions);

	 //set the size and location of the text areas
	 outputText.setBounds(10,100,780,240);
	 instructionText.setBounds(10,350,780,240);

	 //make it so that user cant type in the text box
	 outputText.setEnabled(false);
	 instructionText.setEnabled(false);

	 // create a bigger font to use 
	 biggerText = new Font("arial", Font.PLAIN, 16);

	 //set the font on the area I want to use it 
	 instructionText.setFont(biggerText);

	 //add the main panel;
   mainPanel.add(outputText);
   mainPanel.add(instructionText);

	 //add the buttons to the mainPanel
	 mainPanel.add(validateButton);
	 mainPanel.add(resetButton);

	 //add the text fields to the panel
	 mainPanel.add(firstInput);
	 mainPanel.add(secondInput);
	 mainPanel.add(thirdInput);


	//add the labels to the main mainPanel
	mainPanel.add(firstLabel);
	mainPanel.add(secondLabel);
	mainPanel.add(thirdLabel);

	// add the panel to the window
	frame.add(mainPanel);

  }
	//checks to see if a traingle is valid given the legnth of side a, side b, and c 
	public boolean isValidTriangle(int a, int b, int c){
		// check using the triangle inequality
		if(a + b > c && a + c > b && b + c > a){
			//valid triangle
			return true;
		}else{
			// invalid triangle 
			return false;
		}

	}
  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
		if(command.equals("validate")){
			//get all of the text in the text boxes
			String firstText = firstInput.getText();
			String secondText = secondInput.getText();
			String thirdText = thirdInput.getText();

			//change the string into an Integer
			int sideA = Integer.parseInt(firstText);
			int sideB = Integer.parseInt(secondText);
			int sideC = Integer.parseInt(thirdText);
			//using a method to check if the triangle is valid 
			boolean isValid = isValidTriangle(sideA, sideB, sideC);
			// output the answer to the user 
			if(isValid){
				outputText.setText("This is a valid triangle");
			}else{
				outputText.setText("This is an invalid triangle");
			}
		}else if(command.equals("reset")){
			//clear all of the texts in the text boxes
			firstInput.setText("");
			secondInput.setText("");
			thirdInput.setText("");
			outputText.setText("");
		}
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
