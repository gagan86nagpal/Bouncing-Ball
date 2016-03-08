import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
public class Ball extends JPanel{
	JFrame f;
	int x=0;
	int y=0;
	int x_velocity=10;
	int y_velocity=10;
	int gravity=10;
	Color rand=Color.red;
	Boolean is_moving_down=true;
	public static void main(String [] args)
	{
		Ball b = new Ball();
		JFrame f=new JFrame();
		f.add(b);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(1366,768);
		f.setVisible(true);
		while(b.x<1366)
		{
			try
			{
			Thread.sleep(100);
			}
			catch(Exception e)
			{
				
			}
			b.move_it();
			f.repaint();
		}
	}
	void move_it()
	{
		int b=(int)(Math.random()*255);
		int g=(int)(Math.random()*255);
		int r=(int)(Math.random()*255);
		x+=x_velocity;
		if(is_moving_down) // going down
		{
			if(y<690)
			y_velocity+=gravity;
			else // collision at floor
			{
				rand=new Color(r,b,g);
				y_velocity*=-0.85; // rebound at 90% of velocity
				is_moving_down=false; // now it should move up
			}
		}
		else // moving up
		{
			if(y_velocity>0) // till it has enough energy to further move up
			{
				y_velocity-=gravity;
			}
			else // now it has attained maximum height , so it should move down
				is_moving_down=true;
		}
		y+=y_velocity;
	}
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(rand);
		g.fillOval(x, y, 60, 60);
	}
}