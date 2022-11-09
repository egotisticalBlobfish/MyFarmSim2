package Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
//extends JPanel- in order to set the background color
//implements Runnable in order to access the Thread
public class GamePanel extends JPanel implements Runnable{

	//screen settings
	final int originalTileSize= 16; // 16x16 tile the average size of player character 
	//16 bit pixels 
	final int scale= 3;
	
	final int tileSize= originalTileSize * scale;// 48x48 scale tile
	//how many tiles be displayed on my screen
	final int maxScreenCol= 16;
	final int maxScreenRow= 12;
	final int screenWidth= tileSize * maxScreenCol; //768 pixels
	final int screenHeight= tileSize * maxScreenRow; //576 pixels
	
	Thread gameThread;//game time loop in the GamePanel
	
	//construct 
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		
		// all of the drawing 
		//from this component will be 
		//done in an offscreen painting buffer
		//which improves the game's rendering
		this.setDoubleBuffered(true);
		
	}

	public void startGameThread() {
		//instantiate gameTread
		gameThread= new Thread(this);
		gameThread.start();
	}
	@Override
	//when gameThread is called it operates the public class run()
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
			
			
	
	
	

}
