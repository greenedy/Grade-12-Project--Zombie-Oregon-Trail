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
import javax.swing.Timer;
import java.util.Random;
import java.io.*;
import java.util.Scanner;


public class Instructions extends JFrame implements ActionListener  {


		JLabel lblFirstline,lblSecondline,lblThirdline;
    	JButton btnMainMenu;


    	JFrame frame = new JFrame("Instructions"); //creates a new frame titled "Load Game"

		JPanel info = new JPanel (new GridLayout(4,1));



    public Instructions() {

    	//instructions labels
		lblFirstline=new JLabel("Welcome to Organ Trail. Once you have created a team");
		lblSecondline=new JLabel("you can watch and manage your teams health to");
		lblThirdline=new JLabel("survive the zombie apocalypse.");

       	btnMainMenu=new JButton("Main Menu");

       	info.add(lblFirstline);
   		info.add(lblSecondline);
   		info.add(lblThirdline);
		info.add(btnMainMenu);


		btnMainMenu.addActionListener (this);
        //creates action listeners for done button to detect when it has been clicked


    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 280, 200);
        frame.setSize(500,400); //sets size of the frame
        frame.getContentPane().add(info); //adds the panel to the frame
        frame.setVisible(true);


    }
    	public void actionPerformed (ActionEvent e)
    {

			if (e.getSource () == btnMainMenu){//calls main menu

			new FinalProject3();
			frame.dispose();
			}





		}

    }











