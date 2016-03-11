import java.util.Scanner;
public class Supplies {

  //Variables made for each supply
  private int fuel;
  private int food;
  private int money;
  private int ammo;
  private int repairkit;

    public Supplies(int Fuel,int Food,int Money,int Ammo,int RepairKit) {
    	//Instance varirables given values
    	fuel=Fuel;
    	food=Food;
    	money=Money;
    	ammo=Ammo;
    	repairkit=RepairKit;
    }
//--------------------------------------------
  //returns the fuel
  public int getfuel () {
     return this.fuel;
  }
 //returns the food
  public int getfood () {
     return this.food;
  }
 //returns the money
   public int getmoney () {
     return this.money;
  }
 //returns the ammo
   public int getammo () {
     return this.ammo;
  }
 //returns the repairkits
   public int getrepairkit () {
     return this.repairkit;
  }
//--------------------------------------------
//adds certain amount of fuel
  public void addfuel (int amount) {
      fuel=fuel+amount;
  }
  //adds certain amount of food
  public void addfood (int amount) {
      food=food+amount;
  }
  //adds certain amount of money
  public void addmoney (int amount) {
      money=money+amount;
  }
  //adds certain amount of ammo
  public void addammo (int amount) {
      ammo=ammo+amount;
  }
  //adds certain amount of repairkits
  public void addrepairkit (int amount) {
      repairkit=repairkit+amount;
  }
  //--------------------------------------------
  //subtracts certain amount of fuel
  public void subtractfuel (int amount) {
      fuel=fuel-amount;
  }
  //subtracts certain amount of food
  public void subtractfood (int amount) {
      food=food-amount;
  }
  //subtracts certain amount of money
  public void subtractmoney (int amount) {
      money=money-amount;
  }
  //subtracts certain amount of ammo
  public void subtractammo (int amount) {
      ammo=ammo-amount;
  }
  //subtracts certain amount of repairkits
  public void subtractrepairkit (int amount) {
      repairkit=repairkit-amount;
  }
  	//-------------------------------------
 //Set supplies to ceratin value
   public void setfuel (int amount) {
      fuel=amount;
  }
  //set certain amount of food
  public void setfood (int amount) {
      food=amount;
  }
  //set certain amount of money
  public void setmoney (int amount) {
      money=amount;
  }
  //sets certain amount of ammo
  public void setammo (int amount) {
      ammo=amount;
  }
  //sets certain amount of repairkits
  public void setrepairkit (int amount) {
      repairkit=amount;
  }
}