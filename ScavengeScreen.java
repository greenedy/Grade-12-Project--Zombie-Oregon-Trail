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


public class ScavengeScreen extends JFrame implements ActionListener {
	String ZomAct;
	StopScreen stp;
	Supplies supplies;
	JButton btnContinue;
    JLabel lblZombieActivity,lblAmmo,lblScavenge1,lblScavenge2,lblScavenge3;
    JFrame frame = new JFrame("Scavenging"); //creates a new frame titled "Scavenging"
	Timer tmscavenge = new Timer(1000, this);//creates a timer that goes every 1000 miliseconds
	Random num = new Random();//randomnumbermaker made
	int randnum2,randnum3;//2 random number variables
	int x=0;//x variable made

		//panels made
		JPanel panel = new JPanel (new BorderLayout());
		JPanel southinfo1 = new JPanel (new GridLayout(1,2));
		JPanel southinfo2 = new JPanel ();
		JPanel southinfo = new JPanel (new CardLayout());
		JPanel centertext = new JPanel (new GridLayout(3,1));



    public ScavengeScreen(String zActivity,Supplies SupRec,StopScreen stopscreen) {
    	//Instance variables set
		ZomAct=zActivity;
		supplies=SupRec;
		stp=stopscreen;
		//labels and buttons made
		lblZombieActivity= new JLabel("Zombie Activity: "+ZomAct);
		lblAmmo=new JLabel("Ammo: "+supplies.getammo());
		lblScavenge1=new JLabel("",JLabel.CENTER);
		lblScavenge2=new JLabel("",JLabel.CENTER);
		lblScavenge3=new JLabel("",JLabel.CENTER);
		btnContinue= new JButton("Continue");

       	//ammo label ,zombie activity label add to south info 1 and continue button to south info 2
       	southinfo1.add(lblAmmo);
       	southinfo1.add(lblZombieActivity);
       	southinfo2.add(btnContinue);

       	//south info 1 and 2 added to the main southinfo
       	southinfo.add(southinfo1,"Scavenging");
       	southinfo.add(southinfo2,"Continue");

       	//centertextlabels added to center panel
       	centertext.add(lblScavenge1);
       	centertext.add(lblScavenge2);
       	centertext.add(lblScavenge3);

		//panels added to main panel
		panel.add(centertext, BorderLayout.CENTER);
		panel.add(southinfo, BorderLayout.SOUTH);

        //creates action listeners for continue button to detect when it has been clicked
		btnContinue.addActionListener (this);

    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 280, 200);
        frame.setSize(500,400); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);

        tmscavenge.start();
    }

    public void actionPerformed (ActionEvent e)
    {
    CardLayout cl = (CardLayout)(southinfo.getLayout());//cardlayout changer made

    String Text="Scavenging";//text variable made

    	if (e.getSource () == btnContinue){
    		//if continue button is clicked then you are returned to the stop screen
    		stp.BackfromScavengeScreen(supplies);
    		frame.dispose();
    	}

      if (e.getSource () == tmscavenge){//when the timer button ticks

			if (x==3){
				//if the timer has gone 3 times then it stops and shows the continue button
    					tmscavenge.stop();
    					cl.show(southinfo, ("Continue"));
    		}

    	  if(ZomAct.equals("Low")){//if zombieactivity is low then random num can be high
    	  	 randnum2 = num.nextInt(8 - 1 + 1) + 1;
    	  }
    	  if(ZomAct.equals("Medium")){//if zombieactivity is medium then random num can be medium
    	  	 randnum2 = num.nextInt(5 - 1 + 1) + 1;
    	  }
    	  if(ZomAct.equals("High")){//if zombieactivity is high then random num can be low
    	  	 randnum2 = num.nextInt(3 - 1 + 1) + 1;
    	  }

		  randnum3 = num.nextInt(5 - 1 + 1) + 1;
		 //randomnumber is made and chosses what supply is found and ammo goes down as you do so
		  if (randnum3==1){
		  	Text="fuel";//found fuel
		  	supplies.addfuel(randnum2);
		  	if(supplies.getammo()-2<=0){
		  		supplies.setammo(0);
		  	}
		  	else{
		  		supplies.subtractammo(2);
		  	}
		  }
		  else if (randnum3==2){
		  	Text="food";//found food
		  	supplies.addfood(randnum2);
		  	if(supplies.getammo()-2<=0){
		  		supplies.setammo(0);
		  	}
		  	else{
		  		supplies.subtractammo(2);
		  	}
		  }
		  else if (randnum3==3){
		  	Text="money";//found money
		  	supplies.addmoney(randnum2);
		  if(supplies.getammo()-2<=0){
		  		supplies.setammo(0);
		  	}
		  	else{
		  		supplies.subtractammo(2);
		  	}
		  }
		  else if (randnum3==4){
		  	Text="ammo";//found ammo
		  	supplies.addammo(randnum2);
		  }
		  else if (randnum3==5){
		  	Text="repairkit";//found repair kit
		  	supplies.addrepairkit(randnum2);
		  	if(supplies.getammo()-2<=0){
		  		supplies.setammo(0);
		  	}
		  	else{
		  		supplies.subtractammo(2);
		  	}

		  }

			Text="You find "+randnum2+" "+Text;//Text is set to what was found and how much

			if (x==0){//if its the timers first time around then it sets to the first label
			lblScavenge1.setText(Text);
			lblAmmo.setText("Ammo: "+supplies.getammo());
			}
			else if(x==1){//if its the timers second time around then it sets to the second label
			lblScavenge2.setText(Text);
			lblAmmo.setText("Ammo: "+supplies.getammo());
			}
			else if (x==2){//if its the timers third time around then it sets to the third label
			lblScavenge3.setText(Text);
			lblAmmo.setText("Ammo: "+supplies.getammo());
			}

			 x=x+1; //x counter increases by 1//
    		 }

       	 }
     }
