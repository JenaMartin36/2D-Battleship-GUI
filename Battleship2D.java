import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
/**
 * Write a description of class Battleship2DBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Battleship2D implements ActionListener
{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[][] buttons = new JButton[7][7];
    double missCount = 0;
    int sinkCount = 0;
    double score;

    Battleship2D(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Battleship");
        textfield.setOpaque(true);
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        
        button_panel.setLayout(new GridLayout(7,7));
        button_panel.setBackground(new Color(150,150,150));
        
        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton();
                button_panel.add(buttons[i][j]);
                buttons[i][j].setFont(new Font("MV Boli",Font.BOLD,50));
                buttons[i][j].setFocusable(false);
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground(Color.white);
            }
        }
        
        //Vertical size 3
        int i = (int)(Math.random()*buttons.length);
        int j = (int)(Math.random()*buttons[i].length);
        //int i = 2;
        //int j = 3;
        
        buttons[i][j].setText("X");
        buttons[i][j].setForeground(Color.white);
        if(i == 5 ||i == 6 ||i == 12 ||i == 13 ||i == 19 ||i == 20 ||i == 26 ||i == 27||
        i == 33 ||i == 34 ||i == 40 ||i == 41 ||i == 47 ||i == 48) {
            buttons[i - 1][j].setText("X");
            buttons[i - 2][j].setText("X");
            
            buttons[i - 1][j].setForeground(Color.white);
            buttons[i - 2][j].setForeground(Color.white);
        }
        else {
            buttons[i + 1][j].setText("X");
            buttons[i + 2][j].setText("X");
            
            buttons[i + 1][j].setForeground(Color.white);
            buttons[i + 2][j].setForeground(Color.white);
        }
        
        //Horizontal size 3
        int a = (int)(Math.random()*buttons.length);
        int b = (int)(Math.random()*buttons[a].length);
        //int a = 1;
        //int b = 4;
        
        buttons[a][b].setText("x");
        buttons[a][b].setForeground(Color.white);
        if(b == 5 ||b== 6 ||b== 12 ||b== 13 ||b== 19 ||b== 20 ||b== 26 ||b== 27||b== 33 
        ||b == 34 ||b== 40 ||b== 41 ||b== 47 ||b== 48) {
            buttons[a][b - 1].setText("x");
            buttons[a][b - 2].setText("x");
            
            buttons[a][b - 1].setForeground(Color.white);
            buttons[a][b - 2].setForeground(Color.white);
        }
        else {
            buttons[a][b + 1].setText("x");
            buttons[a][b + 2].setText("x");
            
            buttons[a][b + 1].setForeground(Color.white);
            buttons[a][b + 2].setForeground(Color.white);
        }
        
        
        //Vertical size 4
        int c = (int)(Math.random()*buttons.length);
        int d = (int)(Math.random()*buttons[c].length);
        //int c = 3;
        //int d = 5;
        
        buttons[c][d].setText("O");
        buttons[c][d].setForeground(Color.white);
        if((c >= 4 && c <= 6) || (c >= 11 && c <= 13 )||(c >= 18 && c <= 20 )|| 
        (c >= 25 && c <= 27)||(c >= 32 && c <= 34 )||(c >= 39 && c <= 41 )||(c >= 46 && c <= 48)) {
            buttons[c - 1][d].setText("O");
            buttons[c - 2][d].setText("O");
            buttons[c - 3][d].setText("O");
            
            buttons[c - 1][d].setForeground(Color.white);
            buttons[c - 2][d].setForeground(Color.white);
            buttons[c - 3][d].setForeground(Color.white);
        }
        else {
            buttons[c + 1][d].setText("O");
            buttons[c + 2][d].setText("O");
            buttons[c + 3][d].setText("O");
            
            buttons[c + 1][d].setForeground(Color.white);
            buttons[c + 2][d].setForeground(Color.white);
            buttons[c + 3][d].setForeground(Color.white);
        }
        
        //Horizontal size 4
        int e = (int)(Math.random()*buttons.length);
        int f= (int)(Math.random()*buttons[e].length);
        //int e = 6;
        //int f = 0;
        
        buttons[e][f].setText("o");
        buttons[e][f].setForeground(Color.white);
        if((f >= 4 && f <= 6) || (f >= 11 && f <= 13 )||(f >= 18 && f <= 20 )|| 
        (f >= 25 && f <= 27)||(f >= 32 && f <= 34 )||(f >= 39 && f <= 41 )||(f >= 45 && f <= 48)) {
            buttons[e][f - 1].setText("o");
            buttons[e][f - 2].setText("o");
            buttons[e][f - 3].setText("o");
            
            buttons[e][f - 1].setForeground(Color.white);
            buttons[e][f - 2].setForeground(Color.white);
            buttons[e][f - 3].setForeground(Color.white);
        }
        else {
            buttons[e][f + 1].setText("o");
            buttons[e][f + 2].setText("o");
            buttons[e][f + 3].setText("o");
            
            buttons[e][f + 1].setForeground(Color.white);
            buttons[e][f + 2].setForeground(Color.white);
            buttons[e][f + 3].setForeground(Color.white);
        }
        
        //Vertical size 5
        int g = (int)(Math.random()*buttons.length);
        int h = (int)(Math.random()*buttons[g].length);
        //int g = 0;
        //int h = 1;
        
        buttons[g][h].setText("V");
        buttons[g][h].setForeground(Color.white);
        if((g >= 3 && g <= 6) || (g >= 10 && g <= 13 )||(g >= 17 && g <= 20 )|| 
        (g >= 24 && g <= 27)||(g >= 31 && g <= 34 )||(g >= 38 && g <= 41 )||(g >= 45 && g <= 48)) {
            buttons[g - 1][h].setText("V");
            buttons[g - 2][h].setText("V");
            buttons[g - 3][h].setText("V");
            buttons[g - 4][h].setText("V");
            
            buttons[g - 1][h].setForeground(Color.white);
            buttons[g - 2][h].setForeground(Color.white);
            buttons[g - 3][h].setForeground(Color.white);
            buttons[g - 4][h].setForeground(Color.white);
        }
        else {
            buttons[g + 1][h].setText("V");
            buttons[g + 2][h].setText("V");
            buttons[g + 3][h].setText("V"); 
            buttons[g + 4][h].setText("V");
            
            buttons[g + 1][h].setForeground(Color.white);
            buttons[g + 2][h].setForeground(Color.white);
            buttons[g + 3][h].setForeground(Color.white);
            buttons[g + 4][h].setForeground(Color.white);
        }

        
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
          
        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++) {
                if(e.getSource() == buttons[i][j]) {
                    if(buttons[i][j].getText()=="") {
                        buttons[i][j].setBackground(Color.gray);
                        textfield.setText("Miss");
                        missCount++;
                    }
                    if(buttons[i][j].getText()=="V") {
                        buttons[i][j].setBackground(Color.red);
                        textfield.setText("Hit");
                        check5();
                    }
                    if(buttons[i][j].getText()=="O") {
                        buttons[i][j].setBackground(Color.red);
                        textfield.setText("Hit");
                        check4();
                    }
                    if(buttons[i][j].getText()=="o") {
                        buttons[i][j].setBackground(Color.red);
                        textfield.setText("Hit");
                        check4();
                    }
                    if(buttons[i][j].getText()=="X") {
                        buttons[i][j].setBackground(Color.red);
                        textfield.setText("Hit");
                        check3();
                    }
                    if(buttons[i][j].getText()=="x") {
                        buttons[i][j].setBackground(Color.red);
                        textfield.setText("Hit");
                        check3();
                    }
                }  
            }
        }
    }
    public void firstTurn() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        textfield.setText("Make your guess");
    }
    public void check5() {
        //5
        for(int i = 0; i < buttons[0].length; i++) {
            if((buttons[0][i].getBackground() == Color.red)&&
                (buttons[1][i].getBackground() == Color.red)&&
                (buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)) {
                    win5(0,i,1,i,2,i,3,i,4,i);
            }
            if((buttons[1][i].getBackground() == Color.red)&&
                (buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)&&
                (buttons[5][i].getBackground() == Color.red)) {
                    win5(1,i,2,i,3,i,4,i,5,i);
            }
            if((buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)&&
                (buttons[5][i].getBackground() == Color.red)&&
                (buttons[6][i].getBackground() == Color.red)) {
                    win5(2,i,3,i,4,i,5,i,6,i);
            }
        }
    } 
    
    public void win5(int a1, int a2, int b1, int b2, int c1, int c2, int d1, int d2, int e1, int e2) {
        
        buttons[a1][a2].setBackground(Color.green);
        buttons[b1][b2].setBackground(Color.green);
        buttons[c1][c2].setBackground(Color.green);
        buttons[d1][d2].setBackground(Color.green);
        buttons[e1][e2].setBackground(Color.green);
        
        textfield.setText("Sunk");
        sinkCount++;
        checkWin();
    }
    
    public void check4() {
        for(int i = 0; i < buttons[0].length; i++) {
            if((buttons[0][i].getBackground() == Color.red)&&
                (buttons[1][i].getBackground() == Color.red)&&
                (buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)) {
                    win4(0,i,1,i,2,i,3,i);
            }
            if((buttons[1][i].getBackground() == Color.red)&&
                (buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)) {
                    win4(1,i,2,i,3,i,4,i);
            }
            if((buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)&&
                (buttons[5][i].getBackground() == Color.red)) {
                    win4(2,i,3,i,4,i,5,i);
            }
            if((buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)&&
                (buttons[5][i].getBackground() == Color.red)&&
                (buttons[6][i].getBackground() == Color.red)) {           
                    win4(3,i,4,i,5,i,6,i);         
            }
        }
        for(int j = 0; j < buttons[0].length; j++) {
            if((buttons[j][0].getBackground() == Color.red)&&
                (buttons[j][1].getBackground() == Color.red)&&
                (buttons[j][2].getBackground() == Color.red)&&
                (buttons[j][3].getBackground() == Color.red)) {
                    win4(j,0,j,1,j,2,j,3);
            }
            if((buttons[j][1].getBackground() == Color.red)&&
                (buttons[j][2].getBackground() == Color.red)&&
                (buttons[j][3].getBackground() == Color.red)&&
                (buttons[j][4].getBackground() == Color.red)) {
                    win4(j,1,j,2,j,3,j,4);
            }
            if((buttons[j][2].getBackground() == Color.red)&&
                (buttons[j][3].getBackground() == Color.red)&&
                (buttons[j][4].getBackground() == Color.red)&&
                (buttons[j][5].getBackground() == Color.red)) {
                    win4(j,2,j,3,j,4,j,5);
            }
            if((buttons[j][3].getBackground() == Color.red)&&
                (buttons[j][4].getBackground() == Color.red)&&
                (buttons[j][5].getBackground() == Color.red)&&
                (buttons[j][6].getBackground() == Color.red)) {           
                    win4(j,3,j,4,j,5,j,6);          
            }
        }
    }
    
    public void win4(int a1, int a2, int b1, int b2, int c1, int c2, int d1, int d2) {
        
        buttons[a1][a2].setBackground(Color.green);
        buttons[b1][b2].setBackground(Color.green);
        buttons[c1][c2].setBackground(Color.green);
        buttons[d1][d2].setBackground(Color.green);
        
        textfield.setText("Sunk");
        sinkCount++;
        checkWin();
    }
    public void check3() {
        //3
        for(int i = 0; i < buttons[0].length; i++) {
            if((buttons[0][i].getBackground() == Color.red)&&
                (buttons[1][i].getBackground() == Color.red)&&
                (buttons[2][i].getBackground() == Color.red)) {
                    win3(0,i,1,i,2,i);
            }
            if((buttons[1][i].getBackground() == Color.red)&&
                (buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)) {
                    win3(2,i,2,i,3,i);
            }
            if((buttons[2][i].getBackground() == Color.red)&&
                (buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)) {
                    win3(2,i,3,i,4,i);
            }
            if((buttons[3][i].getBackground() == Color.red)&&
                (buttons[4][i].getBackground() == Color.red)&&
                (buttons[5][i].getBackground() == Color.red)) {           
                    win3(3,i,4,i,5,i);         
            }   
            if((buttons[4][i].getBackground() == Color.red)&&
                (buttons[5][i].getBackground() == Color.red)&&
                (buttons[6][i].getBackground() == Color.red)) {
                    win3(4,i,5,i,6,i);
            }
        }
        for(int j = 0; j < buttons[0].length; j++) {
            if((buttons[j][0].getBackground() == Color.red)&&
                (buttons[j][1].getBackground() == Color.red)&&
                (buttons[j][2].getBackground() == Color.red)) {
                    win3(j,0,j,1,j,2);
            }
            if((buttons[j][1].getBackground() == Color.red)&&
                (buttons[j][2].getBackground() == Color.red)&&
                (buttons[j][3].getBackground() == Color.red)) {
                    win3(j,1,j,2,j,3);
            }
            if((buttons[j][2].getBackground() == Color.red)&&
                (buttons[j][3].getBackground() == Color.red)&&
                (buttons[j][4].getBackground() == Color.red)) {
                    win3(j,2,j,3,j,4);
            }
            if((buttons[j][3].getBackground() == Color.red)&&
                (buttons[j][4].getBackground() == Color.red)&&
                (buttons[j][5].getBackground() == Color.red)) {           
                    win3(j,3,j,4,j,5);          
            }   
            if((buttons[j][4].getBackground() == Color.red)&&
                (buttons[j][5].getBackground() == Color.red)&&
                (buttons[j][6].getBackground() == Color.red)) {
                    win3(j,4,j,5,j,6);
            }
        }
    }
    
    public void win3(int a1, int a2, int b1, int b2, int c1, int c2) {
        
        buttons[a1][a2].setBackground(Color.green);
        buttons[b1][b2].setBackground(Color.green);
        buttons[c1][c2].setBackground(Color.green);
        
        textfield.setText("Sunk");
        sinkCount++;
        checkWin();
    }
    
    public void checkWin() {
        if(sinkCount == 5) {
            win();
        }
    }
    
    public double getScore() {
        score = (missCount/16.0) * 100;
        score =(100 - score);
        return score;
    }
    
    public void win() {
        score = (missCount/16.0) * 100;
        score =(100 - score);
        
        for(int i = 0; i < buttons.length; i++) {
            for(int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
        
        textfield.setText("Your score is " + score +"/100.0");
        
        LaunchPage launchPage = new LaunchPage();
         
        //frame.dispose();
    }
}


