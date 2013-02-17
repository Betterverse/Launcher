package org.spoutcraft.launcher.skin.components;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.spoutcraft.launcher.skin.MetroLoginFrame;

public class BackgroundImage extends JLabel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;

	private final MetroLoginFrame frame;
	private int mouseX = 0, mouseY = 0;
	private AnimatedBackground background;

	public BackgroundImage(MetroLoginFrame frame, int width, int height) {
		this.frame = frame;
		setVerticalAlignment(SwingConstants.CENTER);
		setHorizontalAlignment(SwingConstants.CENTER);
		setBounds(0, 0, width, height);

		setVerticalAlignment(SwingConstants.TOP);
		setHorizontalAlignment(SwingConstants.LEFT);
		setIcon(MetroLoginFrame.getIcon("background.jpg", width, height));
		background = new AnimatedBackground(this);
		background.setIcon(MetroLoginFrame.getIcon("background.jpg", width, height));
		background.setBounds(0, 0, width, height);
		this.add(background);
	}

	public void changeBackground(String name, Icon icon) {
		background.changeIcon(name, icon);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		frame.setLocation(e.getXOnScreen() - mouseX, e.getYOnScreen() - mouseY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
