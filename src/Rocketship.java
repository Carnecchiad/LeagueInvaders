import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	boolean shoot;
	public float stamina;
	Rocketship(int x, int y, int width, int height, int speed){
		super();
		stamina = 100;
		speed = 5;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	void update(){
		super.update();
		if(up){
			y-=5;
		}
		if(down){
			y+=5;
		}
		if(left){
			x-=5;
		}
		if(right){
			x+=5;
		}
		if(stamina<101){
		stamina+=0.1;
		}
		
	}	
	
	void draw(Graphics g){
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);

	}
}
