import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class StartPanel extends JPanel implements ActionListener{

	JFrame w;
	int height = 600;
	int width = 800;
	int playerAmount = 0;
	JButton start = new JButton("Start!");
	JButton addPlayer = new JButton("Add Player!");
	
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
		add(addPlayer);
		add(start);
		w.setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == addPlayer){addPlayerPanel();}
			
		}
		
		
		void addPlayerPanel(){
			playerAmount += 1;
			add(new PlayerPanel(playerAmount, Color.BLUE));
			revalidate();
		}

}