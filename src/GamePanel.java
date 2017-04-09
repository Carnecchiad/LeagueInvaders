import java.awt.Color;
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
	
	GamePanel(){
		
	}
	void updateMenuState(){
		
	}
	void updateGameState(){
		
	}
	void updateEndState(){
		
	}
	void drawMenuState(Graphics g){
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, 500, 800);
	}
	void drawGameState(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 800);
	}
	void drawEndState(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
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
		
		if(CURRENT_STATE > END_STATE){
			CURRENT_STATE = MENU_STATE;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
}
