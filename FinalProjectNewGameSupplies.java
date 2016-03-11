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

public class FinalProjectNewGameSupplies extends JFrame implements ActionListener  {

String carstatus="Normal";// carstatus variable is made and set to normal
int carhealth=100;//car health is made and set to 100
Survivor[] survivorarray = new Survivor[4];//survivor array made to recieve the array being passed
Supplies Supplies1;//Supplies object made
//supplies variables made
int Fuel=0;
int Food=0;
int Money=0;
int Ammo=0;
int RepairKit=0;
int Points=15;//points to spend
JLabel lblPoints,lblFuel, lblFood,lblMoney,lblAmmo,lblRepairKit;//labels made
JButton btnUpFuel,btnDownFuel,btnUpFood,btnDownFood,btnUpMoney,btnDownMoney,btnUpAmmo,btnDownAmmo,btnUpRepairKit,btnDownRepairKit,btnNext2;//buttons made

    public FinalProjectNewGameSupplies(Survivor[] SurvivorArray) {
	//instance variable set
    survivorarray=SurvivorArray;


    JFrame frame1 = new JFrame("Supplies"); //creates a new frame titled "Supplies"
    	//panels created
    	JPanel Mainpanel = new JPanel (new BorderLayout());
    	JPanel options = new JPanel (new GridLayout(6,2));
    	JPanel panelPoints = new JPanel() ;
    	JPanel panelFuel = new JPanel ();
        JPanel panelFuelControl = new JPanel(new GridLayout(1,2));
        JPanel panelFood = new JPanel();
        JPanel panelFoodControl = new JPanel(new GridLayout(1,2));
        JPanel panelMoney = new JPanel();
        JPanel panelMoneyControl = new JPanel(new GridLayout(1,2));
        JPanel panelAmmo = new JPanel();
        JPanel panelAmmoControl = new JPanel(new GridLayout(1,2));
        JPanel panelRepairKit = new JPanel();
        JPanel panelRepairKitControl = new JPanel(new GridLayout(1,2));
        JPanel panelNext = new JPanel();
	//buttons created
		btnUpFuel = new JButton ("+");
		btnDownFuel = new JButton ("-");
		btnUpFood = new JButton ("+");
		btnDownFood = new JButton ("-");
		btnUpMoney = new JButton ("+");
		btnDownMoney = new JButton ("-");
		btnUpAmmo = new JButton ("+");
		btnDownAmmo = new JButton ("-");
		btnUpRepairKit = new JButton ("+");
		btnDownRepairKit = new JButton ("-");
		btnNext2 = new JButton ("Next");

//labels created
		lblPoints = new JLabel ("Points:"+Points,JLabel.CENTER);
		lblFuel = new JLabel ("FUEL:"+Fuel,JLabel.CENTER);
		lblFood = new JLabel ("FOOD:"+Food,JLabel.CENTER);
		lblMoney = new JLabel ("MONEY:"+Money,JLabel.CENTER);
		lblAmmo = new JLabel ("AMMO:"+Ammo,JLabel.CENTER);
		lblRepairKit = new JLabel ("REPAIR KIT:"+RepairKit,JLabel.CENTER);

//Stuff is added to panels
        panelPoints.add(lblPoints);
		panelFuel.add(lblFuel);
		panelFuelControl.add(btnUpFuel);
		panelFuelControl.add(btnDownFuel);
		panelFood.add(lblFood);
		panelFoodControl.add(btnUpFood);
		panelFoodControl.add(btnDownFood);
		panelMoney.add(lblMoney);
		panelMoneyControl.add(btnUpMoney);
		panelMoneyControl.add(btnDownMoney);
		panelAmmo.add(lblAmmo);
		panelAmmoControl.add(btnUpAmmo);
		panelAmmoControl.add(btnDownAmmo);
		panelRepairKit.add(lblRepairKit);
		panelRepairKitControl.add(btnUpRepairKit);
		panelRepairKitControl.add(btnDownRepairKit);

//panels are added to option panel
		options.add(panelFuel);
		options.add(panelFuelControl);
		options.add(panelFood);
		options.add(panelFoodControl);
		options.add(panelMoney);
		options.add(panelMoneyControl);
		options.add(panelAmmo);
		options.add(panelAmmoControl);
		options.add(panelRepairKit);
		options.add(panelRepairKitControl);

		panelNext.add(btnNext2);//next button is added

		//panels added to main panel
		Mainpanel.add(panelPoints, BorderLayout.NORTH);
        Mainpanel.add(options, BorderLayout.CENTER);
        Mainpanel.add(panelNext, BorderLayout.SOUTH);

        //creates action listeners for buttons to detect when theyve been clicked
		btnNext2.addActionListener (this);
		btnUpFuel.addActionListener (this);
		btnDownFuel.addActionListener (this);
		btnUpFood.addActionListener (this);
		btnDownFood.addActionListener (this);
		btnUpMoney.addActionListener (this);
		btnDownMoney.addActionListener (this);
		btnUpAmmo.addActionListener (this);
		btnDownAmmo.addActionListener (this);
		btnUpRepairKit.addActionListener (this);
		btnDownRepairKit.addActionListener (this);


    	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame1.setBounds (400, 100, 280, 200);
        frame1.setSize(600,500); //sets size of the frame
        frame1.getContentPane().add(Mainpanel); //adds the panel to the frame
        frame1.setVisible(true);

    }
    	 public void actionPerformed (ActionEvent e)
    {
		if (e.getSource () == btnNext2){//if next button is clicked
		//Supplies are mutiplied accordingly
		Fuel=Fuel*3;
		Food=Food*10;
		Money=Money*8;
		Ammo=Ammo*5;
		RepairKit=RepairKit*1;
		Supplies1=new Supplies( Fuel, Food, Money, Ammo, RepairKit);//supplies are put into supplies object
		int DisTraveled=0;//distance travelled is set to 0
		int DisPlace=500; //distance to first place is set to 500
		new TravelScreen(survivorarray, carhealth, carstatus, Supplies1,DisTraveled,DisPlace,"Low",1);//travel screen is called
		this.dispose();

		}
		//Buttons to increase supply selected and subtract point and to subtract supply and increase apoint
		else if (e.getSource () == btnUpFuel){
			if (Points >= 1){
				Fuel=Fuel+1;
				lblFuel.setText("FUEL:"+Fuel);
				Points=Points-1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnDownFuel){
			if ((Points <= 14)&&(Fuel>=1)){
				Fuel=Fuel-1;
				lblFuel.setText("FUEL:"+Fuel);
				Points=Points+1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnUpFood){
			if (Points >= 1){
				Food=Food+1;
				lblFood.setText("FOOD:"+Food);
				Points=Points-1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnDownFood){
			if ((Points <= 14)&&(Food>=1)){
				Food=Food-1;
				lblFood.setText("FOOD:"+Food);
				Points=Points+1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnUpMoney){
			if (Points >= 1){
				Money=Money+1;
				lblMoney.setText("MONEY:"+Money);
				Points=Points-1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnDownMoney){
			if ((Points <= 14)&&(Money>=1)){
				Money=Money-1;
				lblMoney.setText("MONEY:"+Money);
				Points=Points+1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnUpAmmo){
			if (Points >= 1){
				Ammo=Ammo+1;
				lblAmmo.setText("AMMO:"+Ammo);
				Points=Points-1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnDownAmmo){
			if ((Points <= 14)&&(Ammo>=1)){
				Ammo=Ammo-1;
				lblAmmo.setText("AMMO:"+Ammo);
				Points=Points+1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}


		}
		else if (e.getSource () == btnUpRepairKit){
			if (Points > 0){
				RepairKit=RepairKit+1;
				lblRepairKit.setText("REPAIRKIT:"+RepairKit);
				Points=Points-1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
		else if (e.getSource () == btnDownRepairKit){
			if ((Points <= 14)&&(RepairKit>=1)){
				RepairKit=RepairKit-1;
				lblRepairKit.setText("REPAIRKIT:"+RepairKit);
				Points=Points+1;
				lblPoints.setText("Points:"+Points);
			}
			else{
			}

		}
    }

}