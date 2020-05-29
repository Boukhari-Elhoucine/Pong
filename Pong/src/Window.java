import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	public static String title ="pong";
	public static int width=800, height=500;
	private JFrame frame;
	private Canvas canvas;
	public Window() {
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setBackground(Color.BLACK);
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		frame.add(canvas);
		frame.pack();
	}
	public JFrame getFrame() {
		return frame;
	}
	public Canvas getCanvas() {
		return canvas;
	}
}
