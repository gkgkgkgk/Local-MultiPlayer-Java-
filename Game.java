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
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
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
		
		for(int i = 0; i < 50; i++){
		obstacles.add(new Obstacle(new Rectangle((int)(Math.random()*(width-80)), (int)(Math.random()*(height-80)), (int)(Math.random()*50), (int)(Math.random()*50)), Color.RED));
		}
		loop(); // start the game loop
		}

		public void loop(){
		t.scheduleAtFixedRate(new TimerTask() {
		      public void run() {
				  for(Player p : players){
					  System.out.println(p.getRotation());
					p.refreshBounds();
					p.setPosition(Math.cos(Math.toRadians(p.getRotation())), Math.sin(Math.toRadians(p.getRotation())));
					
					p.checkCollision(obstacles);
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
			g.setColor(Color.WHITE);
			g.fillRect(0,0,width,height);
			g.setColor(Color.BLACK);
			g.drawRect(40, 40, width-80, height-80);
			for(Player p : players){p.DrawPlayer(g);} //draw players
			for(Obstacle o : obstacles){o.draw(g);} //draw obstacles
			
		}





		public static void main(String[] args){
			new StartPanel();
		}
		
		
}