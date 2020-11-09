package serverex;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x, y;

	public Canvas() {
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		g.drawOval(x, y, 100, 110);
	}

	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}

}