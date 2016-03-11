	/**
 * @(#)Swing3.java
 *
 *
 * @author
 * @version 1.00 2013/12/17
 */
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

public class FinalProject3 extends JFrame implements ActionListener {

	// Declare objects
    JLabel lblTitle, lblMenuPic;
    JButton btnPlay, btnLoad, btnInstructions;//butttons made for main menu options


    public static void main(String[] args) { //main class
		new FinalProject3(); //creates an instance of FinalProject3
  	}

    public FinalProject3() {
    	JFrame frame = new JFrame("Organ Trail"); //creates a new frame titled "Organ Trail"

		// Create panels
        JPanel panel = new JPanel (new BorderLayout());
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel center = new JPanel();

		//Labels and buttons are given text/image
        lblTitle = new JLabel ("Zombie Oregon Trail");
        lblMenuPic = new JLabel (new ImageIcon("MainMenu.JPG"));
        btnPlay = new JButton ("New Game");
        btnLoad = new JButton ("Load");
		btnInstructions = new JButton ("Instructions");
        


		north.add(lblTitle);//title is added to the north panel

		center.add(lblMenuPic);//picture is added to center panel

		//buttons are added to the south panel
		south.add(btnPlay);
		south.add(btnLoad);
		south.add(btnInstructions);

		panel.add(north, BorderLayout.NORTH);//north panel is added to panel's north side
		panel.add(center, BorderLayout.CENTER);//center panel is added to panel's center side
        panel.add(south, BorderLayout.SOUTH);//south panel is added to panel's south side

        //creates action listeners for the buttons to detect when they have been clicked
		btnPlay.addActionListener (this);
		btnLoad.addActionListener (this);
		btnInstructions.addActionListener (this);

    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 300, 250);
        frame.setSize(500, 450); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);
    }
	//method that checks when certain actions are performed
	 public void actionPerformed (ActionEvent e)
    {
    	//When the play button is clicked it opens the travelscreen
		if (e.getSource () == btnPlay){
		new TravelScreen();
		this.dispose();//closes main menu

		}
		if (e.getSource () == btnLoad){
		new LoadGame();
		this.dispose();//closes main menu

		}
		if (e.getSource () == btnInstructions){
		new Instructions();
		this.dispose();//closes main menu

		}
    }

}
