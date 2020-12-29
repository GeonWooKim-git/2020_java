package serverex;

import java.awt.*;
import javax.swing.*;

public class CountButtonModel extends DefaultButtonModel {
	private int count;
	private JButton btn;

	public CountButtonModel(JButton btn) {
		this.btn = btn;
		btn.setModel(this);
	}

	public void setPressed(boolean b) {
		if (b) {
			count = ++count % 4;
			switch (count) {
			case 0:
				btn.setBackground(Color.lightGray);
				break;
			case 1:
				btn.setBackground(Color.green);
				break;
			case 2:
				btn.setBackground(Color.red);
				break;
			case 3:
				btn.setBackground(Color.yellow);
			}
		}
	}
}
