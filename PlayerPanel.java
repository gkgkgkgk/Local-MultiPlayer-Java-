import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlayerPanel extends JPanel{

	JLabel playerNum;
	private JButton chooseColor = new JButton();
	Color color;
	
	public PlayerPanel(int num, Color c){
		chooseColor.setOpaque(true);
		chooseColor.setBackground(c);
		playerNum = new JLabel("Player "+num);
		add(playerNum);
		add(chooseColor);
		chooseColor.setBorderPainted(false);
		chooseColor.addActionListener(new ButtonListener());
	
	
	}

	
	private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      Color c = JColorChooser.showDialog(null, "Choose a Color", chooseColor.getForeground());
      if (c != null)
	      
	  
	    chooseColor.setBackground(c);
		color = c;
    }
  }

}