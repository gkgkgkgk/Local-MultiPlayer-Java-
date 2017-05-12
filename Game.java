import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game extends JPanel implements KeyListener{
	
	JFrame w;
	int height = 600;
	int width = 800;
	ArrayList<Player> players = new ArrayList<Player>();
	double time;
	
	 Timer t = new Timer();
	
	public Game(ArrayList<Player> p){
		players = p;
		System.out.println(players.size());
		
		w = new JFrame();
		w.addKeyListener(this);
		w.setSize(width, height);
		w.setVisible(true);
		w.setContentPane(this);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loop();
		}

		public void loop(){
		t.scheduleAtFixedRate(new TimerTask() {
		      public void run() {
				  players.get(0).setRotation(time);
				  time++;
		        repaint();
	}
	    }, 0, 16);}

		 public void keyPressed(KeyEvent e) {
			 for(Player p : players){
				 if(e.getKeyChar() == p.getControl()){
					 System.out.println(p.getControl());
				 }
			 }
		 }
		 public void keyReleased(KeyEvent e) {


		 }
		    public void keyTyped(KeyEvent e) {}
		 

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			players.get(0).DrawPlayer(g);
		}





		public static void main(String[] args){
			new StartPanel();
		}
		
		
}