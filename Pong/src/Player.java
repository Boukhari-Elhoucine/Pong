import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity{
	private KeyManager manager;
	public Player(int xcor,int ycor,double xvel,double yvel) {
		super(xcor,ycor,xvel,yvel);
		manager = new KeyManager();
	}
	@Override
	public void tick() {
		if(ycor <0 ) {
			ycor=0;
		}
		else if(ycor+80 >Window.height) {
			ycor= Window.height -80;
		}
		manager.tick();
		if(yvel >5.0 ) {
			yvel =5.0;
		}
		if(manager.up) {
			ycor += -yvel;
			yvel +=0.5;
		}
		if(manager.down)
			ycor +=yvel;
			yvel += 0.5;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(xcor,ycor , 20, 80);
	}
	public KeyManager getManager() {
		return manager;
	}
}
