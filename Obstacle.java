import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Obstacle {
	
	Rectangle boundaries;
	Color c;
	
	
	public Obstacle(Rectangle r, Color c){
		boundaries = r;
		this.c = c;
	}
	
	public void draw(Graphics g){
		g.setColor(c);
		g.fillRect((int)boundaries.getX(), (int)boundaries.getY(), (int)boundaries.getWidth(), (int)boundaries.getHeight());
	}
	

}