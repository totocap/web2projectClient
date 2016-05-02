package fr.univ.rouen.clientWeb.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import fr.univ.rouen.clientWeb.controller.ClientWeb;
import fr.univ.rouen.clientWeb.model.Client;
import fr.univ.rouen.clientWeb.model.Contact;
import fr.univ.rouen.clientWeb.model.Exigence;
import fr.univ.rouen.clientWeb.model.Fonctionnalite;
import fr.univ.rouen.clientWeb.model.Membre;
import fr.univ.rouen.clientWeb.model.StbModelVO;
import fr.univ.rouen.clientWeb.model.Team;

public class PostPanel extends JPanel {
	private JButton depot;
	
	private JTextField titre;
	private JTextField version;
	private JTextField date;
	private JTextArea description;
	private JTextArea commentaire;
	
	private JTextField entiteClient;
	private JComboBox<String> genreClient;
	private JTextField nomClient;
	private JTextField prenomClient;
	private JTextField codePostalClient;
	
	private JComboBox<String> genreMembre;
	private JTextField nomMembre;
	private JTextField prenomMembre;
	private JButton ajoutMembre;
	private JTextArea listeMembres;
	
	private Team team;
	
	private JTextArea descriptionFonctionnalite;
	private JTextField prioriteFonctionnalite;
	private JTextField identifiantExigence;
	private JTextField prioriteExigence;
	private JTextArea descriptionExigence;
	private JButton ajoutExigence;
	private JButton ajoutFonctionnalite;
	private JTextArea listeFonctionnalites;
	
	private ArrayList<Fonctionnalite> fonctionnalites;
	private ArrayList<Exigence> exigences;
	
	public PostPanel() {
		team = new Team();
		fonctionnalites = new ArrayList<Fonctionnalite>();
		exigences = new ArrayList<Exigence>();
		
		createView();
        placeComponents();
        createController();
	}

	private void createView() {
		depot = new JButton("Deposer");
		
		titre = new JTextField(10);
		version = new JTextField(10);
		date = new JTextField(20);
		description = new JTextArea();
		description.setRows(2);
		commentaire = new JTextArea();
		commentaire.setRows(2);
		
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
		listeMembres = new JTextArea();
		listeMembres.setEditable(false);
		
		descriptionFonctionnalite = new JTextArea();
		descriptionFonctionnalite.setRows(2);
		prioriteFonctionnalite = new JTextField(10);
		identifiantExigence = new JTextField(10);
		prioriteExigence = new JTextField(10);
		descriptionExigence = new JTextArea();
		descriptionExigence.setRows(2);
		ajoutExigence = new JButton("Ajouter");
		ajoutFonctionnalite = new JButton("Ajouter");
		listeFonctionnalites = new JTextArea();
		listeFonctionnalites.setEditable(false);
	}

	private void placeComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel p = new JPanel(new GridBagLayout()); {
			addToPanel(p, new JLabel("Titre : "), 0, 0, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, titre, 1, 0, GridBagConstraints.HORIZONTAL, 1., 1.);
			
			addToPanel(p, new JLabel("Version : "), 0, 1, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, version, 1, 1, GridBagConstraints.HORIZONTAL, 1., 1.);

			addToPanel(p, new JLabel("Date : "), 0, 2, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, date, 1, 2, GridBagConstraints.HORIZONTAL, 1., 1.);
			
			addToPanel(p, new JLabel("Description : "), 0, 3, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, description, 1, 3, GridBagConstraints.HORIZONTAL, 1., 1.);
			
			addToPanel(p, new JLabel("Commentaire : "), 0, 4, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, commentaire, 1, 4, GridBagConstraints.HORIZONTAL, 1., 1.);
		}
		p.setBorder(BorderFactory.createTitledBorder("General"));
		this.add(p);
		
		p = new JPanel(new GridBagLayout()); {
			addToPanel(p, new JLabel("Entite : "), 0, 0, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, entiteClient, 1, 0, GridBagConstraints.HORIZONTAL, 1., 1.);
			
			addToPanel(p, new JLabel("Nom : "), 0, 1, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, nomClient, 1, 1, GridBagConstraints.HORIZONTAL, 1., 1.);
			
			addToPanel(p, new JLabel("Prenom : "), 0, 2, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, prenomClient, 1, 2, GridBagConstraints.HORIZONTAL, 1., 1.);
			
			addToPanel(p, new JLabel("Genre : "), 0, 3, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, genreClient, 1, 3, GridBagConstraints.HORIZONTAL, 1., 1.);
			
			addToPanel(p, new JLabel("Code postal : "), 0, 4, GridBagConstraints.NONE, 0.1, 1.);
			addToPanel(p, codePostalClient, 1, 4, GridBagConstraints.HORIZONTAL, 1., 1.);
		}
		p.setBorder(BorderFactory.createTitledBorder("Client"));
		this.add(p);
		
