package serverex;

import javax.swing.*;
import java.awt.event.*;

public class WhiteboardClient extends JFrame implements ActionListener {
	private WhiteboardCanvas canvas;
	private JButton line, oval, clear, rect, save, open, print;

	public WhiteboardClient(String host, int port) {
		super("화이트보드 클라이언트");
		JToolBar tools = new JToolBar();
		line = new JButton(" 선 ");
		line.addActionListener(this);
		oval = new JButton(" 원 ");
		oval.addActionListener(this);
		rect = new JButton("사각형");
		rect.addActionListener(this);
		clear = new JButton("지우기");
		clear.addActionListener(this);
		save = new JButton("저장");
		save.addActionListener(this);
		open = new JButton("열기");
		open.addActionListener(this);
		print = new JButton("인쇄");
		print.addActionListener(this);
		tools.add(line);
		tools.add(oval);
		tools.add(rect);
		tools.addSeparator();
		tools.add(clear);
		tools.add(save);
		tools.add(open);
		tools.add(print);

		canvas = new WhiteboardCanvas(host, port);

		getContentPane().add("North", tools);
		getContentPane().add("Center", canvas);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		Object c = e.getSource();
		if (c == line) {
			canvas.setMode(WhiteboardCanvas.LINE);
		} else if (c == oval) {
			canvas.setMode(WhiteboardCanvas.CIRCLE);
		} else if (c == rect) {
			canvas.setMode(WhiteboardCanvas.RECT);
		} else if (c == clear) {
			canvas.clear();
		}else if (c == save) {
			canvas.save();
		}
		else if (c == open) {
			canvas.open();
		}
		else if (c == print) {
			canvas.print();
		}
	}

	public static void main(String args[]) {
		new WhiteboardClient("localhost", 9850);
	}
}