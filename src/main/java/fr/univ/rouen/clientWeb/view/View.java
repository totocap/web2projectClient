package fr.univ.rouen.clientWeb.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class View {
	// ATTRIBUTS
	/**
	 * La fenetre principale.
	 */
	JFrame frame;
	
	JTabbedPane tabbedPane;

	public View() {
		createView();
        placeComponents();
        createController();
	}
	
	public void display() {
		frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	// OUTILS
	private void createView() {
		frame = new JFrame("Client");
		frame.setSize(800, 600);
		
		tabbedPane = new JTabbedPane();
	}
	
	private void placeComponents() {
		tabbedPane.add("Accueil", new HomePanel());
		tabbedPane.add("Resume", new ResumePanel());
		tabbedPane.add("Recherche par id", new StbByIdPanel());
		tabbedPane.add("Depot", new PostPanel());
		tabbedPane.add("Parametres", new ParamPanel());
		frame.add(tabbedPane, BorderLayout.CENTER);
	}
	
	private void createController() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// POINT D'ENTREE
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new View().display();
            }
        });
    }
}
