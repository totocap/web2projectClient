package fr.univ.rouen.clientWeb.view;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import fr.univ.rouen.clientWeb.controller.ClientWeb;
import fr.univ.rouen.clientWeb.model.Resume;
import fr.univ.rouen.clientWeb.model.ResumeList;

public class ResumePanel extends JPanel {
	private JTextPane textPane;
	private JScrollPane jS;

	public ResumePanel() {
		textPane = new JTextPane();
		ResumeList listStb = ClientWeb.getInstance().getResumePage();
		String s = "";
		for (Resume stb : listStb.getResume()) {
			s += stb.toString() + "\n";
		}
		textPane.setText(s);
		textPane.setEditable(false);
		jS = new JScrollPane(textPane);
		this.add(jS);

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
				jS.setPreferredSize(ResumePanel.this.getSize());
				ResumePanel.this.repaint();
			}

		});
	}
}
