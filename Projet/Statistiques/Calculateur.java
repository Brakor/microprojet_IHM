import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Calculateur implements ActionListener {
    Statistiques stats;
    public int id = 0;
    public JPanel panneau = new JPanel();
       
    public Calculateur(int i, JPanel p) {
	this.id = i;
	this.panneau=p;
    }

        @Override
	public void actionPerformed(ActionEvent e) {
	    try {
		Class.forName("org.mariadb.jdbc.Driver");
	    } catch (ClassNotFoundException b) {
		System.err.println("Pilote indisponible !");
	    }
	    try {
		Connection connexion = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/projetihm","projetihm","mhitejorp");
		Connection connexion2 = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/simonr","simonr","Azertyuiop");
		if (id == 1) {
		    int pourcentage=0, i = 0;
		    int[] idClient = new int[100];
		    String date = stats.dateJourOccup.getText();
		    PreparedStatement tauxOccupation = connexion.prepareStatement("SELECT DISTINCT client FROM Reservation WHERE debut='"+date+"'");
		    ResultSet tauxOccup = tauxOccupation.executeQuery();
		    while (tauxOccup.next()) {
			idClient[i] = tauxOccup.getInt(1);
			i++;
		    }
		    int j = 0;
		    while (j<100) {
			PreparedStatement nombrePersonne = connexion2.prepareStatement("SELECT COUNT(*) FROM Chambre WHERE id_client='"+idClient[j]+"' AND disponible='1'");
			ResultSet nbrP = nombrePersonne.executeQuery();
			if (nbrP.first()) {
			    pourcentage=pourcentage+nbrP.getInt(1);
			}
			j++;
			nbrP.close();
			nombrePersonne.close();
		    }
		    stats.resultTauxOccupJour.setText(""+pourcentage+"% d'occupation");
		    tauxOccup.close();
		    tauxOccupation.close();
		}
		else if (id == 2) {
		    int pourcentage=0, i=0;
		    int[] idClient = new int[100];
		    String date = stats.dateJourNonOccup.getText();
		    PreparedStatement tauxNonOccupation = connexion.prepareStatement("SELECT DISTINCT client FROM Reservation WHERE debut='"+date+"'");
		    ResultSet tauxNonOccup=tauxNonOccupation.executeQuery();
		    while (tauxNonOccup.next()) {
			idClient[i] = tauxNonOccup.getInt(1);
			i++;
		    }
		    int j = 0;
		    while (j<100) {
			PreparedStatement nombrePersonne = connexion2.prepareStatement("SELECT COUNT(*) FROM Chambre WHERE id_client='"+idClient[j]+"' AND disponible = '0'");
			ResultSet nbrP = nombrePersonne.executeQuery();
			if (nbrP.first()) {
			    pourcentage=pourcentage+nbrP.getInt(1);
			}
			j++;
			nbrP.close();
			nombrePersonne.close();
		    }
		    stats.resultTauxNonOccup.setText(""+pourcentage+"% de non occupation");
		    tauxNonOccup.close();
		    tauxNonOccupation.close();
		}
		else if (id == 3) {
		    int pourcentage=0, i=0;
		    int[] idClient = new int[100];
		    String tmp = stats.periodeJourOccup.getText();
		    String date[] = tmp.split(" ");
		    PreparedStatement tauxOccupation = connexion.prepareStatement("SELECT DISTINCT client FROM Reservation WHERE debut BETWEEN '"+date[0]+"' AND '"+date[1]+"'");
		    ResultSet tauxOccup = tauxOccupation.executeQuery();
		    while (tauxOccup.next()) {
			idClient[i] = tauxOccup.getInt(1);
			i++;
		    }
		    int j = 0;
		    while (j<100) {
			PreparedStatement nombrePersonne = connexion2.prepareStatement("SELECT COUNT(*) FROM Chambre WHERE id_client='"+idClient[j]+"' AND disponible='0'");
			ResultSet nbrP = nombrePersonne.executeQuery();
			if (nbrP.first()) {
			    pourcentage=pourcentage+nbrP.getInt(1);
			}
			j++;
			nbrP.close();
			nombrePersonne.close();
		    }
		    stats.resultTauxOccupPeriode.setText(""+pourcentage+"% d'occupation sur cette période");
		    tauxOccup.close();
		    tauxOccupation.close();
		}
		connexion.close();
		connexion2.close();
	    }
	    catch (SQLException d) {
		System.err.println("Erreur connexion: "+d.getMessage());
	    }
	}
    public void setStatistiques(Statistiques stats) {
	this.stats = stats;
    }
}
