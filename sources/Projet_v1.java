import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Fenetre extends JFrame{
    public Fenetre(){
	this.setSize(1200,800);
        this.setLocation(0,10);
	this.setTitle("Recherche de réservations");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panneau = new JPanel();
        JTextField numReservation = new JTextField("Nom Client");
	JTextField nomClient = new JTextField("Nom Client");
	JTextField prenomClient = new JTextField("Prénom Client");
	JButton rechercherNum = new JButton("Rechercher");
	JButton rechercherNom = new JButton("Rechercher");
	JLabel titre = new JLabel("Rechercher une réservation");
	panneau.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();

        contraintes.gridx = 1;
        contraintes.gridy = 1;
        contraintes.ipady = 15;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.anchor = GridBagConstraints.CENTER;
        contraintes.insets = new Insets(5,400,100,400);
        contraintes.weightx = 0.1;
        contraintes.gridwidth = 2;

        panneau.add(numReservation, contraintes);

        contraintes.insets = new Insets(5,400,5,10);
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.gridwidth = 1;
        //contraintes.ipady = 15;
        contraintes.gridx = 1;
        contraintes.gridy = 2;

	panneau.add(nomClient, contraintes);

	contraintes.insets = new Insets(5,10,5,400);
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	//contraintes.ipady = 15;
	contraintes.gridx = 2;
	contraintes.gridy = 2;

	panneau.add(prenomClient, contraintes);

	contraintes.fill = GridBagConstraints.HORIZONTAL;
	//contraintes.ipady = 15;
	contraintes.gridx = 2;
	contraintes.gridy = 1;

	panneau.add(rechercherNum, contraintes);

	contraintes.fill = GridBagConstraints.HORIZONTAL;
	//contraintes.ipady = 15;
	contraintes.gridx = 2;
	contraintes.gridy = 3;

	panneau.add(rechercherNom, contraintes);

	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 2;
	contraintes.gridy = 0;
		
	panneau.add(titre, contraintes);
	this.add(panneau);
	
    }
}
   

public class Projet_v1 {
    public static void main (String[] args) {
	JFrame f;
	f = new Fenetre();
	f.setVisible(true);
    }
}


