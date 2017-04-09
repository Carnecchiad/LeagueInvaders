import javax.swing.*;
public class LeagueInvaders {
	JFrame frame;
	GamePanel panel;
	final int width = 500;
	final int height = 800;
	LeagueInvaders(){
		frame = new JFrame();
		panel = new GamePanel();
		frame.add(panel);
		frame.addKeyListener(panel);
		setup();
		panel.startGame();
		
	}
	void setup(){
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		LeagueInvaders game = new LeagueInvaders();
		
	}
}
