import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game  implements Runnable{
	private Window window;
	private Thread thread;
	private Graphics g;
	private BufferStrategy bs;
	private boolean running = false;
	private State game;
	private Player player1;
	private Player2 player2;
	private Ball ball;
	private State gameover;
	public Game() {
		init();
	}
	public void init() {
		window = new Window();
		ball =new Ball(Window.width/2,Window.height/2,-2,1);
		player2 =new Player2(Window.width -20,Window.height/2,2,2,ball);
		player1 = new Player(0,Window.height/2,2,2);
		window.getFrame().addKeyListener(player1.getManager());
		gameover = new GameOver(this);
		game = new GameState(player1,player2,ball,gameover);
		State.setState(game);
	}
	public void tick() {
		if(State.getState() !=null) {
			State.getState().tick();;
		}
		
	}
	public void render() {
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g= bs.getDrawGraphics();
		g.setColor(Color.red);
		g.clearRect(0,0,Window.width,Window.height);
		if(State.getState()!=null) {
			State.getState().render(g);
		}
		g.dispose();
		bs.show();
	}
	public synchronized  void Start() {
		if(running) return;
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	public synchronized void Stop() {
		if(!running) return;
		try {
			thread.join();
			running=false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		 double timePerTick = 1000000000/60.0;
		 double delta = 0.0;
		 long lastTime = System.nanoTime();
		 long now;
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
		 if(delta >= 1) {
			 tick();
			 render();
			 delta--;
		 }
		}
	}
}
