package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
//extends JPanel- in order to set the background color
//implements Runnable in order to access the Thread
public class GamePanel extends JPanel implements Runnable{

	private static final long serialVersionUID = -3065986160485743401L;
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
		
		//Fps
		int FPS=60;
		
		//instantiate
		KeyHandler keyH= new KeyHandler();
		
		Thread gameThread;//game time loop in the GamePanel
		
		//default player's position
		int playerX = 100;
		int playerY = 100;
		int playerSpeed = 4;
		
		//construct 
		public GamePanel() {
			this.setPreferredSize(new Dimension(screenWidth,screenHeight));
			this.setBackground(Color.black);
			
			this.setDoubleBuffered(true);
			this.addKeyListener(keyH);
			this.setFocusable(true);
			
				
		}

		public void startGameThread() {
			//instantiate gameTread
			gameThread= new Thread(this);
			gameThread.start();
		}
		@Override
		//when gameThread is called it operates the public class run()
		public void run() {
			
			//draws the screen for .0166667 nanoseconds
			
			double drawInterval=1000000/FPS;
			double delta=0;
			long lastTime=System.nanoTime();
			long currentTime;
		
			
			
			
			while(gameThread != null) {
				
				currentTime=System.nanoTime();
				
				delta+=(currentTime - lastTime)/drawInterval;
			
				lastTime=currentTime;
				
				if(delta >= 1 ) {
					update();
					
					repaint();
					delta--;
				}
				

			}
			
		}
		// updates the player's position/ coordinates
		public void update() {
			
			if(keyH.upPressed == true) {
				
				playerY-=playerSpeed;
				
			}
			else if(keyH.downPressed == true) {
				
				playerY+=playerSpeed;
				
			}
			else if (keyH.leftPressed == true) {
				
				playerX-=playerSpeed;
				
			}
			else if (keyH.rightPressed == true) {
				
				playerX+=playerSpeed;
				
			}
			
		}
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			Graphics2D g2= (Graphics2D)g;
			
			g2.setColor(Color.white);
			
			g2.fillRect(playerX, playerY, tileSize, tileSize);
			
			g2.dispose();
		}
		
				
	

	}
