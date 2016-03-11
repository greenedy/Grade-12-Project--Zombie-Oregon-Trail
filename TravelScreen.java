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
//Travelscreen is what

public class TravelScreen extends JFrame implements ActionListener   {
private	Random num = new Random();//Randum num made
private	int randnum;//randnum variablemade
Timer tm = new Timer(50, this);//timer to increase distance added
Timer tmEventsSupplies = new Timer(10000, this);//timer for events and supplies
String CarStatus;//car status made
String ZombieActivity;///zombie activity string variable
int place;//place num
int CarHealth;//car health
//supplies variables
int FUEL;
int FOOD;
int MONEY;
int AMMO;
int REPAIRKIT;
//Distance variables
int DistanceTraveled;
int DistancePlace=10;
int DistanceSick,DistanceDehydrated;
Car car = new Car();//new car object made
CarPanel carpanel = new CarPanel();//new car panel made
Survivor[] SurvivorArray = new Survivor[3];//survivor array created
Supplies Supplies;///supplies object made
//labels and buttons mademade
JLabel lblHealthCross,lblFuel, lblFood,lblMoney,lblAmmo,lblRepairKit,lblPlayerHealth,lblFriend1Health,lblFriend2Health,lblFriend3Health,lblCarHealth,lblDistanceTraveled,lblDistancePlace,lblZombieActivity;
JButton btnStopHealth,btnStopInfo,btnHealth,btnInfo,btnSaveandQuitHealth,btnSaveandQuitInfo;

    	JFrame frame = new JFrame("Traveling"); //creates a new frame titled "Traveling"

		// Create panels
        JPanel panel = new JPanel (new BorderLayout());
        JPanel northSupplies = new JPanel(new GridLayout(1,5));
        JPanel centerGraphics = new JPanel();
        JPanel southINFO = new JPanel(new GridLayout(1,2));
        JPanel southHEALTH = new JPanel(new GridLayout(1,2));
        JPanel southSideRightInfo = new JPanel(new GridLayout(3,1));
        JPanel southSideRightHealth = new JPanel(new GridLayout(3,1));
        JPanel southSideLeftInfo = new JPanel(new GridLayout(4,1));
        JPanel southSideLeftHealth = new JPanel(new GridLayout(4,1));
        JPanel southSides = new JPanel(new CardLayout());


    public TravelScreen() {
    	new FinalProjectNewGame();//goes to new game if no parameters recieved
    	this.dispose();
    }




