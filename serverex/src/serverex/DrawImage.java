package serverex;

import java.awt.*;
import javax.swing.*;
public class DrawImage extends JFrame {
	private Canvas paper;

	public DrawImage() {
		super("그림판");
		paper = new Canvas();
		getContentPane().add(paper, "Center");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		new DrawImage();
	}
}