package stacker;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


/*
 * Baris Yagan S5019 Department of Computer Science
 */

public class bar  {

	public static int SIZE = 50;
	protected Color color = new Color(176, 103, 82);
	private int y;
	private int x;
	private int n;
	public int direction = 1;

	//constructor
	public bar(int n,int x,int y){
		this.n=n;
		this.x=x;
		this.y=y;
	}
	//draws squares to for brown bars.
	public void drawOn(Graphics g) {
       for(int i = 0; i < n; i++){
    	   g.setColor(color);
    	   g.fillRect(x+i*SIZE, y, SIZE, SIZE);
    	 
       }
    }
	
	
	
	//makes bars to move from one side to other
	public void moveTo(int size){
		if( ! ((x + SIZE < Stacker.width) && (x+(n-1)*SIZE > 0))){
			direction *= -1;
		}
		x+= direction*size;
	}
	
	//makes bar to go up 
	public void goUp(){
		if(Stacker.level == 5){
			if(n > 2) n = 2;
		}
		else if(Stacker.level == 11){
			n = 1;
		}
		x -= 50;
		y -= 50;
	}
	
	// getters and setters
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int constantX(){
		final int constantX = this.getX() ;
		return constantX;
	}

	public int constantY(){
		final int constantY = this.getY() ;
		return constantY;
	}
	
	public int constantN(){
		final int constantN = this.getN();
		return constantN;
	}
	

	public int getN() {
		return n;
	}
	
	//returns the x coordinate of last square of bar.
	public int getXlast(){
		return x+(n-1)*SIZE;
	}
	
	public int constantXlast(){
		final int constantXlast = this.getXlast();
		return constantXlast;
	}
	//sets the number of square that bar will have.
	public void setN(int n){
		this.n = n;
	}
	
	//plays sounds when when a bar stacked, game is lost or wined.
	
	public void playSound()
	{
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("button-22.wav"));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        }
    }
	
	public void playFailure()
    {
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("fail.wav"));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        }
    }
	
	public void playWin()
    {
        try 
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("win.wav"));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start( );
        }
        catch(Exception e)
        {
            System.out.println("Error with playing sound.");
        }
    }
}
