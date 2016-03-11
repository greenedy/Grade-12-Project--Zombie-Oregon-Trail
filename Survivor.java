import java.util.Scanner;

public class Survivor {
  private String name,status;//variables made for the survivors's name and health
  private int health;

    public Survivor(String Name,int Health,String Status ) {
    	name=Name;
    	health=Health;
    	status=Status;

    }
	 //returns the name
	 public String getname () {
     return this.name;
  }
  //sets the name
  public void setname (String Name) {
     name=Name;
  }
 //returns the health
  public int gethealth () {
     return this.health;
  }
 //return the status
   public String getstatus () {
     return this.status;
  }
  //sets the health to certain value
  public void sethealth (int amount) {
    health=amount;
  }
  //adds on to health
  public void addhealth (int amount) {
    health=health+amount;
  }
  //subtracts from health
  public void subtracthealth (int amount) {
    health=health-amount;
  }
 //changes the status
   public void changestatus (String StatusChange) {
     status=StatusChange;
  }



}