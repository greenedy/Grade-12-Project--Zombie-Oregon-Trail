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

public class Event {
private String eventtext,eventpic;
 JLabel lbleventtext, lblPic;
 JButton btnContinue;
 TravelScreen tscreen;  
 
 JFrame frame = new JFrame("Event"); //creates a new frame titled "Sandwich Order"
 
   public Event(String eventrec,TravelScreen travelscreen) {
    	eventtext=eventrec;
    	tscreen=travelscreen;
    	//eventpic=picrec;
    
    	// Create objects
        JPanel panel = new JPanel (new BorderLayout());
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel center = new JPanel(new GridLayout(2,1));

        lbleventtext = new JLabel (eventtext);
       // lblPic = new JLabel (new ImageIcon(eventpic));
        btnContinue = new JButton ("Continue");
        

	//	north.add(lblTitle);

		center.add(lbleventtext);

		south.add(btnContinue);
		
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);

        //creates action listeners for done button to detect when it has been clicked
		btnContinue.addActionListener((ActionListener) this);
		


    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 300, 250);
        frame.setSize(400, 400); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);
    
    	
    }
    
 	//method that checks when certain actions are performed
	 public void actionPerformed (ActionEvent e)
    {
		if (e.getSource () == btnContinue){
		
		tscreen.BackFromStop2 ();
		frame.dispose();

		}
    }
  
}