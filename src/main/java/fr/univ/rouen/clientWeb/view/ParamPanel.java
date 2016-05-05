package fr.univ.rouen.clientWeb.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.univ.rouen.clientWeb.controller.ClientWeb;

public class ParamPanel extends JPanel {
	private JTextField serverName;
	private JButton validate;

	public ParamPanel() {
		serverName = new JTextField(35);
		serverName.setText(ClientWeb.getInstance().getUri());
		validate = new JButton("Valider");

		JPanel p = new JPanel();
		{
			JPanel q = new JPanel();
			{
				q.add(new JLabel("Nom du serveur : "));
				q.add(serverName);
			}
			p.add(q);

			q = new JPanel();
			{
				q.add(validate);
			}
			p.add(q);
		}
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		this.add(p, BorderLayout.NORTH);

		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientWeb.getInstance().setUri(serverName.getText());
			}
		});
	}
}
