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
				double counter = 0;
			if(e.getSource() == start){for(PlayerPanel p : playerPanels){
				counter += 1;
				players.add(new Player(p.getPlayerNum(), p.getColor(), p.getControlL(), p.getControlR(), counter*(600.0/(playerAmount+1.0))));
			}
			new Game(players);
		}
			
		}
		
		
		void addPlayerPanel(){
			playerAmount += 1;
			Character[] lettersL = new Character[] {'a','k','g','d','z','n','b','q','o','t','e','i'};
			Character[] lettersR = new Character[] {'s','l','h','f','x','m','v','w','p','y','r','u'};
			Color[] colors = new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE, Color.PINK, Color.GRAY, Color.BLACK, Color.YELLOW};
			PlayerPanel p = new PlayerPanel(playerAmount, colors[playerAmount-1], lettersL[playerAmount-1], lettersR[playerAmount-1]);
			add(p);
			playerPanels.add(p);
			revalidate();
			if(playerAmount >= 8){
				 remove(addPlayer);
			}
		}

}