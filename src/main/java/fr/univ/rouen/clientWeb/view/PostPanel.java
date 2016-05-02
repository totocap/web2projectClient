package fr.univ.rouen.clientWeb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class PostPanel extends JPanel {
	private JButton depot;
	
	private JTextField titre;
	private JTextField version;
	private JTextField date;
	private JTextPane description;
	
	private JTextField entiteClient;
	private JComboBox<String> genreClient;
	private JTextField nomClient;
	private JTextField prenomClient;
	private JTextField codePostalClient;
	
	private JComboBox<String> genreMembre;
	private JTextField nomMembre;
	private JTextField prenomMembre;
	private JButton ajoutMembre;
	private JTextPane listeMembres;
	
	private JTextPane descriptionFonctionnalite;
	private JTextField prioriteFonctionnalite;
	private JTextField identifiantExigence;
	private JTextField prioriteExigence;
	private JTextPane descriptionExigence;
	private JButton ajoutExigence;
	private JButton ajoutFonctionnalite;
	private JTextPane listeFonctionnalites;
	
	public PostPanel() {
		createView();
        placeComponents();
        createController();
	}

	private void createView() {
		depot = new JButton("Deposer");
		
		titre = new JTextField(10);
		version = new JTextField(10);
		date = new JTextField(20);
		description = new JTextPane();
		
		entiteClient = new JTextField(10);
		genreClient = new JComboBox<String>();
		genreClient.addItem("Homme");
		genreClient.addItem("Femme");
		nomClient = new JTextField(10);
		prenomClient = new JTextField(10);
		codePostalClient = new JTextField(10);
		
		genreMembre = new JComboBox<String>();
		genreMembre.addItem("Homme");
		genreMembre.addItem("Femme");
		nomMembre = new JTextField();
		prenomMembre = new JTextField();
		ajoutMembre = new JButton("Ajouter");
		listeMembres = new JTextPane();
		
		descriptionFonctionnalite = new JTextPane();
		prioriteFonctionnalite = new JTextField(10);
		identifiantExigence = new JTextField(10);
		prioriteExigence = new JTextField(10);
		descriptionExigence = new JTextPane();
		ajoutExigence = new JButton("Ajouter");
		ajoutFonctionnalite = new JButton("Ajouter");
		listeFonctionnalites = new JTextPane();
	}

	private void placeComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel p = new JPanel(new GridBagLayout()); {
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			p.add(new JLabel("Titre : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 0;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(titre, c);
			
			c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 1;
			p.add(new JLabel("Version : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 1;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(version, c);
			
			c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 2;
			p.add(new JLabel("Date : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(date, c);
			
			c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 3;
			p.add(new JLabel("Description : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 3;
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.;
			c.weighty = 1.;
			p.add(description, c);
		}
		p.setBorder(BorderFactory.createTitledBorder("General"));
		this.add(p);
		
		p = new JPanel(new GridBagLayout()); {
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			p.add(new JLabel("Entite : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 0;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(entiteClient, c);
			
			c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 2;
			p.add(new JLabel("Nom : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 2;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(nomClient, c);
			
			c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 3;
			p.add(new JLabel("Prenom : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 3;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(prenomClient, c);
			
			c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 4;
			p.add(new JLabel("Genre : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 4;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(genreClient, c);
			
			c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 5;
			p.add(new JLabel("Code postal : "), c);
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 5;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.;
			p.add(codePostalClient, c);
		}
		p.setBorder(BorderFactory.createTitledBorder("Client"));
		this.add(p);
		
		p = new JPanel(new GridBagLayout()); {
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.;
			c.weighty = 1.;
			JPanel q = new JPanel(new GridBagLayout()); {
				GridBagConstraints c2 = new GridBagConstraints();
				c2.gridx = 0;
				c2.gridy = 0;
				q.add(new JLabel("Nom : "), c2);
				c2 = new GridBagConstraints();
				c2.gridx = 1;
				c2.gridy = 0;
				c2.fill = GridBagConstraints.HORIZONTAL;
				c2.weightx = 1.;
				q.add(nomMembre, c2);
				
				c2 = new GridBagConstraints();
				c2.gridx = 0;
				c2.gridy = 1;
				q.add(new JLabel("Prenom : "), c2);
				c2 = new GridBagConstraints();
				c2.gridx = 1;
				c2.gridy = 1;
				c2.fill = GridBagConstraints.HORIZONTAL;
				c2.weightx = 1.;
				q.add(prenomMembre, c2);
				
				c2 = new GridBagConstraints();
				c2.gridx = 0;
				c2.gridy = 2;
				q.add(new JLabel("Genre : "), c2);
				c2 = new GridBagConstraints();
				c2.gridx = 1;
				c2.gridy = 2;
				c2.fill = GridBagConstraints.HORIZONTAL;
				c2.weightx = 1.;
				q.add(genreMembre, c2);
				
				c = new GridBagConstraints();
				c2.gridx = 1;
				c2.gridy = 3;
				c2.fill = GridBagConstraints.HORIZONTAL;
				c2.weightx = 1.;
				q.add(ajoutMembre, c2);
			}
			p.add(q, c);
			
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 0;
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.;
			c.weighty = 1.;
			p.add(listeMembres, c);
		}
		p.setBorder(BorderFactory.createTitledBorder("Equipe"));
		this.add(p);
		
		p = new JPanel(new GridBagLayout()); {
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 0.;
			c.weighty = 1.;
			JPanel q = new JPanel(new GridBagLayout()); {
				GridBagConstraints c2 = new GridBagConstraints();
				c2.gridx = 0;
				c2.gridy = 0;
				q.add(new JLabel("Description : "), c2);
				c2 = new GridBagConstraints();
				c2.gridx = 1;
				c2.gridy = 0;
				c2.fill = GridBagConstraints.HORIZONTAL;
				c2.weightx = 1.;
				q.add(descriptionFonctionnalite, c2);
				
				c2 = new GridBagConstraints();
				c2.gridx = 0;
				c2.gridy = 1;
				q.add(new JLabel("Priorite : "), c2);
				c2 = new GridBagConstraints();
				c2.gridx = 1;
				c2.gridy = 1;
				c2.fill = GridBagConstraints.HORIZONTAL;
				c2.weightx = 1.;
				q.add(prioriteFonctionnalite, c2);
				
				JPanel r = new JPanel(new GridBagLayout()); {
					GridBagConstraints c3 = new GridBagConstraints();
					c3.gridx = 0;
					c3.gridy = 0;
					r.add(new JLabel("Identifiant : "), c3);
					c3 = new GridBagConstraints();
					c3.gridx = 1;
					c3.gridy = 0;
					c3.fill = GridBagConstraints.HORIZONTAL;
					c3.weightx = 1.;
					r.add(identifiantExigence, c3);
					
					c3 = new GridBagConstraints();
					c3.gridx = 0;
					c3.gridy = 1;
					r.add(new JLabel("Description : "), c3);
					c3 = new GridBagConstraints();
					c3.gridx = 1;
					c3.gridy = 1;
					c3.fill = GridBagConstraints.HORIZONTAL;
					c3.weightx = 1.;
					r.add(descriptionExigence, c3);
					
					c3 = new GridBagConstraints();
					c3.gridx = 0;
					c3.gridy = 2;
					r.add(new JLabel("Priorite : "), c3);
					c3 = new GridBagConstraints();
					c3.gridx = 1;
					c3.gridy = 2;
					c3.fill = GridBagConstraints.HORIZONTAL;
					c3.weightx = 1.;
					r.add(prioriteExigence, c3);
					
					c3 = new GridBagConstraints();
					c3.gridx = 1;
					c3.gridy = 3;
					c3.fill = GridBagConstraints.HORIZONTAL;
					c3.weightx = 1.;
					r.add(ajoutExigence, c3);
				}
				r.setBorder(BorderFactory.createTitledBorder("Exigence"));
				c2 = new GridBagConstraints();
				c2.gridx = 0;
				c2.gridy = 2;
				c2.gridwidth = 2;
				c2.fill = GridBagConstraints.BOTH;
				c2.weightx = 1.;
				c2.weighty = 1.;
				q.add(r, c2);
				
				c2 = new GridBagConstraints();
				c2.gridx = 1;
				c2.gridy = 3;
				c2.fill = GridBagConstraints.HORIZONTAL;
				c2.weightx = 1.;
				q.add(ajoutFonctionnalite, c2);
			}
			p.add(q, c);
			
			c = new GridBagConstraints();
			c.gridx = 1;
			c.gridy = 0;
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.;
			c.weighty = 1.;
			p.add(listeFonctionnalites, c);
		}
		p.setBorder(BorderFactory.createTitledBorder("Fonctionnalite"));
		this.add(p);
		
		p = new JPanel(); {
			p.add(depot);
		}
		this.add(p);
	}

	private void createController() {
		// TODO Auto-generated method stub
		
	}
}
