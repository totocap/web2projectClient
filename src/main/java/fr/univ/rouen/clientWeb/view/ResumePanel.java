package fr.univ.rouen.clientWeb.view;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import fr.univ.rouen.clientWeb.controller.ClientWeb;
import fr.univ.rouen.clientWeb.model.Resume;
import fr.univ.rouen.clientWeb.model.ResumeList;

public class ResumePanel extends JPanel {
	private JTextPane textPane;
	
	public ResumePanel() {
		textPane = new JTextPane();
		ResumeList listStb = ClientWeb.getInstance().getResumePage();
		String s = "";
		for (Resume stb : listStb.getResume()) {
			s += stb.toString() + "\n";
		}
		textPane.setText(s);
		this.add(textPane);
		
		this.addComponentListener(new ComponentAdapter() {
			
			public void componentShown(ComponentEvent e) {
				ResumeList listStb = ClientWeb.getInstance().getResumePage();
				String s = "";
				for (Resume stb : listStb.getResume()) {
					s += stb.toString() + "\n";
				}
				textPane.setText(s);
			}
			
			public void componentResized(ComponentEvent e) {
				textPane.setPreferredSize(ResumePanel.this.getSize());
				ResumePanel.this.repaint();
			}
			
			
		});
	}
}
