import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Alien extends GameObject {
	
	double time = 0;
	Alien(int x, int y, int width, int height){
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void update(){
		super.update();
		y++;
		
		
			x+= (int)(Math.sin(time) * 3);
			time+= .1;
		}
		
	
	void draw(Graphics g){
		g.drawImage(GamePanel.alienImg, x, y, width, height, null);

	}
}
