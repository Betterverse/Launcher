package org.spoutcraft.launcher.technic.skin;

import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JTextArea;

import org.spoutcraft.launcher.skin.MetroLoginFrame;
import org.spoutcraft.launcher.skin.components.LiteButton;
import org.spoutcraft.launcher.technic.rest.RestNews;

public class NewsBox extends JComponent {
	private static final long serialVersionUID = 1L;

	private static int HEIGHT = 40;
	private JTextArea messageArea;
	private LiteButton title;

	public NewsBox() {
		initComponents();
	}

	public void initComponents() {
		title = new LiteButton("");
		title.setBounds(0, 0, 660, 20);
		title.setFont(MetroLoginFrame.getMinecraftFont(14));
		title.setForeground(Color.BLACK);

		messageArea = new JTextArea();
		messageArea.setBounds(0, 20, 660, 20);
		messageArea.setFont(MetroLoginFrame.getOtherFont(14));
		messageArea.setForeground(new Color(230, 230, 230));
		messageArea.setBackground(new Color(0, 0, 0, 100));
		messageArea.setOpaque(true);
		messageArea.setDisabledTextColor(new Color(230, 230, 230));
		messageArea.setEnabled(false);
		messageArea.setLineWrap(true);
		messageArea.setWrapStyleWord(true);
		
		add(title);
		add(messageArea);
	}

	public void addNews(RestNews news) {
		title.setText(news.getTitle());
		news.updateNewsPane(messageArea);
	}
}
