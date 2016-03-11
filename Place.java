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
//Place is where the store and garage are located appears after certain distances are travelled
public class Place extends JFrame implements ActionListener{

	int carhealth,Place,RepairKitsPrice,FuelPrice,FoodPrice,AmmoPrice,GaragePrice;

	String carstatus;//carstatus is made
	Supplies Supplies;//supplies object is made
	TravelScreen TScreen; //travelscreen
    JLabel lblGaragePrice;//Garage price to get vehicle repaired is made
    //labels and buttonsmade for store and garage
    JLabel lblTitle,lblRepairKits,lblFuel,lblFood,lblMyMoneyStore,lblMyMoneyGarage,lblAmmo,lblRepairKitsPrice,lblFuelPrice,lblFoodPrice,lblAmmoPrice,lblStoreImage,lblGarageImage,lblPlaceImage,lblCar,lblgaragePrice;
    JButton btnStore,btnGarage,btnDrive,btnBuyRepairs,btnBuyFuel,btnBuyFood,btnBuyAmmo,btnBuyRepairKits;

		//panels created
		JPanel panel = new JPanel (new BorderLayout());
		JPanel panelImage = new JPanel ();

		JPanel StoreLeft = new JPanel(new GridLayout(4,2));
        JPanel StoreRight = new JPanel(new GridLayout(6,1));
        JPanel Store = new JPanel(new GridLayout(1,2));

        JPanel GarageLeft = new JPanel(new GridLayout(2,1));
		JPanel GarageRight = new JPanel(new GridLayout(3,1));
		JPanel Garage = new JPanel(new GridLayout(1,2));

        JPanel north = new JPanel();
        JPanel center = new JPanel(new CardLayout());
        JPanel south = new JPanel();
		JFrame frame = new JFrame("Place"); //creates a new frame titled "Sandwich Order"

