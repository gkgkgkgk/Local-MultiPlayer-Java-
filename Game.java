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
		w.setResizable(false);
		w.setVisible(true);
		w.setContentPane(this);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loop();
		}

		public void loop(){
		t.scheduleAtFixedRate(new TimerTask() {
		      public void run() {
				  for(Player p : players){
					
					p.setPosition(Math.cos(Math.toRadians(p.getRotation())), Math.sin(Math.toRadians(p.getRotation())));
					
					//boundary collision//
					if(p.getYPos()>height-50){p.setYPos(height-50);}
					if(p.getYPos()<50){p.setYPos(50);}
					if(p.getXPos()>width-50){p.setXPos(width-50);}
					if(p.getXPos()<50){p.setXPos(50);}
					//boundary collision//
					
				  if(p.moveRight){
					p.setRotation(3); 
				  }
				  if(p.moveLeft){
					p.setRotation(-3); 
				  }
				  }
				  time++;
		        repaint();
	}
	    }, 0, 16);}

		 public void keyPressed(KeyEvent e) {
			 for(Player p : players){
				 if(e.getKeyChar() == p.getControlRight()){
					p.moveRight = true;
				 }
				 if(e.getKeyChar() == p.getControlLeft()){
					p.moveLeft = true;
				 }
			 }
		 }
		 public void keyReleased(KeyEvent e) {
			for(Player p : players){
				 if(e.getKeyChar() == p.getControlRight()){
					p.moveRight = false;
				 }
				 if(e.getKeyChar() == p.getControlLeft()){
					p.moveLeft = false;
				 }
			 }

		 }
		    public void keyTyped(KeyEvent e) {}
		 

		public void paintComponent(Graphics g){
			super.paintComponent(g);
			for(Player p : players){p.DrawPlayer(g);}
		}





		public static void main(String[] args){
			new StartPanel();
		}
		
		
}