		p = new JPanel(new GridBagLayout()); {
			JPanel q = new JPanel(new GridBagLayout()); {
				addToPanel(q, new JLabel("Nom : "), 0, 0, GridBagConstraints.NONE, 0.1, 1.);
				addToPanel(q, nomMembre, 1, 0, GridBagConstraints.HORIZONTAL, 0.1, 1.);
				
				addToPanel(q, new JLabel("Prenom : "), 0, 1, GridBagConstraints.NONE, 0.1, 1.);
				addToPanel(q, prenomMembre, 1, 1, GridBagConstraints.HORIZONTAL, 0.1, 1.);
				
				addToPanel(q, new JLabel("Genre : "), 0, 2, GridBagConstraints.NONE, 0.1, 1.);
				addToPanel(q, genreMembre, 1, 2, GridBagConstraints.HORIZONTAL, 0.1, 1.);
				
				addToPanel(q, ajoutMembre, 1, 3, GridBagConstraints.HORIZONTAL, 0.1, 1.);
			}
			addToPanel(p, q, 0, 0, GridBagConstraints.BOTH, 0.5, 1.);
			
			addToPanel(p, listeMembres, 1, 0, GridBagConstraints.BOTH, 1., 1.);
		}
		p.setBorder(BorderFactory.createTitledBorder("Equipe"));
		this.add(p);
		
		p = new JPanel(new GridBagLayout()); {
			JPanel q = new JPanel(new GridBagLayout()); {
				addToPanel(q, new JLabel("Description : "), 0, 0, GridBagConstraints.NONE, 0.1, 1.);
				addToPanel(q, descriptionFonctionnalite, 1, 0, GridBagConstraints.HORIZONTAL, 0.1, 1.);
				
				addToPanel(q, new JLabel("Priorite : "), 0, 1, GridBagConstraints.NONE, 0.1, 1.);
				addToPanel(q, prioriteFonctionnalite, 1, 1, GridBagConstraints.HORIZONTAL, 0.1, 1.);
				
				JPanel r = new JPanel(new GridBagLayout()); {
					addToPanel(r, new JLabel("Identifiant : "), 0, 0, GridBagConstraints.NONE, 0.1, 1.);
					addToPanel(r, identifiantExigence, 1, 0, GridBagConstraints.HORIZONTAL, 0.1, 1.);
					
					addToPanel(r, new JLabel("Description : "), 0, 1, GridBagConstraints.NONE, 0.1, 1.);
					addToPanel(r, descriptionExigence, 1, 1, GridBagConstraints.HORIZONTAL, 0.1, 1.);
					
					addToPanel(r, new JLabel("Priorite : "), 0, 2, GridBagConstraints.NONE, 0.1, 1.);
					addToPanel(r, prioriteExigence, 1, 2, GridBagConstraints.HORIZONTAL, 0.1, 1.);
					
					addToPanel(r, ajoutExigence, 1, 3, GridBagConstraints.HORIZONTAL, 0.1, 1.);
				}
				r.setBorder(BorderFactory.createTitledBorder("Exigence"));
				GridBagConstraints c = new GridBagConstraints();
				c.gridx = 0;
				c.gridy = 2;
				c.gridwidth = 2;
				c.fill = GridBagConstraints.BOTH;
				c.weightx = 1.;
				c.weighty = 1.;
				q.add(r, c);

				addToPanel(q, ajoutFonctionnalite, 1, 3, GridBagConstraints.HORIZONTAL, 0.1, 1.);
			}
			addToPanel(p, q, 0, 0, GridBagConstraints.BOTH, 0.5, 1.);
			
			addToPanel(p, listeFonctionnalites, 1, 0, GridBagConstraints.BOTH, 1., 1.);
		}
		p.setBorder(BorderFactory.createTitledBorder("Fonctionnalite"));
		this.add(p);
		
