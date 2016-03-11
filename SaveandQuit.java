
import java.util.Random;
import java.io.*;
//Will write to a text file to save game info

public class SaveandQuit {

Survivor[] SurvivorArray=new Survivor[3];//survivor array is made
Supplies Supplies; //supplies object is made
int CarHealth,DistanceTraveled,DistancePlace,Place;//int variables made
String CarStatus,ZombieActivity,filename;// string variables made



    public SaveandQuit(Survivor[] survivorarrayrec,Supplies suppliesrec,int carhealthrec,String carstatusrec,String zombieactivityrec,int distancetraveledrec,int distanceplacerec,int placerec)throws IOException  {
    	//Info is collected and set to instance variables
    	SurvivorArray=survivorarrayrec;
	    Supplies=suppliesrec;
	    CarHealth=carhealthrec;
	    CarStatus=carstatusrec;
	    ZombieActivity=zombieactivityrec;
	    DistanceTraveled=distancetraveledrec;
	    DistancePlace=distanceplacerec;
	    Place=placerec;
		filename=SurvivorArray[0].getname();//the file name is set to the player name

      String file =( filename+".dat");//file text is created



      //Represents a text output file, but has minimal method support for manipulating data
      FileWriter fw = new FileWriter(file);

      //Not required, gives output stream buffering capabilities, makes more efficient (good practice)
      BufferedWriter bw = new BufferedWriter(fw);

      //Provides print and println methods similar to the standard I/O PrintStream class
      PrintWriter outFile = new PrintWriter(bw);

         for (int i = 0; i <=(SurvivorArray.length-1); i = i + 1) {//outputs each survivors name health and status
         outFile.println(SurvivorArray[i].getname());
         outFile.println(SurvivorArray[i].gethealth());
         outFile.println(SurvivorArray[i].getstatus());
         }

         outFile.println(CarHealth);//Car health and status are put in the file
         outFile.println(CarStatus);//

         //supplies are added to the file
         outFile.println(Supplies.getfuel());
         outFile.println(Supplies.getfood());
         outFile.println(Supplies.getmoney());
         outFile.println(Supplies.getammo());
         outFile.println(Supplies.getrepairkit());

         //zombieactivty distance travelled, distance to next place and which place is added to file
         outFile.println(ZombieActivity);
         outFile.println(DistanceTraveled);
         outFile.println(DistancePlace);
         outFile.println(Place);



      outFile.close();//close the file
      System.out.println ("Game has been saved.");
      new FinalProject3();//Returns to main menu
      }


}