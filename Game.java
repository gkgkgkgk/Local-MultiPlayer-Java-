import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Game extends JPanel{
	
	JFrame w;
	int height = 600;
	int width = 800;
	ArrayList<Player> players = new ArrayList<Player>();
	
	public Game(ArrayList<Player> p){
		players = p;
		System.out.println(players.size());
		
		w = new JFrame();
		w.setSize(width, height);
		w.setVisible(true);
		w.setContentPane(this);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.fillRect(100,100,100,100);
			players.get(0).DrawPlayer(g);
		}


		public static void main(String[] args){
			new StartPanel();
		}
		
		
}