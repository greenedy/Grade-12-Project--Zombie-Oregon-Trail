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
import java.util.Random;

public class StopScreen extends JFrame implements ActionListener{
	String zombieactivity;
	int carhealth,StrangerTradeAmount,PlayerTradeAmount,amount,randnum1,randnum2;//int variables made
	String carstatus, Text,Text2;//string varibles made
	Supplies Supplies;//supplies object made
	TravelScreen TScreen;//travels screen variable made
	//labels made
    JLabel lblZombieActivity, lblTrade,lblcar,lblPlayer,lblFriend1,lblFriend2,lblFriend3,lblSelection,lblRestImage,lblCarImage,lblTradeImage;
    JLabel lblRepairKits,lblFuel,lblFood,lblMoney,lblAmmo,lblRepairKitsRepair;
    //buttons made
    JButton btnRest,btnCar,btnScavenge,btnTrade,btnDrive,btnRepair,btnTradeTrade,btnTradeNext,btnRestRest;
 	Survivor[] SurvivorArrayStopScreen = new Survivor[3];//survivor array made
 	
 	Random num = new Random();//random number made

//jpanels made
		JPanel panel = new JPanel (new BorderLayout());

		JPanel RestRight = new JPanel();
        JPanel RestLeft = new JPanel(new GridLayout(4,1));
        JPanel Rest = new JPanel(new GridLayout(1,2));

        JPanel CarLeft = new JPanel(new GridLayout(4,1));
        JPanel CarRight = new JPanel();
        JPanel Car = new JPanel(new GridLayout(1,2));

        JPanel Scavenge = new JPanel();

        JPanel TradeRight = new JPanel();
        JPanel TradeLeft = new JPanel(new GridLayout(8,1));
        JPanel Trade = new JPanel(new GridLayout(2,1));

        JPanel north = new JPanel();
        JPanel center = new JPanel(new CardLayout());
        JPanel south = new JPanel();
		JFrame frame = new JFrame("Stopped"); //creates a new frame titled "Sandwich Order"

	public void BackfromScavengeScreen(Supplies supplies) {//runs when returning from scavenge screen to update supplies
		Supplies=supplies;
		
	}


