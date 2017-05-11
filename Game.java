import javax.swing.*;
import java.awt.*;


public class Game extends JPanel{
	
	JFrame w;
	int height = 600;
	int width = 800;
	
	
	public Game(){
		w = new JFrame();
		w.setSize(width, height);
		w.setVisible(true);
		w.setContentPane(this);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}


		public static void main(String[] args){
			new StartPanel();
		}
		
		
}