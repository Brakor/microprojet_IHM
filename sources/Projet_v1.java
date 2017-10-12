import java.sql.*;
import javax.swing.*;
import java.awt.*;

class Fenetre extends JFrame{
    public Fenetre(){
	this.setSize(1200,800);
        this.setLocation(0,10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panneau = new JPanel();
        JTextField numReservation = new JTextField();
        numReservation.setText("Numéro de Réservation");
        JTextField nomClient = new JTextField();
        nomClient.setText("Nom Client");
        JTextField prenomClient = new JTextField();
        prenomClient.setText("Prénom Client");

        panneau.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();

        contraintes.gridx = 1;
        contraintes.gridy = 0;
        contraintes.ipady = 15;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.anchor = GridBagConstraints.CENTER;
        contraintes.insets = new Insets(5,200,100,200);
        contraintes.weightx = 0.1;
        contraintes.gridwidth = 2;

        panneau.add(numReservation, contraintes);

        contraintes.insets = new Insets(5,200,5,10);
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.gridwidth = 1;
        contraintes.ipady = 15;
        contraintes.gridx = 1;
        contraintes.gridy = 1;

	panneau.add(nomClient, contraintes);

	contraintes.insets = new Insets(5,10,5,200);
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.ipady = 15;
	contraintes.gridx = 2;
	contraintes.gridy = 1;

	panneau.add(prenomClient, contraintes);
	this.add(panneau);

	try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote indisponible!");
        }

        try {
            Connection connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/projetihm","projetihm","mhitejorp");
            PreparedStatement requete = connexion.prepareStatement("SELECT COUNT(*) FROM Client");
            ResultSet resultat = requete.executeQuery();
            if (resultat.first()) {
                System.out.println(resultat.getInt(1) + " clients");
            }
            resultat.close();
            requete.close();
            connexion.close();
        } catch (SQLException e) {
            System.err.println("Erreur connexion: " + e.getMessage());
	}
    }
}
   

public class Projet_v1 {
    public static void main (String[] args) {
	JFrame f;
	f = new Fenetre();
	f.setVisible(true);
    }
}


