import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.AffineTransform;


public class Player{

	int playerNumber;
	Color color;
	char control;
	double rotation = 90.0;
	double xPos = 50;
	double yPos = 200;
	boolean move = false;
	
	
	public Player(int num, Color c, char con, double y){
		this.playerNumber = num;
		this.color = c;
		this.control = con;
		yPos = y;
	}
	
	
	public void setRotation(double rot){
		rotation += rot;
	}
	
	public void DrawPlayer(Graphics g){
		Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.
		        //store old rotation
		AffineTransform old = g2d.getTransform();
		g.setColor(color);
		g2d.translate(xPos, yPos); // Translate the center of our coordinates.
		g2d.rotate(Math.toRadians(rotation), 0, 0);
		g.fillPolygon(new int[] {-10, 10, -10}, new int[] {-5, 0, 5}, 3);
		g2d.setTransform(old);
	}
	
	public char getControl(){return control;}
	public int getPlayerNum(){return playerNumber;}
	public double getRotation(){return rotation;}

	public void setPosition(double x, double y){
		xPos += x;
		yPos += y;
	}

}