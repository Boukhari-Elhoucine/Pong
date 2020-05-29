import java.awt.Graphics;

public abstract class Entity {
	protected int xcor;
	protected int ycor;
	protected double xvel;
	protected double yvel;
	
	public Entity(int xcor,int ycor,double xvel,double yvel) {
		this.xcor = xcor;
		this.ycor = ycor;
		this.xvel = xvel;
		this.yvel = yvel;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
	public int getXcor() {
		return xcor;
	}
	public int getYcor() {
		return ycor;
	}
	public void setxVel(double xvel) {
		this.xvel = xvel;
	}
	public void setyVel(double yvel) {
		this.yvel=yvel;
	}
}
