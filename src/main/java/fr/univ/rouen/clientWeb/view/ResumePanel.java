package fr.univ.rouen.clientWeb.view;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import fr.univ.rouen.clientWeb.controller.ClientWeb;
import fr.univ.rouen.clientWeb.model.StbListVO;
import fr.univ.rouen.clientWeb.model.StbModelVO;

public class ResumePanel extends JPanel {
	private JTextPane textPane;
	
	public ResumePanel() {
		textPane = new JTextPane();
		StbListVO listStb = ClientWeb.getInstance().getResumePage();
		String s = "";
		for (StbModelVO stb : listStb.getStb()) {
			s += stb.toString() + "\n";
		}
		textPane.setText(s);
		this.add(textPane);
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				textPane.setPreferredSize(ResumePanel.this.getSize());
				ResumePanel.this.repaint();
			}
		});
	}
}
