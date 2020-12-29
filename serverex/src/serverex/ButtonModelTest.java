package serverex;

import javax.swing.*;

public class ButtonModelTest extends JFrame {
	JButton ok;

	public ButtonModelTest() {
		super("ButtonModel 테스트");
		ImageIcon rai = new ImageIcon("rai.gif");
		ok = new JButton("OK", rai);
		ok.setRolloverIcon(rai);
		ok.setPressedIcon(rai);
		CountButtonModel model = new CountButtonModel(ok);

		getContentPane().add("South", ok);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String args[]) {
		new ButtonModelTest();
	}
}