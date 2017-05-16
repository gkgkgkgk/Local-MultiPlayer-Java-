import java.awt.*;
import javax.swing.*;

public class Bullet{

	int size = 6;
	int speed = 5;
	double xPos;
	double yPos;
	
	Rectangle bounds;

	Color c;
	
	double rotation;

	public Bullet(double xPos, double yPos, double rotation, Color c){
		this.rotation = rotation;
		this.xPos = xPos;
		this.yPos = yPos;
		this.c = c;
	}
	
	public void move(){
		bounds = new Rectangle((int)xPos - (size/2), (int)yPos - (size/2), size,size);
		xPos +=  speed * Math.cos(Math.toRadians(rotation));
		yPos +=  speed * Math.sin(Math.toRadians(rotation));
	
	}

	public void draw(Graphics g){
		g.setColor(c);
		g.fillOval((int)xPos,(int)yPos,size,size);	
	}
	
	


}