import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;

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
	    Connection connexion2 = DriverManager.getConnection("jdbc:mariadb://dwarves.arda/simonr","simonr","Azertyuiop");
	    if (id == 1) {
		view.DeuxiemeFenetre();
		view.card.next(view.cards);
		reference = view.numReservation.getText();
		int nuits=0, categorie=0, numDeChambre=0,idClient = 0;
		PreparedStatement listeReservRef = connexion.prepareStatement("SELECT * FROM Reservation WHERE reference='"+reference+"' AND debut='2018-01-06'");
		ResultSet resultListRef = listeReservRef.executeQuery();
		while (resultListRef.next()) {
		    reference = resultListRef.getString(2);
		    nuits = resultListRef.getInt(4);
		    categorie = resultListRef.getInt(5);
		    idClient=resultListRef.getInt(6);
		    view.idcl.setText(""+idClient);
		    view.catego.setText(""+categorie);
		}
		PreparedStatement client = connexion.prepareStatement("SELECT * FROM Client WHERE id='"+idClient+"'");
		ResultSet resultatClient = client.executeQuery();
		if (resultatClient.first()) {
		    nom=resultatClient.getString(3);
		    prenom=resultatClient.getString(2);
		    view.identite.setText(""+prenom+" "+nom);
		}
		PreparedStatement numChambre = connexion2.prepareStatement("SELECT * FROM Chambre WHERE categorie='"+categorie+"' AND disponible = '1'");
                ResultSet resultNumChambre = numChambre.executeQuery();
                if(resultNumChambre.first()) {
                    numDeChambre = resultNumChambre.getInt(4);
		    view.numch.setText(""+numDeChambre);
		}
                view.caracChambre.setText("Ref: "+reference+" Nuits: "+nuits+" Categorie: "+categorie+" Numero de chambre: "+numDeChambre);
		view.panneau.removeAll();
		view.panneau.updateUI();
		listeReservRef.close();
		resultListRef.close();
		numChambre.close();
		resultNumChambre.close();
		client.close();
		resultatClient.close();
	    }
	    else if (id == 2) {
		view.DeuxiemeFenetre();
		view.card.next(view.cards);
		nom = view.nomClient.getText();
		prenom = view.prenomClient.getText();
		int nuits=0,categorie=0, numDeChambre=0, idClient=0;
		String reference="ab";
		PreparedStatement listeReservNom = connexion.prepareStatement("SELECT * FROM Client WHERE nom='"+nom+"' AND prenom='"+prenom+"'");
		ResultSet resultListNom = listeReservNom.executeQuery();
		while (resultListNom.next()) {
		    idClient=resultListNom.getInt(1);
		    nom=resultListNom.getString(2);
		    prenom=resultListNom.getString(3);
		    view.idcl.setText(""+idClient);
		    view.identite.setText(""+prenom+" "+nom);
		}
		PreparedStatement reservation = connexion.prepareStatement("SELECT * FROM Reservation WHERE client='"+idClient+"' AND debut='2018-01-06'");
		ResultSet resultatReservation = reservation.executeQuery();
		if (resultatReservation.first()) {
		    reference=resultatReservation.getString(2);
		    nuits=resultatReservation.getInt(4);
		    categorie=resultatReservation.getInt(5);
		    view.catego.setText(""+categorie);
		}
		PreparedStatement numeroChambre = connexion2.prepareStatement("SELECT * FROM Chambre WHERE categorie='"+categorie+"' AND disponible = '1'");
		ResultSet resultNumeroChambre = numeroChambre.executeQuery();
		if(resultNumeroChambre.first()) {
		    numDeChambre = resultNumeroChambre.getInt(4);
		    view.numch.setText(""+numDeChambre);
		}
		view.caracChambre.setText("Ref: "+reference+" Nuits: "+nuits+" Categorie: "+categorie+" Numero de chambre: "+numDeChambre);
		view.panneau.removeAll();
		view.panneau.updateUI();
		listeReservNom.close();
		resultListNom.close();
		numeroChambre.close();
		resultNumeroChambre.close();
		reservation.close();
		resultatReservation.close();
	    }
	    else if (id == 3) {
		view.TroisiemeFenetre();
		view.card.next(view.cards);
		nom = view.identite.getText();
		reference = view.numReservation.getText();
		view.idClient.setText("Nom du client : "+nom);
		String categorie, numDeChambre;
		int categor = Integer.parseInt(view.catego.getText());
		int numchamb = Integer.parseInt(view.numch.getText());
		int idClient = Integer.parseInt(view.idcl.getText());
		if (categor == 1)
		    view.chambre.setText("Chambre attribuée : Un lit simple");
		else if (categor == 2)
		    view.chambre.setText("Chambre attribuée : Un lit double");
		else if (categor == 3)
		    view.chambre.setText("Chambre attribuée : Deux lits simples");
		view.numChambre.setText("Numéro de la chambre : "+numchamb);
		PreparedStatement insertion = connexion2.prepareStatement("UPDATE Chambre SET disponible='0',id_client='"+idClient+"' WHERE numero='"+numchamb+"'");
		int update = insertion.executeUpdate();
		insertion.close();
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
	    connexion2.close();
	} catch (SQLException b) {
	    System.err.println("Erreur connexion: " + b.getMessage());
	}
	
    }
    public void setView(View view) {
	this.view = view;
    }

}
