import java.awt.Color;
import java.awt.Graphics;

public class Player2 extends Entity {
	private Ball  ball;
	public Player2(int xcor,int ycor,double xvel,double yvel,Ball b) {
		super(xcor,ycor,xvel,yvel);
		ball =b;
	}
	@Override
	public void tick() {
		ycor = ball.ycor -50;
		if(ycor <0 ) {
			ycor=0;
		}
		else if(ycor+80 >Window.height) {
			ycor= Window.height -80;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(xcor,ycor , 20, 80);
	}

}
