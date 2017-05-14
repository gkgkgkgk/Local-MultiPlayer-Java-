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

	Character[] lettersL = new Character[] {'a','k','g','d','z','n','b','q','o','t','e','i'};
	Character[] lettersR = new Character[] {'s','l','h','f','x','m','v','w','p','y','r','u'};

	JComboBox<Character> controlsL = new JComboBox<Character>(lettersL);
 	JComboBox<Character> controlsR = new JComboBox<Character>(lettersR);

	
	public PlayerPanel(int num, Color c, char conL, char conR){
		this.num = num;
		chooseColor.setOpaque(true);
		chooseColor.setBackground(c);
		color = c;
		controlRight = conR;
		controlLeft = conL;
		playerNum = new JLabel("Player "+num);
		add(playerNum);
		add(chooseColor);
		add(controlsL);
		add(controlsR);
		chooseColor.setBorderPainted(false);
		chooseColor.addActionListener(new ButtonListener());
		controlsL.setSelectedItem(conL);
		controlsR.setSelectedItem(conR);
	}

	public int getPlayerNum(){return num;}
	public Color getColor(){return color;}
	public char getControlR(){return controlsR.getSelectedItem().toString().charAt(0);}
	public char getControlL(){return controlsL.getSelectedItem().toString().charAt(0);}

	
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