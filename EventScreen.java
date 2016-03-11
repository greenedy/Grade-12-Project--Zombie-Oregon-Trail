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


public class EventScreen extends JFrame implements ActionListener  {
private String eventtext,eventpic;//variables made for event text and event pic
 JLabel lbleventtext, lblPic;//labels for the event text and pic are made
 JButton btnContinue;//continue button made
 TravelScreen tscreen;//a travel screen variable to hold the trravel screen is made
 int Chealth;//Car health
 String Cstatus;//car status

 JFrame frame = new JFrame("Event"); //creates a new frame titled "Event"

   public EventScreen(String eventrec,TravelScreen travelscreen,int carhealth, String carstatus) {
    	//instance variables set
    	eventtext=eventrec;
    	tscreen=travelscreen;
    	Chealth=carhealth;
    	Cstatus=carstatus;



    	// Create panels
        JPanel panel = new JPanel (new BorderLayout());
        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel center = new JPanel(new GridLayout(2,1));


        //label and button are set
        lbleventtext = new JLabel (eventtext,JLabel.CENTER);
        btnContinue = new JButton ("Continue");




		center.add(lbleventtext);//add event text to center panel

		south.add(btnContinue);//add continue button to south panel

		//add panels to main panel
		panel.add(north, BorderLayout.NORTH);
		panel.add(center, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);

        //creates action listeners for continue button to detect when it has been clicked
		btnContinue.addActionListener (this);



    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 300, 250);
        frame.setSize(550, 400); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);


    }

 	//method that checks when certain actions are performed
	 public void actionPerformed (ActionEvent e)
    {
		if (e.getSource () == btnContinue){//when continue button is clicked
			//if the event text is Game over or you win it will take you back to the main menu
			if ((eventtext.equals("Game Over"))||(eventtext.equals("You Win"))){
				new FinalProject3();
				tscreen.dispose();
				frame.dispose();
			}
			else{
				//else it'll call a method from the travel screen and the frame will dispose
					tscreen.BackFromEvent (Chealth,Cstatus);
					frame.dispose();
			}


		}
    }

}