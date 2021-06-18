import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class LaunchPage implements ActionListener{
    
    JFrame frame = new JFrame();
    JButton myButton = new JButton("Play Again");
    JPanel title_panel = new JPanel();
    JLabel textfield = new JLabel();
    

    LaunchPage(){ 
        
        myButton.setBounds(100,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);

        frame.add(myButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("You Win!");
        textfield.setOpaque(true);
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,420,100);
        
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==myButton) {
            frame.dispose();
            Battleship2D battleship = new Battleship2D();
        }
    }
}