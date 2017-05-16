import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlayerPanel extends JPanel{

	JLabel playerNum;
	int num;
	private JButton chooseColor = new JButton();
	Color color;
	char controlRight = 'a';
	char controlLeft = 'a';
	char controlShoot = 'a';

	Character[] lettersL = new Character[] {'q', 'i', 'r', 'z','b','a','f','j'};
	Character[] lettersR = new Character[] {'e', 'p', 'y','c','m','d','g','l'};
	Character[] lettersShoot = new Character[] {'w', 'o', 't','x','n','s','h','k'};

	JComboBox<Character> controlsL = new JComboBox<Character>(lettersL);
 	JComboBox<Character> controlsR = new JComboBox<Character>(lettersR);
 	JComboBox<Character> controlsShoot = new JComboBox<Character>(lettersShoot);
	

	
	public PlayerPanel(int num, Color c, char conL, char conR, char conShoot){
		this.num = num;
		chooseColor.setOpaque(true);
		chooseColor.setBackground(c);
		color = c;
		controlRight = conR;
		controlLeft = conL;
		controlShoot = conShoot;
		playerNum = new JLabel("Player "+num);
		add(playerNum);
		add(chooseColor);
		add(new JLabel("Left:"));
		add(controlsL);
		add(new JLabel("Right:"));
		add(controlsR);
		add(new JLabel("Shoot:"));
		add(controlsShoot);
		chooseColor.setBorderPainted(false);
		chooseColor.addActionListener(new ButtonListener());
		controlsL.setSelectedItem(conL);
		controlsR.setSelectedItem(conR);
		controlsShoot.setSelectedItem(conShoot);
		
	}

	public int getPlayerNum(){return num;}
	public Color getColor(){return color;}
	public char getControlR(){return controlsR.getSelectedItem().toString().charAt(0);}
	public char getControlL(){return controlsL.getSelectedItem().toString().charAt(0);}
	public char getControlShoot(){return controlsShoot.getSelectedItem().toString().charAt(0);}

	
	private class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == chooseColor){
      Color c = JColorChooser.showDialog(null, "Choose a Color", chooseColor.getForeground());
      if (c != null){
	      
	  
	    chooseColor.setBackground(c);
		color = c;
    }}
}
	
  }

}