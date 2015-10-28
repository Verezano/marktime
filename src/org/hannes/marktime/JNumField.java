package org.hannes.marktime;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JNumField extends JTextField {
	static final long serialVersionUID=0x2341; 
	
	public JNumField(int max) {
		super();
		this.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
					(c == KeyEvent.VK_BACK_SPACE) ||
					(c == KeyEvent.VK_DELETE)) ||
					getText().length()>=max
				) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
	}

}