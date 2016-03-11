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
//this load game will retrieve info from file indicated from user

public class LoadGame extends JFrame implements ActionListener  {
		Survivor[] SurvivorArray=new Survivor[4];//Survivor array is made
		Supplies Supplies;//supplies object is made
		int CarHealth,DistanceTraveled,DistancePlace,Place;//int variables made
		String CarStatus,ZombieActivity,filename;//string variables made

		JLabel lblFileFound,lblTypeName;//labels made
    	JTextField txtName;//textfieldmade
    	JButton btnSearch, btnLoad,btnMainMenu;//buttons made
    	String Name;

    	JFrame frame = new JFrame("Load Game"); //creates a new frame titled "Load Game"

		//panel made
		JPanel options = new JPanel (new GridLayout(6,1));



    public LoadGame() {
    	//labels and buttons created
    	lblFileFound= new JLabel("----",JLabel.CENTER);
		lblTypeName=new JLabel("Type name to search for saved game:");
		txtName = new JTextField (12);
		btnSearch = new JButton("Search");
		btnLoad = new JButton("Load");
		btnMainMenu = new JButton("MainMenu");


       	//labels and buttons added tothe panel
       	options.add(lblTypeName);
       	options.add(txtName);
       	options.add(lblFileFound);
       	options.add(btnSearch);
       	options.add(btnLoad);
		options.add(btnMainMenu);

		 //creates action listeners for  buttons to detect when it they have been clicked
		btnSearch.addActionListener (this);
		btnLoad.addActionListener (this);
		btnMainMenu.addActionListener (this);



    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // is required to make sure that the program actually ends when the 'X' button is pressed.
        //makes the frame 300 pixels wide by 250 pixels high, and located 400 by 100 pixels from the top left corner of the screen.
        frame.setBounds (400, 100, 280, 200);
        frame.setSize(500,400); //sets size of the frame
        frame.getContentPane().add(options); //adds the panel to the frame
        frame.setVisible(true);


    }
    	public void actionPerformed (ActionEvent e)
    {

		if (e.getSource () == btnSearch){//the search button has been clicked

			if (txtName.getText().equals("")){//checks if name has been inputted
				lblFileFound.setText("Please insert a name");
			}
			else{
				//if name has been inputted it is retieved
				Name=txtName.getText();
				Scanner fileScan = null;//filescanner is made

      			boolean found = true; //setting true, assume file exists

		      try {//tries searching for file indictaed

		         fileScan = new Scanner(new File(Name+".dat"));
		      }
		      catch (FileNotFoundException exception) {
		         lblFileFound.setText("No saved game found.");
		         found = false;
		      }

		      // will run as long as file exists and the exception did not run
		      if (found == true){
		      	lblFileFound.setText("Saved game found.");
		         // Read and process each line of the file

		         while (fileScan.hasNext()) { //checks to see if another line exists to read
					//survivors are made to the survivor array from info from txt file
					SurvivorArray[0] = new Survivor((fileScan.nextLine()),(Integer.parseInt(fileScan.nextLine())),(fileScan.nextLine()));
			     	SurvivorArray[1] = new Survivor((fileScan.nextLine()),(Integer.parseInt(fileScan.nextLine())),(fileScan.nextLine()));
			        SurvivorArray[2] = new Survivor((fileScan.nextLine()),(Integer.parseInt(fileScan.nextLine())),(fileScan.nextLine()));
			        SurvivorArray[3] = new Survivor((fileScan.nextLine()),(Integer.parseInt(fileScan.nextLine())),(fileScan.nextLine()));

					//carhealth and carstatus is retrieved from file
			         CarHealth=(Integer.parseInt(fileScan.nextLine()));
			         CarStatus=fileScan.nextLine();

			         //supplies object made with info from text file
			         Supplies=new Supplies( (Integer.parseInt(fileScan.nextLine())), (Integer.parseInt(fileScan.nextLine())), (Integer.parseInt(fileScan.nextLine())), (Integer.parseInt(fileScan.nextLine())), (Integer.parseInt(fileScan.nextLine())));

			        //Other info retrieved from text file
			         ZombieActivity=fileScan.nextLine();
			         DistanceTraveled=Integer.parseInt(fileScan.nextLine());
			         DistancePlace=Integer.parseInt(fileScan.nextLine());
			         Place=Integer.parseInt(fileScan.nextLine());







         }
      }
    }


			}

		if (e.getSource () == btnLoad){//if load button is clicked the travelscreen is made with all info collected from file

			new TravelScreen(SurvivorArray, CarHealth, CarStatus, Supplies,DistanceTraveled,DistancePlace,ZombieActivity,Place);
			this.dispose();//load screen closses
			}




			if (e.getSource () == btnMainMenu){//Main menu button is clicked main menu is opened

			new FinalProject3();
			this.dispose();//loadscreen closses
			}




		}

    }











