	Barış Yağan Stacker Game
	
![Screenshot of the gameplay](/ScreenShot.png)
	
In my game there is a rectangle bar consist of 3 square and it is moving from a side to other side on grid. 
When you hit to the spacebar key, bar stops and a new bar emerges on top of the bar stopped. When a bar is 
stopped if there is no bar under the any part of it, these parts disappear and length of bar gets smaller. 
Aim of game is reaching to the top by pilling up bars in a row. Also when you go higher, bars get smaller 
and move faster.  
(My package named Stacker consists of src and bin files, background.png, fail.wav, win.wav, button-22.wav, readme.txt)

Class: Stacker
Methods
public Stacker() //constructor
public void paint(Graphics g) //paints everything.
public void moveOneFrame(int size) //makes game to flow according to stacker game rules.
public void winCondition() //states if you win the game.
private void drawGridOn(Graphics g )//draws grid.
public void keyPressed(KeyEvent event) //listens the spacebar key.
public static void main(String[] args) //sets the frame and runs the game until you lose or win.

Class: bar
Methods
public bar(int n,int x,int y) //constructor
public void drawOn(Graphics g) //draws squares to for brown bars.
public void moveTo(int size) //makes bars to move from one side to other
public void goUp() //makes bar to go up
// getters and setters
public int getX()
public void setX(int x)
public int getY()
public void setY()
public int constantX()
public int constantY()
public int constantN()
public int getN()
public int getXlast() //returns the x coordinate of last square of bar. 
public int constantXlast()
public void setN(int n) //sets the number of square that bar will have.
//plays sounds when when a bar stacked, game is lost or wined.
public void playSound()
public void playFailure()
public void playWin()      
