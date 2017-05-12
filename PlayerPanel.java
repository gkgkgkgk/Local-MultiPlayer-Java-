import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PlayerPanel extends JPanel{

	JLabel playerNum;
	int num;
	private JButton chooseColor = new JButton();
	Color color;
	char control = 'a';
	
	
	Character[] letters = new Character[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	JComboBox<Character> controls = new JComboBox<Character>(letters);
 
	
	public PlayerPanel(int num, Color c){
		this.num = num;
		chooseColor.setOpaque(true);
		chooseColor.setBackground(c);
		playerNum = new JLabel("Player "+num);
		add(playerNum);
		add(chooseColor);
		add(controls);
		chooseColor.setBorderPainted(false);
		chooseColor.addActionListener(new ButtonListener());
	
	}

	public int getPlayerNum(){return num;}
	public Color getColor(){return color;}
	public char getControl(){return controls.getSelectedItem().toString().charAt(0);}

	
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