    public TravelScreen(Survivor[] survivorarray, int CARHEALTH,String CARSTATUS,Supplies supplies,int distancetraveled,int distanceplace,String ZomAct,int Place) {

//Instance variables set
    	Supplies= supplies;
    	SurvivorArray=survivorarray;
    	CarStatus=CARSTATUS;
    	CarHealth=CARHEALTH;
		DistanceTraveled=distancetraveled;
		DistancePlace=distanceplace;
		ZombieActivity=ZomAct;
		place=Place;



//Labels are set
		lblCarHealth = new JLabel ("Car Health: "+CarHealth+" Status: "+CarStatus);
		lblHealthCross = new JLabel(new ImageIcon("HealthCross.JPG"));
  		lblPlayerHealth = new JLabel (SurvivorArray[0].getname()+" Health: "+SurvivorArray[0].gethealth()+" Status: "+SurvivorArray[0].getstatus());
  		lblFriend1Health = new JLabel (SurvivorArray[1].getname()+" Health: "+SurvivorArray[1].gethealth()+" Status: "+SurvivorArray[1].getstatus());
  		lblFriend2Health = new JLabel (SurvivorArray[2].getname()+" Health: "+SurvivorArray[2].gethealth()+" Status: "+SurvivorArray[2].getstatus());
  		lblFriend3Health = new JLabel (SurvivorArray[3].getname()+" Health: "+SurvivorArray[3].gethealth()+" Status: "+SurvivorArray[3].getstatus());
       	lblFuel = new JLabel (" Fuel: "+Supplies.getfuel());
        lblFood = new JLabel (" Food: "+Supplies.getfood());
       	lblMoney = new JLabel (" Money: "+Supplies.getmoney());
        lblAmmo = new JLabel (" Ammo: "+Supplies.getammo());
       	lblRepairKit = new JLabel (" RepairKit: "+Supplies.getrepairkit());
        lblDistanceTraveled= new JLabel ("Distance Traveled: "+DistanceTraveled+" miles");
        lblDistancePlace= new JLabel ("Distance to next place: "+DistancePlace+" miles");
        lblZombieActivity= new JLabel ("ZombieActivity: "+ZombieActivity);

//buttons made
		btnSaveandQuitHealth = new JButton("Save & Quit");
		btnSaveandQuitInfo = new JButton("Save & Quit");
        btnStopInfo = new JButton ("Stop");
        btnStopHealth = new JButton ("Stop");
 		btnHealth = new JButton ("Health");
		btnInfo = new JButton ("Info");

//borders made for the supplies amd options
    	TitledBorder borderSupplies = new TitledBorder (new LineBorder (Color.black), "Supplies:");
			northSupplies.setBorder (borderSupplies);


		TitledBorder borderOptions = new TitledBorder (new LineBorder (Color.black), "Options:");
			southSides.setBorder (borderOptions);


		//adding objects to panels
		centerGraphics.add(carpanel);

		northSupplies.add(lblFuel);
		northSupplies.add(lblFood);
		northSupplies.add(lblMoney);
		northSupplies.add(lblAmmo);
		northSupplies.add(lblRepairKit);

		southSideLeftHealth.add(lblPlayerHealth);
		southSideLeftHealth.add(lblFriend1Health);
		southSideLeftHealth.add(lblFriend2Health);
		southSideLeftHealth.add(lblFriend3Health);

		southSideLeftInfo.add(lblCarHealth);
		southSideLeftInfo.add(lblDistanceTraveled);
		southSideLeftInfo.add(lblDistancePlace);
		southSideLeftInfo.add(lblZombieActivity);

		southSideRightInfo.add(btnStopInfo);
		southSideRightInfo.add(btnHealth);
		southSideRightInfo.add(btnSaveandQuitInfo);

		southSideRightHealth.add(btnStopHealth);
		southSideRightHealth.add(btnInfo);
		southSideRightHealth.add(btnSaveandQuitHealth);

		southINFO.add(southSideLeftInfo);
		southINFO.add(southSideRightInfo);

		southHEALTH.add(southSideLeftHealth);
		southHEALTH.add(southSideRightHealth);

		southSides.add(southINFO,"Info");
		southSides.add(southHEALTH,"Health");

		//adding panels to main panel
		panel.add(northSupplies, BorderLayout.NORTH);
        panel.add(centerGraphics, BorderLayout.CENTER);
        panel.add(southSides, BorderLayout.SOUTH);

        //creates action listeners for  buttons to detect when theyve been clicked
        btnSaveandQuitInfo.addActionListener (this);
        btnSaveandQuitHealth.addActionListener (this);
		btnStopHealth.addActionListener (this);
		btnStopInfo.addActionListener (this);
		btnHealth.addActionListener (this);
		btnInfo.addActionListener (this);
		// Add listeners


    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 300, 250);
        frame.setSize(600, 500); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);

		//timers start
		tm.start();
		tmEventsSupplies.start();
    }

     public void actionPerformed (ActionEvent e)
    {
     CardLayout cl = (CardLayout)(southSides.getLayout());//card layout chanager

	   if (e.getSource () == btnSaveandQuitHealth){
		//timers stop
		tm.stop();
		tmEventsSupplies.stop();
		try{
			//Save and quit is called
    		new SaveandQuit(SurvivorArray,Supplies,CarHealth,CarStatus,ZombieActivity,DistanceTraveled,DistancePlace,place);
    		this.dispose();
		}
		catch(IOException ioe){
    //Handle exception here, most of the time you will just log it.
		}


		}
	   if (e.getSource () == btnSaveandQuitInfo){
		//timers stop
		tm.stop();
		tmEventsSupplies.stop();
		try{
		//Save and quit is called
    	new SaveandQuit(SurvivorArray,Supplies,CarHealth,CarStatus,ZombieActivity,DistanceTraveled,DistancePlace,place);
    	this.dispose();
		}
		catch(IOException ioe){
		}


		}
		if (e.getSource () == btnStopHealth){
		//timers stop and stopscreen is called
		tm.stop();
		tmEventsSupplies.stop();
		new StopScreen(SurvivorArray,Supplies,CarHealth,CarStatus,this,ZombieActivity);

		}
		else if (e.getSource () == btnStopInfo){
		//timers stop and stopscreen is called
		tm.stop();
		tmEventsSupplies.stop();
  	    new StopScreen(SurvivorArray,Supplies,CarHealth,CarStatus,this,ZombieActivity);

	    }
		else if (e.getSource () == btnHealth){
			//when health button is clicked it show health panel
	       	cl.show(southSides, ("Health"));

    	 }
    	 else if (e.getSource () == btnInfo){
	//when info button is clicked it show info panel
	       	 cl.show(southSides, ("Info"));

    	 }
    	 else if (e.getSource () == tm){

		//when the timer ticks it makes the graphics move
    	 	carpanel.Move();
			carpanel.repaint();
    	 	Traveling();
    	 }
    	 else if (e.getSource () == tmEventsSupplies){
    	  //Calls random events
    	  String EventText;
    	  randnum = num.nextInt(12 - 1 + 1) + 1;

    		switch (randnum)    {
			      case 1:  EventText="You find 2 canisters of fuel in an abandond car.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       Supplies.addfuel(2);
			      	       tm.stop();
						   tmEventsSupplies.stop();
			               break;
			      case 2:
			      		   EventText="You drive over a sharp object and pop your tire. Your car takes damage";
			      	       if(CarHealth-25<=0){
			      	       	CarHealth=0;
			      	       }
			      	       else{
			      	       	CarHealth=CarHealth-25;
			      	       }
			      	        new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       tm.stop();
						   tmEventsSupplies.stop();
			               break;
			      case 3:
			      		   randnum = num.nextInt((SurvivorArray.length-1) - 1 + 1) + 1;
			      		   if (((SurvivorArray[randnum].gethealth())==0)||(SurvivorArray[randnum].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 				
						   EventText="You hit a zombie wandering on the road. "+SurvivorArray[randnum].getname()+" hits their head on the window.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       if((SurvivorArray[randnum].gethealth()-15)<=0){
			      	       	SurvivorArray[randnum].sethealth(0);
			      	       }
			      	       else{
			      	       	SurvivorArray[randnum].subtracthealth(15);
			      	       }
			      	      if(CarHealth-5<=0){
			      	       	CarHealth=0;
			      	       }
			      	       else{
			      	       	CarHealth=CarHealth-5;
			      	       }
			      	       tm.stop();
						   tmEventsSupplies.stop();
    		 			}
			      		  
			               break;
			      case 4:  randnum = num.nextInt((SurvivorArray.length-1) - 1 + 1) + 1;
			      		   if (((SurvivorArray[randnum].gethealth())==0)||(SurvivorArray[randnum].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 				
 						   EventText=SurvivorArray[randnum].getname()+" finds money in the seat cushions";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       Supplies.addmoney(5);
			      	       tm.stop();
						   tmEventsSupplies.stop();
    		 			}
			      		  
			               break;
			      case 5:  randnum = num.nextInt((SurvivorArray.length)-1 - 1 + 1) + 1;
			      		   if (((SurvivorArray[randnum].gethealth())==0)||(SurvivorArray[randnum].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 				
 						   EventText=SurvivorArray[randnum].getname()+" gets sick";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       SurvivorArray[randnum].changestatus("Sick");
			      	       DistanceSick=DistanceTraveled+500;
			      	       tm.stop();
						   tmEventsSupplies.stop();
    		 			}
			      		  
			               break;
			      case 6:  EventText="There is no clean water nearby everyone is dehydrated.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);

			      	       for (int i = 0; i <=(SurvivorArray.length-1); i = i + 1) {
			      	       if (((SurvivorArray[i].gethealth())==0)||(SurvivorArray[i].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 				
 						SurvivorArray[i].changestatus("Dehydrated");
    		 			}
			      	      
			      	       }
			      	       DistanceDehydrated=DistanceTraveled+500;

			      	       tm.stop();
						   tmEventsSupplies.stop();
			               break;
			      case 7:
			      		   if(Supplies.getrepairkit()<=0){

			      		   }
			      		   else{
			      		   	EventText="A thief steals a repairkit.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);

			      	       Supplies.subtractrepairkit(1);
			      	       tm.stop();
						   tmEventsSupplies.stop();
			      		   }

			               break;
			      case 8:  randnum = num.nextInt((SurvivorArray.length-1) - 1 + 1) + 1;
			      		  if (((SurvivorArray[randnum].gethealth())==0)||(SurvivorArray[randnum].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 			EventText=SurvivorArray[randnum].getname()+" carelessly lets money fly out the window ";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       if(Supplies.getmoney()-12<=0){
			      	       		Supplies.setmoney(0);

			      	       }
			      	       else{
			      	       	Supplies.subtractmoney(12);
			      	       }
			      	       tm.stop();
						   tmEventsSupplies.stop();	

    		 			}
			      		   
			               break;
			      case 9: randnum = num.nextInt((SurvivorArray.length-1) - 1 + 1) + 1;
			      		   if (((SurvivorArray[randnum].gethealth())==0)||(SurvivorArray[randnum].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 			if(Supplies.getfood()>=1){

			      		   EventText=SurvivorArray[randnum].getname()+" eats more than his share of food.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       if(Supplies.getfood()-10<=0){
			      	       	Supplies.setfood(0);
			      	       }
			      	       else{
			      	       	Supplies.subtractfood(10);
			      	       }

			      	       tm.stop();
						   tmEventsSupplies.stop();
			      		   }

    		 			}
			      		   
			               break;
			      case 10: randnum = num.nextInt((SurvivorArray.length-1) - 1 + 1) + 1;
			      		   if (((SurvivorArray[randnum].gethealth())==0)||(SurvivorArray[randnum].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 			
	   						EventText=SurvivorArray[randnum].getname()+" wanders off and is never comes back.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       SurvivorArray[randnum].changestatus("Missing");
			      	       tm.stop();
						   tmEventsSupplies.stop();
    		 			}
			      	
			               break;
			      case 11: EventText="You find fresh berries to eat on a bush.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       Supplies.addfood(20);
			      	       tm.stop();
						   tmEventsSupplies.stop();
			               break;
			      case 12: EventText="You see a military vehicle abandoned on the road. You find ammo.";
			      	       new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       Supplies.addammo(25);
			      	       tm.stop();
						   tmEventsSupplies.stop();
			               break;
			      default: System.out.println("Nothing happens");
			               break;
    		 }
			//randomly chooses zombie activity
			randnum = num.nextInt(3 - 1 + 1) + 1;
					if(randnum==1){
					ZombieActivity="Low";
					}
					else if(randnum==2){
					ZombieActivity="Medium";
					}
					else if(randnum==3){
					ZombieActivity="High";
					}

			//subtreacts 3 food for each person
			 for (int w = 0; w <=(SurvivorArray.length-1); w = w + 1) {
			 	if (((SurvivorArray[w].gethealth())==0)||(SurvivorArray[w].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 				if(Supplies.getfood()-3<=0){
			 			Supplies.setfood(0);
			 		}
			 		else{
			 			Supplies.subtractfood(3);
			 		}
    		 			}	
			 	

			 	}

		


			//if persons health is less than 0 they are declared dead
    		 for (int t = 0; t <=(SurvivorArray.length-1); t = t + 1) {
    		 	if ((SurvivorArray[t].gethealth())<=0){
    		 			   EventText=(SurvivorArray[t].getname()+" has died");
    		 			   new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       SurvivorArray[t].changestatus("Deceased");
			      	       tm.stop();
						   tmEventsSupplies.stop();

    		 	}

    	 	}
			//if players health is less than zero game over
    	 	if ((SurvivorArray[0].gethealth())<=0){
    	 	EventText=("Game Over");
    		new EventScreen(EventText,this,CarHealth,CarStatus);
    	 	}


    	 		if (CarHealth<=0){
		///Car breaks down and timers stop
    	 				   CarStatus="Broken";
    		 			   EventText=("Your car has broken down. Repair it with repairkits.");
    		 			   new EventScreen(EventText,this,CarHealth,CarStatus);
			      	       tm.stop();
						   tmEventsSupplies.stop();

    		 	}
    		 	if (Supplies.getfood()==0){
    		 		//if theres no food than everyone is hungry
    	 			for (int j = 0; j <=(SurvivorArray.length-1); j = j + 1) {
    		 			if (((SurvivorArray[j].gethealth())==0)||(SurvivorArray[j].getstatus().equals("Missing"))){
    		 			}
    		 			else {
    		 				SurvivorArray[j].changestatus("Hungry");

    		 			}

    		 		}
    		 	}

				//if everyone is dyhydrated when the random event is called
  				for (int a = 0; a <=(SurvivorArray.length-1); a = a + 1) {
    		 		if (((SurvivorArray[a].getstatus()).equals("Dehydrated"))&&(DistanceTraveled>=DistanceDehydrated)){
    		 			SurvivorArray[a].changestatus("Normal");
    		 		}
    		 		else if (((SurvivorArray[a].getstatus()).equals("Dehydrated"))&&(DistanceTraveled<=DistanceDehydrated-1)){
    		 			   SurvivorArray[a].subtracthealth(5);
    		 		}
    		 		else if (((SurvivorArray[a].getstatus()).equals("Sick"))&&(DistanceTraveled>=DistanceSick)){
    		 			SurvivorArray[a].changestatus("Normal");
    		 		}
    		 		else if (((SurvivorArray[a].getstatus()).equals("Sick"))&&(DistanceTraveled<=DistanceSick-1)){
    		 			   SurvivorArray[a].subtracthealth(5);
  					}
  					else if (((SurvivorArray[a].getstatus()).equals("Hungry"))){
    		 			   SurvivorArray[a].subtracthealth(10);
  					}
    		}


	}
    }

	public void Traveling (){
			 //checks if thiers food
			 for (int p = 0; p <=(SurvivorArray.length-1); p = p + 1) {
			 	//if food is greater than 0 then everyone is not hungry
			 		if((Supplies.getfood()>=1)&&(SurvivorArray[p].getstatus().equals("Hungry"))){
			 			SurvivorArray[p].changestatus("Normal");
			 		}

			 	}

//traveling updates the supplies label
  		lblFuel.setText(" Fuel: "+Supplies.getfuel());
        lblFood.setText(" Food: "+Supplies.getfood());
       	lblMoney.setText(" Money: "+Supplies.getmoney());
        lblAmmo.setText(" Ammo: "+Supplies.getammo());
       	lblRepairKit.setText(" RepairKit: "+Supplies.getrepairkit());


	///updates the player and cars health and status
  		lblPlayerHealth.setText(SurvivorArray[0].getname()+" Health: "+SurvivorArray[0].gethealth()+" Status: "+SurvivorArray[0].getstatus());
  		lblFriend1Health.setText(SurvivorArray[1].getname()+" Health: "+SurvivorArray[1].gethealth()+" Status: "+SurvivorArray[1].getstatus());
  		lblFriend2Health.setText(SurvivorArray[2].getname()+" Health: "+SurvivorArray[2].gethealth()+" Status: "+SurvivorArray[2].getstatus());
  		lblFriend3Health.setText(SurvivorArray[3].getname()+" Health: "+SurvivorArray[3].gethealth()+" Status: "+SurvivorArray[3].getstatus());
		lblCarHealth.setText("Car Health: "+CarHealth+" Status: "+CarStatus);
		lblZombieActivity.setText("ZombieActivity: "+ZombieActivity);

	if ((DistancePlace)==0){//if the distance to place is 0 then the timers stop and the place screen is opened
		new Place(Supplies,CarHealth,CarStatus,this,place);
		tm.stop();
		tmEventsSupplies.stop();


	}
	else{
	//Distance traveled increases
		DistanceTraveled=DistanceTraveled+1;
		lblDistanceTraveled.setText("Distance Traveled: "+DistanceTraveled+" miles");
	//Distance to place decreases
		DistancePlace=DistancePlace-1;
		lblDistancePlace.setText("Distance to next place: "+DistancePlace+" miles");
	}





	}
		public void BackFromEvent (int CarH,String CarS){
		//when the stop screen closes the traveling screen starts up
		CarHealth=CarH;
		CarStatus=CarS;
		if (CarStatus.equals("Normal")){
		tm.start();
		tmEventsSupplies.start();
		}
		

	}
	public void BackFromStop (int CarH,String CarS,Supplies suprec){
		//when the stop screen closes the traveling screen starts up
		CarHealth=CarH;
		CarStatus=CarS;
		Supplies=suprec;
		if (CarStatus.equals("Normal")){
		tm.start();
		tmEventsSupplies.start();
		}
	}
		
		public void BackFromStop2 (){
			//when the stop screen closes the traveling screen starts up
			if (CarStatus.equals("Normal")){
			tm.start();
			tmEventsSupplies.start();
			}
		
	}
	public void SetPlaceDistance (int amount){
	//Place distance is set here if youre at city 4 then you win
		place=place+1;
		DistancePlace=DistancePlace+amount;
		if (place==4){
			String	EventText=("You Win");
			
    		new EventScreen(EventText,this,CarHealth,CarStatus);
    		
		}

	}

}