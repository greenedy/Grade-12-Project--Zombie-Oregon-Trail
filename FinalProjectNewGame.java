import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.text.*;
import javax.swing.border.*;
import java.util.Scanner;

public class FinalProjectNewGame extends JFrame implements ActionListener {
	String PlayerName, FriendName1, FriendName2, FriendName3;//String variables for the names of user and users friends
    JTextField txtYourName, txtFriend1, txtFriend2, txtFriend3;//textfield variables made to input names
    JLabel lblInstructions, lblEnterYourName,lblFriend1,lblFriend2,lblFriend3,lblPartypic;//labels to tell user what to do and where
    JButton btnNext;//next button variable
//Player and friends health are set to 100 and their status's are set to normal
int playerhealth=100;
int friend1health=100;
int friend2health=100;
int friend3health=100;
String playerstatus="Normal";
String friend1status="Normal";
String friend2status="Normal";
String friend3status="Normal";
String carstatus="Normal";

    public  FinalProjectNewGame(){//creates frame for inputing names
    	JFrame frame = new JFrame("New Game"); //creates a new frame titled "New Game"

		// Create objects
		//panels made
        JPanel panel = new JPanel (new BorderLayout());
        JPanel north = new JPanel();
        JPanel centernames = new JPanel(new GridLayout(4,2));
        JPanel centerpic = new JPanel();
        JPanel center = new JPanel(new GridLayout(2,1));
        JPanel south = new JPanel();

		//labels are given text/image
		lblEnterYourName = new JLabel ("Enter your name: ",JLabel.CENTER);
		lblInstructions = new JLabel ("What's your name and 3 Friends you can count on: ",JLabel.CENTER);
		lblFriend1 = new JLabel ("Friend1: ",JLabel.CENTER);
		lblFriend2 = new JLabel ("Friend2: ",JLabel.CENTER);
		lblFriend3 = new JLabel ("Friend3: ",JLabel.CENTER);
		lblPartypic = new JLabel(new ImageIcon("teampic.JPG"));

		//Textfields are created
		txtYourName = new JTextField (12);
        txtFriend1 = new JTextField (12);
        txtFriend2 = new JTextField (12);
        txtFriend3 = new JTextField (12);

        btnNext = new JButton ("Next");//Next button is created


		north.add(lblInstructions);//instructions label is added to the north panel
	
		//centernames panel has labels and text fields added to it	
		centernames.add(lblEnterYourName);
		centernames.add(txtYourName);
		centernames.add(lblFriend1);
		centernames.add(txtFriend1);
		centernames.add(lblFriend2);
		centernames.add(txtFriend2);
		centernames.add(lblFriend3);
		centernames.add(txtFriend3);
		
		centerpic.add(lblPartypic);//centerpic panel has the picture label added to it

		center.add(centernames);//centernames is added to center panel
		center.add(centerpic);//centerpic is added to center panel

		south.add(btnNext);//next button is added to the south panel

		panel.add(north, BorderLayout.NORTH);//north panel is added to the main panels borderlayout north side
        panel.add(center, BorderLayout.CENTER);//center panel is added to the main panels borderlayout center side
        panel.add(south, BorderLayout.SOUTH);//south panel is added to the main panels borderlayout south side

        //creates action listeners for Next button to detect when it has been clicked
		btnNext.addActionListener (this);
	

    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 280, 200);
        frame.setSize(500,550); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);
    }
	//method that checks when certain actions are performed
	 public void actionPerformed (ActionEvent e)
    {
		if (e.getSource () == btnNext){//When the next button is clicked info is collected and a new window is opened
		//Names are collected from text fields
		if ((txtYourName.getText().equals(""))||(txtFriend1.getText().equals(""))||(txtFriend2.getText().equals(""))||(txtFriend3.getText().equals(""))){
			lblInstructions.setText("Make sure you have filled out all information!");
		}
		
		else{
		PlayerName = txtYourName.getText();
		FriendName1 = txtFriend1.getText();
		FriendName2 = txtFriend2.getText();
		FriendName3 = txtFriend3.getText();
		
		//an array of type survivor is made
		Survivor[] SurvivorArray = new Survivor[4];

		//Names,playerhealth,and playerstatus are added to the survivor array for each person
		SurvivorArray[0] = new Survivor(PlayerName,playerhealth,playerstatus);
		SurvivorArray[1] = new Survivor(FriendName1,friend1health,friend1status);
		SurvivorArray[2] = new Survivor(FriendName2,friend2health,friend2status);
		SurvivorArray[3] = new Survivor(FriendName3,friend3health,friend3status);

		new FinalProjectNewGameSupplies(SurvivorArray);//a new window is opened
		this.dispose();//this frame is closed
		}
		}
    }

}