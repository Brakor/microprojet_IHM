import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Controleur implements ActionListener {
    int id = 0;
    JPanel p = new JPanel();
    View view;
    String reference;
    String nom;
    String prenom;
	
    public Controleur(int i, JPanel panneau) {
	this.id = i;
	this.p = panneau;
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
	try {
	    Class.forName("org.mariadb.jdbc.Driver");
	} catch (ClassNotFoundException b) {
	    System.err.println("Pilote indisponible!");
	}

	try {
	    Connection connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/projetihm","projetihm","mhitejorp");
	    if (id == 1) {
		view.DeuxiemeFenetre();
		view.card.next(view.cards);
		reference = view.numReservation.getText();
		int nuits, categorie;
		Date date;
		String nom,prenom;
		PreparedStatement listeReservRef = connexion.prepareStatement("SELECT * FROM Reservation JOIN Client WHERE reference='"+reference+"'");
		ResultSet resultListRef = listeReservRef.executeQuery();
		while (resultListRef.next()) {
		    prenom = resultListRef.getString(8);
		    nom = resultListRef.getString(9);
		    reference = resultListRef.getString(2);
		    date = resultListRef.getDate(3);
		    nuits = resultListRef.getInt(4);
		    categorie = resultListRef.getInt(5);
		    view.caracChambre.setText(" "+reference+" "+date+" "+nuits+" "+categorie);
		    view.identite.setText(""+prenom+" "+nom);
		}
		view.panneau.removeAll();
		view.panneau.updateUI();
	    }
	    else if (id == 2) {
		view.DeuxiemeFenetre();
		view.card.next(view.cards);
		nom = view.nomClient.getText();
		prenom = view.prenomClient.getText();
		int nuits,categorie;
		Date date;
		String reference;
		PreparedStatement listeReservNom = connexion.prepareStatement("SELECT * FROM Client JOIN Reservation WHERE nom='"+nom+"' AND prenom='"+prenom+"'");
		ResultSet resultListNom = listeReservNom.executeQuery();
		while (resultListNom.next()) {
		    nom=resultListNom.getString(2);
		    prenom=resultListNom.getString(3);
		    reference=resultListNom.getString(5);
		    date=resultListNom.getDate(6);
		    nuits=resultListNom.getInt(7);
		    categorie=resultListNom.getInt(8);
		    view.identite.setText(""+prenom+" "+nom);
		    view.caracChambre.setText(" "+reference+" "+date+" "+nuits+" "+categorie);
		}
		view.panneau.removeAll();
		view.panneau.updateUI();
	    }
	    else if (id == 3) {
		view.TroisiemeFenetre();
		view.card.next(view.cards);
		view.content.removeAll();
		view.content.updateUI();
	    }
	    else if (id == 4) {
		view.PremiereFenetre();
		view.card.next(view.cards);
		view.lastPage.removeAll();
		view.lastPage.updateUI();
	    }
	    connexion.close();
	} catch (SQLException b) {
	    System.err.println("Erreur connexion: " + b.getMessage());
	}
	
    }
    public void setView(View view) {
	this.view = view;
    }

}
