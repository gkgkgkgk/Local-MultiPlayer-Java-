import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Player{

	int playerNumber;
	Color color;
	char control;
	double rotation;
	
	
	public Player(int num, Color c, char con){
		this.playerNumber = num;
		this.color = c;
		this.control = con;
	}
	
	public void DrawPlayer(Graphics g){
		g.setColor(color);
		g.fillRect(100,100,100,100);
	}


}