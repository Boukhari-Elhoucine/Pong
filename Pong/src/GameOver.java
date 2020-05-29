import java.awt.Color;
import java.awt.Graphics;

public class GameOver extends State{
	private Game game;
	private  KeyManager manager;
	public GameOver(Game game) {
		this.game = game;
		manager  = new KeyManager();
	}
	@Override
	public void tick() {
		manager.tick();
		game.Stop();
		if(manager.restart) {
			game.Start();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.drawString("Game Over",Window.width/2,Window.height/2);
		
	}


}