		p = new JPanel(); {
			p.add(depot);
		}
		this.add(p);
	}

	private void createController() {
		ajoutMembre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controlField(nomMembre, "Veuillez entrer un nom de membre.")
					&& controlField(prenomMembre, "Veuillez entrer un prenom de membre.")) {
					// True si Homme, false sinon ?
					boolean gender =  genreMembre.getSelectedItem() == "Homme";
					team.addMember(new Membre(gender, nomMembre.getText(), prenomMembre.getText()));
					afficherMembres();
				}
			}
		});
		
		ajoutExigence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controlField(identifiantExigence, "Veuillez entrer un identifiant d'exigence.")
					&& controlField(descriptionExigence, "Veuillez entrer une description d'exigence.")
					&& controlField(prioriteExigence, "Veuillez entrer une priorite d'exigence.")) {
					try {
						exigences.add(new Exigence(identifiantExigence.getText(), descriptionExigence.getText(), Integer.parseInt(prioriteExigence.getText())));
					} catch(NumberFormatException n) {
						JOptionPane.showMessageDialog(PostPanel.this, "La priorite de l'exigence n'est pas un entier.");
						return;
					}
					afficherFonctionnalites();
				}
			}
		});
		
		ajoutFonctionnalite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (controlField(descriptionFonctionnalite, "Veuillez entrer une description de fonctionnalite.")
					&& controlField(prioriteFonctionnalite, "Veuillez entrer une priorite de fonctionnalite.")) {
					try {
						fonctionnalites.add(new Fonctionnalite(Integer.parseInt(prioriteFonctionnalite.getText()), descriptionFonctionnalite.getText(), exigences));
					} catch(NumberFormatException n) {
						JOptionPane.showMessageDialog(PostPanel.this, "La priorite de la fonctionnalite n'est pas un entier.");
						return;
					}
					exigences = new ArrayList<Exigence>();
					afficherFonctionnalites();
				}
			}
		});
		
		depot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fonctionnalites.size() == 0) {
					JOptionPane.showMessageDialog(PostPanel.this, "Veuillez entrer au moins une fonctionnalite.");
					return;
				}
				if (team.getMembre().size() == 0) {
					JOptionPane.showMessageDialog(PostPanel.this, "Veuillez entrer au moins un membre.");
					return;
				}
				if (controlField(titre, "Veuillez entrer un titre.")
					&& controlField(version, "Veuillez entrer une version.")
					&& controlField(date, "Veuillez entrer une date.")
					&& controlField(description, "Veuillez entrer une descritpion de STB.")
					&& controlField(entiteClient, "Veuillez entrer une entite pour le client.")
					&& controlField(nomClient, "Veuillez entrer un nom pour le client.")
					&& controlField(prenomClient, "Veuillez entrer un prenom pour le client.")
					&& controlField(codePostalClient, "Veuillez entrer un code postal pour le client.")) {
					// Client
					// True pour un homme, false pour une femme.
					boolean genderClient = genreClient.getSelectedItem() == "Homme";
					Contact contact = new Contact(genderClient, nomClient.getText(), prenomClient.getText());
					Client client = new Client(entiteClient.getText(), contact, codePostalClient.getText());
					try {
						// A gerer : l'ID
						StbModelVO stb = new StbModelVO(ClientWeb.getInstance().getMaxIndex() + 1, titre.getText(), Double.parseDouble(version.getText()), date.getText(), 
								description.getText(), client, team, fonctionnalites, commentaire.getText());
						String res = ClientWeb.getInstance().postStb(stb);
						JOptionPane.showMessageDialog(PostPanel.this, res);
					} catch (NumberFormatException n) {
						JOptionPane.showMessageDialog(PostPanel.this, "La version de la STB n'est pas un nombre.");
						return;
					}
				}
			}
		});
	}
	
	private void addToPanel(JPanel p, JComponent comp, int gridx, int gridy, int fill, double weightx, double weighty) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = gridx;
		c.gridy = gridy;
		c.fill = fill;
		c.weightx = weightx;
		c.weighty = weighty;
		p.add(comp, c);
	}
	
	// Returns true if field is OK, false if field is empty.
	private boolean controlField(JTextComponent field, String message) {
		if (field.getText().equals("")) {
			JOptionPane.showMessageDialog(this, message);
			return false;
		}
		return true;
	}
	
	private void afficherMembres() {
		String s = "";
		for (Membre m : team.getMembre()) {
			s += m.toString() + "\n";
		}
		listeMembres.setText(s);
	}
	
	private void afficherFonctionnalites() {
		String s = "Exigences en cours :\n";
		for (Exigence e : exigences) {
			s += e.toString() + "\n";
		}
		s += "-------\n";
		for (Fonctionnalite f : fonctionnalites) {
			s += f.toString() + "\n";
		}
		listeFonctionnalites.setText(s);
	}
}