    public Place(Supplies supplies,int CARHEALTH,String CARSTATUS,TravelScreen travelscreen,int placerec) {
		//Instance variables set
    	Supplies=supplies;
    	carhealth=CARHEALTH;
    	carstatus=CARSTATUS;
    	TScreen=travelscreen;
		Place=placerec;

		GaragePrice=30;
		RepairKitsPrice=12;
		FuelPrice=5;
		FoodPrice=10;
		AmmoPrice=4;

		// Create objects

		lblRepairKits= new JLabel("My RepairKits: "+Supplies.getrepairkit());
		lblFuel= new JLabel("My Fuel: "+Supplies.getfuel());
		lblFood= new JLabel("My Food: "+Supplies.getfood());
		lblAmmo= new JLabel("My Ammo: "+Supplies.getammo());
		lblRepairKitsPrice= new JLabel("1 RepairKit: $"+RepairKitsPrice);
		lblFuelPrice= new JLabel("1 Fuel: $"+FuelPrice);
		lblFoodPrice= new JLabel("15 Food: $"+FoodPrice);
		lblAmmoPrice= new JLabel("5 Ammo: $"+AmmoPrice);
		lblMyMoneyStore= new JLabel("My Money: "+Supplies.getmoney());
		lblMyMoneyGarage= new JLabel("My Money: "+Supplies.getmoney());
		lblGaragePrice= new JLabel("Repair Costs: $"+GaragePrice);
		lblCar= new JLabel("Car Health: "+carhealth+" Status: "+carstatus);
		lblTitle= new JLabel("City"+Place);
		if (Place==1){//if place is 1 then it will show city 1 image
		lblPlaceImage = new JLabel(new ImageIcon("City1.JPG"));
		}
		else if(Place==2){//if place is 2 then it will show city 2 image
		lblPlaceImage = new JLabel(new ImageIcon("City2.JPG"));
		}
		else if(Place==3){//if place is 3 then it will show city 3 image
		lblPlaceImage = new JLabel(new ImageIcon("City3.JPG"));
		}



		//buttons created
        btnStore = new JButton ("Store");
	    btnGarage = new JButton ("Garage");
 	    btnDrive = new JButton ("Drive");
 	    btnBuyRepairs = new JButton ("Buy Repairs");
	    btnBuyFuel = new JButton ("Buy Fuel");
 	    btnBuyFood = new JButton ("Buy Food");
 	    btnBuyAmmo = new JButton ("Buy Ammo");
	    btnBuyRepairKits = new JButton ("Buy RepairKit");


		//labels and buttons added to appropriate panels
		north.add(lblTitle);

		panelImage.add(lblPlaceImage);

		StoreLeft.add(lblFuelPrice);
		StoreLeft.add(btnBuyFuel);
		StoreLeft.add(lblFoodPrice);
		StoreLeft.add(btnBuyFood);
		StoreLeft.add(lblAmmoPrice);
		StoreLeft.add(btnBuyAmmo);
		StoreLeft.add(lblRepairKitsPrice);
		StoreLeft.add(btnBuyRepairKits);


		StoreRight.add(lblMyMoneyStore);
		StoreRight.add(lblFuel);
		StoreRight.add(lblFood);
		StoreRight.add(lblAmmo);
		StoreRight.add(lblRepairKits);

		Store.add(StoreLeft);
		Store.add(StoreRight);

		GarageLeft.add(lblGaragePrice);
		GarageLeft.add(btnBuyRepairs);


		GarageRight.add(lblCar);
		GarageRight.add(lblMyMoneyGarage);


		Garage.add(GarageLeft);
		Garage.add(GarageRight);

		//Panels added to the center card layout
		center.add(panelImage,"Place");
		center.add(Store,"Store");
		center.add(Garage,"Garage");

		//buttons added to the south panel
		south.add(btnStore);
		south.add(btnGarage);
		south.add(btnDrive);

		//panels added to main panel
		panel.add(north, BorderLayout.NORTH);
        panel.add(center, BorderLayout.CENTER);
        panel.add(south, BorderLayout.SOUTH);

        //creates action listeners for done button to detect when it has been clicked
		btnStore.addActionListener (this);
		btnGarage.addActionListener (this);
		btnBuyRepairs.addActionListener (this);
		btnBuyFuel.addActionListener (this);
		btnBuyFood.addActionListener (this);
		btnBuyAmmo.addActionListener (this);
		btnBuyRepairKits.addActionListener (this);
		btnDrive.addActionListener (this);



    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 280, 200);
        frame.setSize(500,400); //sets size of the frame
        frame.getContentPane().add(panel); //adds the panel to the frame
        frame.setVisible(true);
    }

 public void actionPerformed (ActionEvent e)
    {
    	CardLayout cl = (CardLayout)(center.getLayout());//cardlayout changer made

		if (e.getSource () == btnStore){//if the store button is clicked then money label is set and the panel changes to store panel

		lblTitle.setText("Store");
		lblMyMoneyStore.setText("My Money: "+Supplies.getmoney());
		cl.show(center, ("Store"));
		}
		else if (e.getSource () == btnGarage){//if garage button is clicked then the money label is set and panel changes to garage

	   	lblTitle.setText("Garage");
	   	lblMyMoneyGarage.setText("My Money: "+Supplies.getmoney());
		cl.show(center, ("Garage"));



		}

		else if (e.getSource () == btnDrive){//If the drive button is clicked then
			TScreen.SetPlaceDistance(Place*1000);//place distance is set to the place times 100
			TScreen.BackFromStop (carhealth,carstatus,Supplies);//tells travel screen its returned from stop
			frame.dispose();//frame closes

		}
		else if (e.getSource () == btnBuyFuel){//When buy fuel is clicked it adds fuel to supplies and subtracts money
			if (Supplies.getmoney()<FuelPrice){

			}
			else{
			Supplies.subtractmoney(FuelPrice);
			Supplies.addfuel(1);
			}
		lblFuel.setText("My Fuel: "+Supplies.getfuel());
		lblMyMoneyStore.setText("My Money: "+Supplies.getmoney());
		}


		else if (e.getSource () == btnBuyFood){//When buy food is clicked it adds food to supplies and subtracts money
			if (Supplies.getmoney()<FoodPrice){

			}
			else{
			Supplies.subtractmoney(FoodPrice);
			Supplies.addfood(5);
			}
		lblFood.setText("My Food: "+Supplies.getfood());
		lblMyMoneyStore.setText("My Money: "+Supplies.getmoney());
		}


		else if (e.getSource () == btnBuyAmmo){//When buy ammo is clicked it adds ammo to supplies and subtracts money
			if (Supplies.getmoney()<AmmoPrice){

			}
			else{
			Supplies.subtractmoney(AmmoPrice);
			Supplies.addammo(5);
			}
		lblAmmo.setText("My Ammo: "+Supplies.getammo());
		lblMyMoneyStore.setText("My Money: "+Supplies.getmoney());
		}


		else if (e.getSource () == btnBuyRepairKits){//When buy repairkits is clicked it adds repairkits to supplies and subtracts money
			if (Supplies.getmoney()<RepairKitsPrice){

			}
			else{
			Supplies.subtractmoney(RepairKitsPrice);
			Supplies.addrepairkit(1);
			lblMyMoneyStore.setText("My Money: "+Supplies.getmoney());

		    }
		lblRepairKits.setText("My RepairKits: "+Supplies.getrepairkit());
		}

		else if (e.getSource () == btnBuyRepairs){//Garage repairs button is pressed
			//Checks to see if car can be repaired or can be affored then sets accordingly
			if((Supplies.getmoney()<=0)||(Supplies.getmoney()-GaragePrice<=0)||(carhealth==100)){

			}
			else{

					if(carhealth+50>=100){
						carhealth=100;
						carstatus="Normal";

					}
					else{
						carhealth=carhealth+50;
						carstatus="Normal";
					}
				Supplies.subtractmoney(GaragePrice);
				lblMyMoneyGarage.setText("My Money: "+Supplies.getmoney());
				lblCar.setText("Car Health: "+carhealth+" Status: "+carstatus);
				lblMyMoneyStore.setText("My Money: "+Supplies.getmoney());

			}



		}

    }

}