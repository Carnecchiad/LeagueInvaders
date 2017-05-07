import java.awt.Graphics;

public class Powerup extends GameObject{
	String type;
	Powerup(int x, int y, int width, int height, String type){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
	}
	void update(){
		
	}
	void draw(Graphics g){
		g.drawImage(GamePanel.powerUpImg, x, y, width, height, null);
	}
}
