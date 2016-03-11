
//*****************************************************************************
//car pamel that is drawn on
//*****************************************************************************

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;

public class CarPanel extends JPanel
{
   private Car car;

   //--------------------------------------------------------------------------
   //  Sets up the panel. Uses one listener for key events.
   //--------------------------------------------------------------------------
   public CarPanel()
   {
      car = new Car();
      setBackground (Color.black);
      setPreferredSize(new Dimension(480, 480));
      setFocusable(true);



   }

   //--------------------------------------------------------------------------
   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);
      car.draw(page, getWidth());
   }

   //**************************************************************************


	public void Move() {

			car.toggleLight(getWidth());
			repaint();
	}



}