package fr.univ.rouen.clientWeb.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import fr.univ.rouen.clientWeb.controller.ClientWeb;
import fr.univ.rouen.clientWeb.model.StbModelVO;

public class StbByIdPanel extends JPanel {
	private JTextField numStb;
	private JButton execute;
	private JTextPane result;
	
	public StbByIdPanel() {
		createView();
        placeComponents();
        createController();
	}

	private void createView() {
		numStb =  new JTextField(10);
		numStb.setText("Id");
		execute = new JButton("Research");
		result = new JTextPane();
		result.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() * 8 / 10));
	}
	
	private void placeComponents() {
		JPanel p = new JPanel(new FlowLayout()); {
			p.add(numStb);
			p.add(execute);
		}
		this.add(p, BorderLayout.NORTH);
		
		this.add(result, BorderLayout.CENTER);
	}
	
	private void createController() {
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				result.setPreferredSize(new Dimension(StbByIdPanel.this.getWidth(), StbByIdPanel.this.getHeight() * 8 / 10));
				StbByIdPanel.this.repaint();
			}
		});
		
		execute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numStb.getText().equals("")) {
					result.setText("Veuillez entrer un id de STB.");
				} else {
					try {
						StbModelVO stb = ClientWeb.getSTBById(numStb.getText());
						result.setText(stb.toString());
					} catch(Exception e1) {
						result.setText(e1.getMessage());
					}
				}
			}
		});
	}
}
