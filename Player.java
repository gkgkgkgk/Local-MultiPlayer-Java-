import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.geom.*;


public class Player{

	int playerNumber;
	Color color;
	char controlLeft;
	char controlRight;

	double rotation = 0.0;
	double xPos = 50;
	double yPos = 200;
	boolean moveRight = false;
	boolean moveLeft = false;
	Rectangle bounds = new Rectangle((int)xPos, (int)yPos, 20, 10);
	Polygon boundsTest;	
	
	public Player(int num, Color c, char conL, char conR, double y){
		this.playerNumber = num;
		this.color = c;
		this.controlRight = conR;
		this.controlLeft = conL;
		yPos = y;
	}
	
	
	public void setRotation(double rot){
		rotation += rot;
	}
	
	public void DrawPlayer(Graphics g){
		g.drawRect((int)(xPos-(Math.cos(Math.toRadians(rotation))*-10)) -5 ,(int)(yPos-(Math.sin(Math.toRadians(rotation))*-5))-5, 10, 10); //Optional Draw Bounds
		
		Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.
		        //store old rotation
		AffineTransform old = g2d.getTransform();
		g.setColor(color);
		g2d.translate(xPos, yPos); // Translate the center of our coordinates.
		g2d.rotate(Math.toRadians(rotation), 0, 0);
		g.fillPolygon(new int[] {-10, 10, -10}, new int[] {-5, 0, 5}, 3);
		g2d.setTransform(old);
	}
	
	public char getControlLeft(){return controlLeft;}
	public char getControlRight(){return controlRight;}
	public double getXPos(){return xPos;}
	public double getYPos(){return yPos;}
	public void setXPos(int x){xPos = x;}
	public void setYPos(int y){yPos = y;}
	public int getPlayerNum(){return playerNumber;}
	public double getRotation(){return rotation;}

	public void setPosition(double x, double y){
		xPos += x;
		yPos += y;
	}
	
	public void checkCollision(ArrayList<Obstacle> obstacles){
		double normal;
		while(rotation < 0){rotation += 360.0;}
		while(rotation > 360){rotation -= 360.0;}
		System.out.println(rotation);
		for(Obstacle o : obstacles){if(bounds.intersects(o.getBounds())){
			if(xPos <= o.getBounds().getX()){
				setXPos((int)o.getBounds().getX()-10);
			}
			if(xPos > o.getBounds().getX() + (o.getBounds().getWidth())){
				setXPos(10+(int)o.getBounds().getX()+ (int)(o.getBounds().getWidth()));
			}
			if(yPos <= o.getBounds().getY()){
				setYPos((int)o.getBounds().getY()-5);
			}
			if(yPos > o.getBounds().getY() + (o.getBounds().getHeight())){
				setYPos(5+(int)o.getBounds().getY()+ (int)(o.getBounds().getHeight()));
			}
		}}
	}
	
	public void refreshBounds(){
				 bounds = new Rectangle((int)(xPos-(Math.cos(Math.toRadians(rotation))*-10)) -5 ,(int)(yPos-(Math.sin(Math.toRadians(rotation))*-5))-5, 10, 10);
			 }

}