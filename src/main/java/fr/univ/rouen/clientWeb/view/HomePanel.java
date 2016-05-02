package fr.univ.rouen.clientWeb.view;

import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import fr.univ.rouen.clientWeb.controller.ClientWeb;

public class HomePanel extends JPanel {
	private JTextPane textPane;
	
	public HomePanel() {
		textPane = new JTextPane();
		textPane.setContentType("text/html");
		textPane.setText(ClientWeb.getInstance().getFrontPage());
		this.add(textPane);
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				textPane.setPreferredSize(HomePanel.this.getSize());
				HomePanel.this.repaint();
			}
		});
	}
	
	
}
