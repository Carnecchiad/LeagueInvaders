
import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	boolean isAlive;
	Rectangle CollisionBox;
	int x;
	int y;
	int width;
	int height;
	GameObject(){
		isAlive = true;
		CollisionBox = new Rectangle(x,y,width,height);
		x = 10;
		y = 10;
	}
	void update(){
		CollisionBox.setBounds(x,y,width,height);
	}
	void draw(Graphics g){
			}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
