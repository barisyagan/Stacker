package stacker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





/*
 * Baris Yagan S5019 Department of Computer Science
 */

public class Stacker extends Component {
	public static final int width = 350;
	public static final int height = 650;
	
	public bar blueBar;
	static int speed = 405;
	public static int level = 1;
	int score = 100;
	ArrayList<bar> barList = new ArrayList<bar>();
	private boolean clear;
	
	//constructor
	public Stacker() {
		
		blueBar = new bar(3,200,600);
		addKeyListener(new KeyHandler());
	}
	
	//paints everything.
	public void paint(Graphics g) {
		
		super.paint(g);
		blueBar.drawOn(g);
		drawGridOn(g);
		
		for(bar b : barList){
			b.drawOn(g);
			drawGridOn(g);
		}
		
		drawGridOn(g);
	}
	
	//makes game to flow according to stacker game rules.
	public void moveOneFrame(int size){
		
			if(newBar == true){
				score+=200;
				if(level > 2){
					while( ( barList.get(barList.size()-1 ).getX() > blueBar.getX() )){
						blueBar.setN(blueBar.getN()-1);
						blueBar.setX(blueBar.getX()+50);
						if(blueBar.getN() == 0){
							blueBar.playFailure();
							int reply = JOptionPane.showConfirmDialog(null, "You couldn't manage to help her! :((( \n  Do you want to try again?", "Mission Failed", JOptionPane.YES_NO_OPTION);
							if(reply == JOptionPane.YES_OPTION){
								System.exit(0);
							}
							else if (reply == JOptionPane.NO_OPTION) System.exit(0);
						}
					}
					while( ( barList.get(barList.size()-1 ).getXlast() < blueBar.getXlast() )){
						blueBar.setN(blueBar.getN()-1);
				
						if(blueBar.getN() == 0){
							blueBar.playFailure();
							int reply = JOptionPane.showConfirmDialog(null, "You couldn't manage to help her! :((( \n  Do you want to try again?", "Mission Failed", JOptionPane.YES_NO_OPTION);
							if(reply == JOptionPane.YES_OPTION){
								System.exit(0);
								
							}
							
							else if (reply == JOptionPane.NO_OPTION) System.exit(0);
						}
					}
				}
			if(clear != true){	
		
				barList.add(new bar(blueBar.constantN(),blueBar.constantX(), blueBar.constantY()));
				blueBar.goUp();
			}
			newBar = false;
		}
		blueBar.moveTo(bar.SIZE);
		repaint();
	}
	
	//states if you win the game.
	public void winCondition(){
		if(level == 14){
			blueBar.playWin();
			JOptionPane.showMessageDialog(null, "Score: " + score + "\nYou saved the princess! YAYYY :)" );
			System.exit(0);
		}
	}
	
	
	//draws grid.
	private void drawGridOn(Graphics g){
		g.setColor(Color.GRAY);
       
		for(int i = 0; i <= width; i += bar.SIZE) {
            g.drawLine(i, 0, i, height);
        }
        for(int j = 0; j <= height ; j += bar.SIZE) {
            g.drawLine(0, j, width , j);
        }
	}
	
	Boolean newBar = false;
	
	//listens the spacebar key.
	class KeyHandler extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            if(event.getKeyCode() == KeyEvent.VK_SPACE) {
            	blueBar.playSound();
            	newBar = true;
            	level ++;
            	speed-=30;
            }
               
        }
    }
	
	//main method
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Stacker");
		frame.setLayout(new GridLayout());
		
		
		JLabel background = new JLabel(new ImageIcon("background.png"));
		background.setLayout(new GridLayout());
		
		Stacker game = new Stacker();
		background.add(game);
		
		JLabel label = new JLabel("Score: " + game.score);
		label.setFont(label.getFont().deriveFont(50.0f));
		
		
	
		frame.add(label);
		frame.add(background);
		frame.setBackground(Color.ORANGE);
		
		JOptionPane.showMessageDialog(null, 			  "<html> An evil wizard kidnapped the princess and put her to an island."
														 + "<br/> Build a bridge to the island with brown blocks and save her!"
														 + "<br/> But be careful! Because of the wizard's black magic protecting "
														 + "<br/> the island, blocks gets narrower and faster when you get close."
														 + "<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;GOOD LUCK </html>");
	
		
        

       
        
		frame.setSize(350+1+350+1,650+23);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.requestFocusInWindow();
        
        //runs the game until you lose or win.
        while(true){
        	game.moveOneFrame(bar.SIZE);
        	game.winCondition();

        	Thread.currentThread().sleep(speed);
        	game.score -= 2;
        	
        	label.setText("Score: " + game.score);
        	
        	
        }
       
	}

}
