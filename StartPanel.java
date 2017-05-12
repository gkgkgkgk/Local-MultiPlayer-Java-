import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class StartPanel extends JPanel implements ActionListener{

	JFrame w;
	int height = 600;
	int width = 800;
	int playerAmount = 0;
	JButton start = new JButton("Start!");
	JButton addPlayer = new JButton("Add Player!");
	ArrayList<PlayerPanel> playerPanels = new ArrayList<PlayerPanel>();
	ArrayList<Player> players = new ArrayList<Player>();
	
	
	public StartPanel(){
		JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		w = new JFrame();
		w.setSize(width, height);
		w.setContentPane(scrollPane);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setTitle("Select Players!");
		addPlayer.setAlignmentX( Component.CENTER_ALIGNMENT );
		addPlayer.addActionListener(this);
		start.setAlignmentX( Component.CENTER_ALIGNMENT );
		start.addActionListener(this);
		add(addPlayer);
		add(start);
		w.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addPlayer){addPlayerPanel();}
			if(e.getSource() == start){for(PlayerPanel p : playerPanels){
				players.add(new Player(p.getPlayerNum(), p.getColor(), p.getControl()));
			}
			System.out.println("BOI");
			new Game(players);
		}
			
		}
		
		
		void addPlayerPanel(){
			playerAmount += 1;
			PlayerPanel p = new PlayerPanel(playerAmount, Color.BLUE);
			add(p);
			playerPanels.add(p);
			revalidate();
		}

}