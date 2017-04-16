import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{

	Rocketship(int x, int y, int width, int height, int speed){
		speed = 5;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void update(){
		
	}
	void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