    public StopScreen(Survivor[] SurvivorArrayRec,Supplies supplies,int CARHEALTH,String CARSTATUS,TravelScreen travelscreen,String zomAct) {
		//instance variables set
    	Supplies=supplies;
    	carhealth=CARHEALTH;
    	carstatus=CARSTATUS;
    	SurvivorArrayStopScreen=SurvivorArrayRec;
		TScreen=travelscreen;
		zombieactivity=zomAct;


		// Create objects
		lblRepairKitsRepair= new JLabel("RepairKits: "+Supplies.getrepairkit());
		lblRepairKits= new JLabel("RepairKits: "+Supplies.getrepairkit());
		lblFuel= new JLabel("Fuel: "+Supplies.getfuel());
		lblFood= new JLabel("Food: "+Supplies.getfood());
		lblMoney= new JLabel("Money: "+Supplies.getmoney());
		lblAmmo= new JLabel("Ammo: "+Supplies.getammo());
		lblRestImage = new JLabel(new ImageIcon("Camp.JPG"));
		lblCarImage = new JLabel(new ImageIcon("Car_Red.png"));
		lblTradeImage = new JLabel(new ImageIcon("Trade.GIF"));
		lblZombieActivity = new JLabel ("Zombie Activity: "+zombieactivity,JLabel.CENTER);
		lblTrade = new JLabel ("A stranger would like to trade --- of their ----- for -- of your -----",JLabel.CENTER);
		lblPlayer = new JLabel(SurvivorArrayStopScreen[0].getname()+" Health: "+SurvivorArrayStopScreen[0].gethealth()+" Status: "+SurvivorArrayStopScreen[0].getstatus());
		lblFriend1 = new JLabel (SurvivorArrayStopScreen[1].getname()+" Health: "+SurvivorArrayStopScreen[1].gethealth()+" Status: "+SurvivorArrayStopScreen[1].getstatus());
		lblFriend2 = new JLabel (SurvivorArrayStopScreen[2].getname()+" Health: "+SurvivorArrayStopScreen[2].gethealth()+" Status: "+SurvivorArrayStopScreen[2].getstatus());
		lblFriend3 = new JLabel (SurvivorArrayStopScreen[3].getname()+" Health: "+SurvivorArrayStopScreen[3].gethealth()+" Status: "+SurvivorArrayStopScreen[3].getstatus());
		lblcar= new JLabel("Car Health: "+carhealth+" Status: "+carstatus);
		lblSelection= new JLabel("REST");

		btnRest = new JButton ("Rest");
	    btnCar = new JButton ("Car");
 		btnScavenge = new JButton ("Scavenge");
        btnTrade = new JButton ("Trade");
	    btnDrive = new JButton ("Drive");
		btnRepair =new JButton ("Repair");
		btnTradeTrade=new JButton ("Accept Trade");
		btnRestRest=new JButton ("Take a rest");
		btnTradeNext=new JButton ("Decline Trade");

		//add objects to panels
		north.add(lblSelection);

		CarLeft.add(lblcar);
		CarLeft.add(lblRepairKitsRepair);

		CarRight.add(lblCarImage);
		CarRight.add(btnRepair);

		Car.add(CarLeft);
		Car.add(CarRight);


		TradeLeft.add(lblTrade);
		TradeLeft.add(btnTradeTrade);
		TradeLeft.add(btnTradeNext);
		TradeLeft.add(lblFuel);
		TradeLeft.add(lblFood);
		TradeLeft.add(lblMoney);
		TradeLeft.add(lblAmmo);
		TradeLeft.add(lblRepairKits);


		TradeRight.add(lblTradeImage);

		Trade.add(TradeRight);
		Trade.add(TradeLeft);


		RestRight.add(lblRestImage);


		RestLeft.add(lblPlayer);
		RestLeft.add(lblFriend1);
		RestLeft.add(lblFriend2);
		RestLeft.add(lblFriend3);

		Rest.add(RestLeft);
		Rest.add(RestRight);

		center.add(Rest,"Rest");
		center.add(Car,"Car");
		center.add(Scavenge,"Scavenge");
		center.add(Trade,"Trade");

		south.add(btnRest);
		south.add(btnCar);
		south.add(btnScavenge);
		south.add(btnTrade);
		south.add(btnDrive);

//add panels to main panel
		panel.add(north, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);

        //creates action listeners for buttons to detect when theyre been clicked
		btnRest.addActionListener (this);
		btnCar.addActionListener (this);
		btnScavenge.addActionListener (this);
		btnTrade.addActionListener (this);
		btnTradeTrade.addActionListener (this);
		btnTradeNext.addActionListener (this);
		btnDrive.addActionListener (this);



    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 280, 200);
        frame.setSize(500,400); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);
    }

 public void actionPerformed (ActionEvent e)//performs actions for each button
    {
    	CardLayout cl = (CardLayout)(center.getLayout());//layout changer made
		if (e.getSource () == btnRest){//if rest button is clicked then rest panel is shown

		lblSelection.setText("REST");
		cl.show(center, ("Rest"));
		}
		else if (e.getSource () == btnCar){//if car button is clicked then car panel is shown
		lblRepairKitsRepair.setText("RepairKits: "+Supplies.getrepairkit());
	   	lblSelection.setText("CAR");
		cl.show(center, ("Car"));



		}
		else if (e.getSource () == btnScavenge){//if scavengr button is clicked then scavenge screen

 		new ScavengeScreen(zombieactivity,Supplies,this);


		}
		else if (e.getSource () == btnTrade){//when trade button is clicked 
 		 lblSelection.setText("TRADE");
 		 //supplies labels are updated
		 lblRepairKits.setText("RepairKits: "+Supplies.getrepairkit());
		 lblFuel.setText("Fuel: "+Supplies.getfuel());
	  	 lblFood.setText("Food: "+Supplies.getfood());
	   	 lblMoney.setText("Money: "+Supplies.getmoney());
		 lblAmmo.setText("Ammo: "+Supplies.getammo());
//		 a trade is generated and shown
		 GenerateTrade();
		 lblTrade.setText("A stranger would like to trade "+StrangerTradeAmount+" of their "+Text+" for "+PlayerTradeAmount+" of your "+Text2);
		 cl.show(center, ("Trade"));


		}
		else if (e.getSource () == btnTradeTrade){
	//checks to see if able to trade and will do trade
		 		if(Text2.equals("fuel")){
		 			 if(Supplies.getfuel()-PlayerTradeAmount<=(-1)){
		 			 }
		 			 else{
		 			 	Supplies.subtractfuel(PlayerTradeAmount);
		 			 	if(Text.equals("fuel")){
		 			 	Supplies.addfuel(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("food")){
		 			 	Supplies.addfood(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("money")){
		 			 	Supplies.addmoney(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("ammo")){
		 			 	Supplies.addammo(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("repairkit")){
		 			 	Supplies.addrepairkit(StrangerTradeAmount);
		 			 	}
		 			 }
		 		}
				else if(Text2.equals("food")){
		 		 if(Supplies.getfood()-PlayerTradeAmount<=(-1)){
		 			 }
		 			 else{
		 			 	Supplies.subtractfood(PlayerTradeAmount);
		 			 	if(Text.equals("fuel")){
		 			 	Supplies.addfuel(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("food")){
		 			 	Supplies.addfood(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("money")){
		 			 	Supplies.addmoney(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("ammo")){
		 			 	Supplies.addammo(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("repairkit")){
		 			 	Supplies.addrepairkit(StrangerTradeAmount);
		 			 	}
		 			 }
		 		}
		 		else if(Text2.equals("money")){
		 		 if(Supplies.getmoney()-PlayerTradeAmount<=(-1)){
		 			 }
		 			 else{
		 			 	Supplies.subtractmoney(PlayerTradeAmount);
		 			 	if(Text.equals("fuel")){
		 			 	Supplies.addfuel(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("food")){
		 			 	Supplies.addfood(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("money")){
		 			 	Supplies.addmoney(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("ammo")){
		 			 	Supplies.addammo(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("repairkit")){
		 			 	Supplies.addrepairkit(StrangerTradeAmount);
		 			 	}
		 			 }
		 		}
		 		else if(Text2.equals("ammo")){
		 		 if(Supplies.getammo()-PlayerTradeAmount<=(-1)){
		 			 }
		 			 else{
		 			 	Supplies.subtractammo(PlayerTradeAmount);
		 			 	if(Text.equals("fuel")){
		 			 	Supplies.addfuel(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("food")){
		 			 	Supplies.addfood(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("money")){
		 			 	Supplies.addmoney(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("ammo")){
		 			 	Supplies.addammo(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("repairkit")){
		 			 	Supplies.addrepairkit(StrangerTradeAmount);
		 			 	}
		 			 }
		 		}
		 		else if(Text2.equals("repairkit")){
		 		 if(Supplies.getrepairkit()-PlayerTradeAmount<=(-1)){
		 			 }
		 			 else{
		 			 	Supplies.subtractrepairkit(PlayerTradeAmount);
		 			 	if(Text.equals("fuel")){
		 			 	Supplies.addfuel(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("food")){
		 			 	Supplies.addfood(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("money")){
		 			 	Supplies.addmoney(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("ammo")){
		 			 	Supplies.addammo(StrangerTradeAmount);
		 			 	}
		 			 	else if(Text.equals("repairkit")){
		 			 	Supplies.addrepairkit(StrangerTradeAmount);
		 			 	}
		 			 }
		 		}
		 //labels updated
		 lblRepairKits.setText("RepairKits: "+Supplies.getrepairkit());
		 lblFuel.setText("Fuel: "+Supplies.getfuel());
	  	 lblFood.setText("Food: "+Supplies.getfood());
	   	 lblMoney.setText("Money: "+Supplies.getmoney());
		 lblAmmo.setText("Ammo: "+Supplies.getammo());
 		 GenerateTrade();//new trade generated then shown
		 lblTrade.setText("A stranger would like to trade "+StrangerTradeAmount+" of their "+Text+" for "+PlayerTradeAmount+" of your "+Text2);
		}
		else if (e.getSource () == btnTradeNext){
		//new trade generated an shown
 		GenerateTrade();
		lblTrade.setText("A stranger would like to trade "+StrangerTradeAmount+" of their "+Text+" for "+PlayerTradeAmount+" of your "+Text2);


		}

		else if (e.getSource () == btnDrive){//if drive button is clicked
			//tells travel screen that its back from stop screen
			TScreen.BackFromStop (carhealth,carstatus,Supplies);
			frame.dispose();//stopscreen closses

		}
		else if (e.getSource () == btnRepair){//if repair button is clicked then it checks if its  able to be fixed

			if((Supplies.getrepairkit()<=0)||(carhealth==100)){
				lblcar= new JLabel("Car Health: "+carhealth+" Status: "+carstatus);
			}
			else{

					if(carhealth+25>=100){
						carhealth=100;
						Supplies.subtractrepairkit(1);
					}
					else{
						carhealth=carhealth+25;
						Supplies.subtractrepairkit(1);
					}
				lblRepairKitsRepair.setText("RepairKits: "+Supplies.getrepairkit());

			}



		}

    }

    public void GenerateTrade() {//generates random trade with random numbers and if else  statements
		StrangerTradeAmount = num.nextInt(3 - 1 + 1) + 1;
		PlayerTradeAmount = num.nextInt(3 - 1 + 1) + 1;
    	randnum1 = num.nextInt(5 - 1 + 1) + 1;
    	randnum2 = num.nextInt(5 - 1 + 1) + 1;

		  if (randnum1==1){
		  	Text="fuel";

		  }
		  else if (randnum1==2){
		  	Text="food";

		  }
		  else if (randnum1==3){
		  	Text="money";

		  }
		  else if (randnum1==4){
		  	Text="ammo";

		  }
		  else if (randnum1==5){
		  	Text="repairkit";

		  }

    	  if (randnum2==1){
		  	Text2="fuel";

		  }
		  else if (randnum2==2){
		  	Text2="food";

		  }
		  else if (randnum2==3){
		  	Text2="money";

		  }
		  else if (randnum2==4){
		  	Text2="ammo";

		  }
		  else if (randnum2==5){
		  	Text2="repairkit";

		  }





	}

}