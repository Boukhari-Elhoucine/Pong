import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State {
	
	private Player player1;
	private Player2 player2;
	private Ball ball;
	private State gameover;
	public GameState(Player p1,Player2 p2,Ball ball,State gameover) {
		player1=p1;
		player2=p2;
		this.ball = ball;
		this.gameover = gameover;
	}
	@Override
	public void tick() {
		if(ball.xcor  <=-8 || ball.xcor >= Window.width +8) {
			State.setState(gameover);
		}
		else {
			player1.tick();
			player2.tick();
			ball.tick();
			ball.checkCollision(player1, player2);
		}
	}

	@Override
	public void render(Graphics g) {
		player1.render(g);
		player2.render(g);
		ball.render(g);
	}
	
}
