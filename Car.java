//*****************************************************************************
//  Represents the background and car movement
//*****************************************************************************
import java.io.* ;
import java.awt.*;


public class Car
{
//Variables made x and y
   private int x,y;


   public Car(){//car starting position
	x=0;
	y=150;

   }


   //--------------------------------------------------------------------------
   //  Sets the light of the traffic light.
   //--------------------------------------------------------------------------
   public void toggleLight(int screenWidth)
   {

   	if (x==screenWidth){
   	x=0;//if the trees rech the screen width x is set back to 0
   	}
   	else{
   	x=x+10;// x increases by 10 if its not at the screen width
   	}

   }

   //--------------------------------------------------------------------------
   //  Draws the Lights in the specified graphics context.
   //--------------------------------------------------------------------------
   public void draw(Graphics gc, int screenWidth)
   {




	//
   	int[] xPointsTreeBack1 ={x-20,x-40,x-60,x-20};
   	int[] yPointsTreeBack1 ={120,25,120,120};
   	int[] xPointsTreeBack2 ={x-80,x-100,x-120,x-80};
   	int[] yPointsTreeBack2 ={120,25,120,120};
   	int[] xPointsTreeBack3 ={x-140,x-160,x-180,x-140};
   	int[] yPointsTreeBack3 ={120,25,120,120};
   	int[] xPointsTreeBack4 ={x-200,x-220,x-240,x-200};
   	int[] yPointsTreeBack4 ={120,25,120,120};
   	int[] xPointsTreeBack5 ={x-260,x-280,x-300,x-260};
   	int[] yPointsTreeBack5 ={120,25,120,120};
   	int[] xPointsTreeBack6 ={x-320,x-340,x-360,x-320};
   	int[] yPointsTreeBack6 ={120,25,120,120};
   	int[] xPointsTreeBack7 ={x-380,x-400,x-420,x-380};
   	int[] yPointsTreeBack7 ={120,25,120,120};
   	int[] xPointsTreeBack8 ={x-440,x-460,x-480,x-440};
   	int[] yPointsTreeBack8 ={120,25,120,120};
   	int[] xPointsTreeBack9 ={x-500,x-520,x-540,x-500};
   	int[] yPointsTreeBack9 ={120,25,120,120};


   	int[] xPointsTree1 ={x,x+20,x+40,x};
   	int[] yPointsTree1 ={120,25,120,120};
   	int[] xPointsTree2 ={x+60,x+80,x+100,x+60};
   	int[] yPointsTree2 ={120,25,120,120};
   	int[] xPointsTree3 ={x+120,x+140,x+160,x+120};
   	int[] yPointsTree3 ={120,25,120,120};
   	int[] xPointsTree4 ={x+180,x+200,x+220,x+180};
   	int[] yPointsTree4 ={120,25,120,120};
   	int[] xPointsTree5 ={x+240,x+260,x+280,x+240};
   	int[] yPointsTree5 ={120,25,120,120};
   	int[] xPointsTree6 ={x+300,x+320,x+340,x+300};
   	int[] yPointsTree6 ={120,25,120,120};
   	int[] xPointsTree7 ={x+360,x+380,x+400,x+360};
   	int[] yPointsTree7 ={120,25,120,120};
   	int[] xPointsTree8 ={x+420,x+440,x+460,x+420};
   	int[] yPointsTree8 ={120,25,120,120};

	  //Draws box
 	  gc.setColor(Color.green);
 	  gc.fillPolygon(xPointsTree1,yPointsTree1,4);
 	  gc.fillPolygon(xPointsTree2,yPointsTree2,4);
 	  gc.fillPolygon(xPointsTree3,yPointsTree3,4);
 	  gc.fillPolygon(xPointsTree4,yPointsTree4,4);
 	  gc.fillPolygon(xPointsTree5,yPointsTree5,4);
 	  gc.fillPolygon(xPointsTree6,yPointsTree6,4);
 	  gc.fillPolygon(xPointsTree7,yPointsTree7,4);
 	  gc.fillPolygon(xPointsTree8,yPointsTree8,4);

 	  gc.fillPolygon(xPointsTreeBack1,yPointsTreeBack1,4);
 	  gc.fillPolygon(xPointsTreeBack2,yPointsTreeBack2,4);
 	  gc.fillPolygon(xPointsTreeBack3,yPointsTreeBack3,4);
 	  gc.fillPolygon(xPointsTreeBack4,yPointsTreeBack4,4);
 	  gc.fillPolygon(xPointsTreeBack5,yPointsTreeBack5,4);
 	  gc.fillPolygon(xPointsTreeBack6,yPointsTreeBack6,4);
 	  gc.fillPolygon(xPointsTreeBack7,yPointsTreeBack7,4);
 	  gc.fillPolygon(xPointsTreeBack8,yPointsTreeBack8,4);
 	  gc.fillPolygon(xPointsTreeBack9,yPointsTreeBack9,4);

 	  gc.setColor(Color.darkGray);
 	  gc.fillRect(x+18, 120,5,10);
 	  gc.fillRect(x+78, 120,5,10);
 	  gc.fillRect(x+138, 120,5,10);
 	  gc.fillRect(x+198, 120,5,10);
 	  gc.fillRect(x+258, 120,5,10);
 	  gc.fillRect(x+318, 120,5,10);
 	  gc.fillRect(x+378, 120,5,10);
 	  gc.fillRect(x+438, 120,5,10);

 	  gc.fillRect(x-42, 120,5,10);
 	  gc.fillRect(x-102, 120,5,10);
 	  gc.fillRect(x-162, 120,5,10);
 	  gc.fillRect(x-222, 120,5,10);
 	  gc.fillRect(x-282, 120,5,10);
 	  gc.fillRect(x-342, 120,5,10);
 	  gc.fillRect(x-402, 120,5,10);
 	  gc.fillRect(x-462, 120,5,10);


 	  gc.setColor(Color.gray);
 	  gc.fillRect(0, 135,480,140);

	  gc.setColor(Color.yellow);
	  gc.fillRect(x-100, 200,75,5);
	  gc.fillRect(x-200, 200,75,5);
	  gc.fillRect(x-300, 200,75,5);
	  gc.fillRect(x-400, 200,75,5);
	  gc.fillRect(x-500, 200,75,5);
  	  gc.fillRect(x, 200,75,5);
  	  gc.fillRect(x+100, 200,75,5);
	  gc.fillRect(x+200, 200,75,5);
	  gc.fillRect(x+300, 200,75,5);
	  gc.fillRect(x+400, 200,75,5);


	  //Draw Car
	  gc.setColor(Color.red);
      gc.fillRect(300, 120, 60, 40);
      gc.setColor(Color.red);
      gc.fillRect(285, 140, 25, 20);

      // windows
      gc.setColor(Color.blue);
      for (int i=0; i < 4; i++){
         gc.fillOval(295+(i+1)*11, 128, 10, 10);
      }

  	  gc.setColor(Color.black);
      gc.fillOval(290, 150, 18, 18);
      gc.fillOval(340, 150, 18, 18);





      }

}