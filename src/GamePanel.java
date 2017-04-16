import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
public class GamePanel extends JPanel implements ActionListener , KeyListener{
	Timer t = new Timer(1000/60,this);
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CURRENT_STATE = MENU_STATE;
	Font titleFont;
	Font smallFont;
	Rocketship ship = new Rocketship(250,700,50,50,5);
	GamePanel(){
		titleFont = new Font("Zapfino",Font.PLAIN, 48);
		smallFont = new Font("Arial",Font.PLAIN,22);
	}
	void updateMenuState(){
		
	}
	void updateGameState(){
		ship.update();
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
		ship.draw(g);
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
			ship.setY(ship.getY()-5);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			ship.setY(ship.getY()+5);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.setX(ship.getX()+5);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.setX(ship.getX()-5);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
}
