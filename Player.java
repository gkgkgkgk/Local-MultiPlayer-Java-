import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.AffineTransform;


public class Player{

	int playerNumber;
	Color color;
	char control;
	double rotation = 0;
	double xPos = 100;
	double yPos = 100;
	
	public Player(int num, Color c, char con){
		this.playerNumber = num;
		this.color = c;
		this.control = con;
	}
	
	
	public void setRotation(double rot){
		rotation = rot;
	}
	
	public void DrawPlayer(Graphics g){
		Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.
		        //store old rotation
		AffineTransform old = g2d.getTransform();
		g.setColor(color);
		g2d.translate(xPos, xPos); // Translate the center of our coordinates.
		g2d.rotate(Math.toRadians(rotation), 0, -12.5);
		g.fillPolygon(new int[] {-10, 0, +10}, new int[] {0, -25, 0}, 3);
		g2d.setTransform(old);
	}
	
	public char getControl(){return control;}
	public int getPlayerNum(){return playerNumber;}
	

}