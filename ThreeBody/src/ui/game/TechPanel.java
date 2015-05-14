package ui.game;

import java.awt.Graphics;

import javax.swing.JPanel;

import ui.FrameUtil;

public class TechPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	
	public TechPanel() {
		this.setLayout(null);
		setBounds(100, 510, 140, 32);
	}
	
	@Override
	public void paint(Graphics g) {
		
		FrameUtil.drawNumberLeftPad(60, 0, 233, 3, g);
	}
}
