	Barış Yağan Stacker Game
	
![Screenshot of the gameplay](/ScreenShot.png)
	
In my game there is a rectangle bar consist of 3 square and it is moving from a side to other side on grid. 
When you hit to the spacebar key, bar stops and a new bar emerges on top of the bar stopped. When a bar is 
stopped if there is no bar under the any part of it, these parts disappear and length of bar gets smaller. 
Aim of game is reaching to the top by pilling up bars in a row. Also when you go higher, bars get smaller 
and move faster.  
(My package named Stacker consists of src and bin files, background.png, fail.wav, win.wav, button-22.wav, readme.txt)

Class: Stacker<br>
Methods<br>
public Stacker() //constructor<br>
public void paint(Graphics g) //paints everything.<br>
public void moveOneFrame(int size) //makes game to flow according to stacker game rules.<br>
public void winCondition() //states if you win the game.<br>
private void drawGridOn(Graphics g )//draws grid.<br>
public void keyPressed(KeyEvent event) //listens the spacebar key.<br>
public static void main(String[] args) //sets the frame and runs the game until you lose or win.<br>
<br>
Class: bar<br>
Methods<br>
public bar(int n,int x,int y) //constructor<br>
public void drawOn(Graphics g) //draws squares to for brown bars.<br>
public void moveTo(int size) //makes bars to move from one side to other<br>
public void goUp() //makes bar to go up<br>
// getters and setters<br>
public int getX()<br>
public void setX(int x)<br>
public int getY()<br>
public void setY()<br>
public int constantX()<br>
public int constantY()<br>
public int constantN()<br>
public int getN()<br>
public int getXlast() //returns the x coordinate of last square of bar.<br>
public int constantXlast()<br>
public void setN(int n) //sets the number of square that bar will have.<br>
//plays sounds when when a bar stacked, game is lost or wined.<br>
public void playSound()<br>
public void playFailure()<br>
public void playWin()<br>
