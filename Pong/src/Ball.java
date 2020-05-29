import java.awt.Color;
import java.awt.Graphics;

public class Ball  extends Entity{
	public Ball(int xcor,int ycor,double xvel,double yvel) {
		super(xcor,ycor,xvel,yvel);
	}
	@Override
	public void tick() {
		if(xvel > 5.0) xvel=5.0;
		xcor +=xvel;
		ycor +=yvel;
		if(ycor <10) {
			yvel =-yvel;
		}
		else if(ycor >Window.height -10)yvel =-yvel;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(xcor-8, ycor-8,16, 16);
	}
	public void checkCollision(Player p1, Player2 p2) {
		if(this.xcor <28) {
			if(ycor <=p1.ycor+80 && ycor>= p1.ycor) {
				xvel *=1.1;
				xvel =-xvel;
			}
		}
		else if(this.xcor >p2.xcor -8 && this.ycor <=p2.ycor+80 && this.ycor>= p2.ycor) {
			xvel *=1.1;
			xvel = -xvel;
		}
	}
	
}
