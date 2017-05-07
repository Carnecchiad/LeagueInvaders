import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class GamePanel extends JPanel implements ActionListener , KeyListener{
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;
	public static BufferedImage powerUpImg;
	Timer t = new Timer(1000/60,this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	boolean canFire;
	int CURRENT_STATE = MENU_STATE;
	ObjectManager manager= new ObjectManager();
	GameObject meter = new GameObject();
	Font titleFont;
	Font smallFont;
	Rocketship ship = new Rocketship(250,700,90,120,5);
	GamePanel(){
		canFire = true;
		try {
			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
			powerUpImg = ImageIO.read(this.getClass().getResourceAsStream("powerup.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		titleFont = new Font("Zapfino",Font.PLAIN, 48);
		smallFont = new Font("Arial",Font.PLAIN,22);
		manager.addObject(ship);
	}
	void updateMenuState(){
		
	}
	void updateGameState(){
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if(!ship.isAlive){
			CURRENT_STATE = END_STATE;
			manager.reset();
			ship = new Rocketship(250,700,90,120,5);
			manager.addObject(ship);
			manager.getScore();
			meter.update();
		}
	}
	void updateEndState(){
		
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("League Invaders", 35, 200);
		g.setFont(smallFont);
		g.drawString("Press Enter to Start", 170, 240);
		g.drawString("Space for Help", 170, 270);
		
	}
	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
		g.drawImage(GamePanel.spaceImg, 0, 0, 500, 800, null);
		if(ship.stamina > 50){
		g.setColor(Color.GREEN);
		}
		if(ship.stamina > 25 && ship.stamina < 50){
		g.setColor(Color.ORANGE);
		}
		if(ship.stamina < 25){			
		g.setColor(Color.RED);
		}
		g.fillRect(100,20,(int) ship.stamina,20);
		g.drawImage(GamePanel.powerUpImg,200,200,200,200,null);
		manager.draw(g);
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("FIN", 150, 200);
	}
	
	
	
	public static void main(String[] args) {
	}
	
	public void paintComponent(Graphics g){
		if(CURRENT_STATE == MENU_STATE){
			drawMenuState(g);
		}else if(CURRENT_STATE == GAME_STATE){
			drawGameState(g);
		}else if(CURRENT_STATE == END_STATE){
			drawEndState(g);
		}
	}
	void startGame(){
	 t.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(CURRENT_STATE == MENU_STATE){
			updateMenuState();
		}else if(CURRENT_STATE == GAME_STATE){
			updateGameState();
		}else if(CURRENT_STATE == END_STATE){
			updateEndState();
		}
		
		repaint();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			CURRENT_STATE++;
		}
		if(CURRENT_STATE > END_STATE){
			CURRENT_STATE = MENU_STATE;
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			ship.down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.right = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.left = true;
		}
		if(ship.stamina> 9){
		if(e.getKeyCode() == KeyEvent.VK_SPACE && canFire){
			manager.addObject(new Projectile(ship.x + 20, ship.y, 30, 50));
			canFire = false;
			ship.shoot = true;
			ship.stamina -=10;
		}
		}
		if(ship.shoot){
			

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			ship.down = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.right = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.left = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			ship.shoot = false;
			canFire = true;
		}
		
	}
}
