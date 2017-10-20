import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Statistiques implements ActionListener{
    JPanel panneau = new JPanel();
    int id = 0;
        
    public Statistiques() {
	JFrame f = new JFrame();
	f.setSize(1700,500);
	f.setLocation(0,10);
	f.setTitle("Statistiques");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.add(panneau);
	Stats();
	f.setVisible(true);
    }

    public void Stats() {
	GridLayout layout = new GridLayout(3,4);
	layout.setHgap(50);
	layout.setVgap(50);
	panneau.setLayout(layout);

	JLabel tauxOccupationJour = new JLabel("Entrez la date pour le taux d'occupation :");
	panneau.add(tauxOccupationJour);
	JTextField dateJourOccup = new JTextField();
	panneau.add(dateJourOccup);
	JButton tauxOccup = new JButton("Calculez");
	panneau.add(tauxOccup);
	JLabel resultTauxOccupJour = new JLabel();
	panneau.add(resultTauxOccupJour);

	JLabel tauxNonOccupationJour = new JLabel("Entrez la date pour le taux de non presentation :");
	panneau.add(tauxNonOccupationJour);
	JTextField dateJourNonOccup = new JTextField();
	panneau.add(dateJourNonOccup);
	JButton tauxNonOccup = new JButton("Calculez");
	panneau.add(tauxNonOccup);
	JLabel resultTauxNonOccup = new JLabel();
	panneau.add(resultTauxNonOccup);

	JLabel tauxOccupationPeriode = new JLabel("Entrez la periode pour le taux d'occupation :");
	panneau.add(tauxOccupationPeriode);
	JTextField periodeJourOccup = new JTextField("YYYY-mm-dd YYYY-mm-dd");
	panneau.add(periodeJourOccup);
	JButton tauxOccupPeriode = new JButton("Calculez");
	panneau.add(tauxOccupPeriode);
	JLabel resultTauxOccupPeriode = new JLabel();
	panneau.add(resultTauxOccupPeriode);

	Controleur c1 = new Controleur(1,panneau);
	Controleur c2 = new Controleur(2,panneau);
	Controleur c3 = new Controleur(3,panneau);
	tauxOccup.addActionListener(c1);
	tauxNonOccup.addActionListener(c2);
	tauxOccupPeriode.addActionListener(c3);
    }

    public Controleur(int i, JPanel p) {
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
	    Connecion connexion2 = DriverManager.getConnection("jdbc:mariadb://dwarves.iut-fbleau.fr/simonr","simonr","Azertyuiop");
	    if (id == 1) {
		int pourcentage, i = 0;
		int[] idClient = new int[100];
		String date = dateJourOccup.getText();
		PreparedStatement tauxOccupation = connexion.prepareStatement("SELECT DISTINCT client FROM Reservation WHERE debut='"+date+"'");
		ResultSet tauxOccup = tauxOccupation.executeQuery();
		while (tauxOccup.next()) {
		    idClient[i] = tauxOccup.getInt(1);
		    i++;
		}
		int taille = idClient.length();
		int j = 0;
		while (j<taille) {
		    PreparedStatement nombrePersonne = connexion2.prepareStatement("SELECT COUNT(*) FROM Chambre WHERE id_client='"+idClient[j]+"' AND disponilbe='0'");
		    ResultSet nbrP = nombrePersonne.executeQuery();
		    if (nbrP.first()) {
			pourcentage=pourcente+nbrP.getInt(1);
		    }
		    j++;
		}
		resultTauxOccupJour.setText(""+pourcentage+"% d'occupation");
		nbrP.close();
		nombrePersonne.close();
		tauxOccup.close();
		tauxOccupation.close();
	    }
	    else if (id == 2) {
		int pourcentage, i=0;
		int[] idClient = new int[100];
		String date = dateJourNonOccup.getText();
		PreparedStatement tauxNonOccupation = connexion.prepareStatement("SELECT DISTINCT client FROM Reservation WHERE debut='"+date+"'");
		ResultSet tauxNonOccup=tauxNonOccupation.executeQuery();
		while (tauxNonOccup.next()) {
		    idClient[i] = tauxNonOccup.getInt(1);
		    i++;
		}
		int taille = idClient.length();
		int j = 0;
		while (j<taille) {
		    PreparedStatement nombrePersonne = connexion2.prepareStatement("SELECT COUNT(*) FROM Chambre WHERE id_client='"+idClient[j]+"' AND disponible = '1'");
		    ResultSet nbrP = nombrePersonne.executeQuery();
		    if (nbrP.first()) {
			pourcentage=pourcentage+nbrP.getInt(1);
		    }
		    j++;
		}
		resultTauxNonOccup.setText(""+pourcentage+"% de non occupation");
		nbrP.close();
		nombrePersonne.close();
		tauxNonOccup.close();
		tauxNonOccupation.close();
	    }	  
	    else if (id == 3) {
		int pourcentage, i=0;
		int[] idClient = new int[100];
		String tmp = periodeJourOccup.getText();
		String date[] = tmp.split(" ");
		PreparedStatement tauxOccupation = connexion.prepareStatament("SELECT DISTINCT client FROM Reservation WHERE debut BETWEEN '"+date[0]+"'AND '"+date[1]+"'");
		ResultSet tauxOccup = tauxOccupation.executeQuery();
		while (tauxOccup.next()) {
		    idClient[i] = tauxOccup.getInt(1);
		    i++;
		}
		int taille = idClient.length();
		int j = 0;
		while (j<taille) {
		    PreparedStatement nombrePersonne = connexion2.prepareStatement("SELECT COUNT(*) FROM Chambre WHERE id_client='"+idClient[j]+"' AND disponible='0'");
		    ResultSet nbrP = nombrePersonne.executeQuery();
		    if (nbrP.first()) {
			pourcentage=pourcentage+nbrP.getInt(1);
		    }
		    j++;
		}
		resultTauxOccupPeriode.setText(""+pourcentage+"% d'occupation sur cette période");
		nbrP.close();
		nombrePersonne.close();
		tauxOccup.close();
		tauxOccupation.close();
	    }
	    connexion.close();
	    connextion2.close();
	}
	catch (SQLException d) {
	    System.err.println("Erreur connexion: "+b.getMessage());
	}
	public static void main(String[] args) {
	    Statistiques stats = new Statistiques();
	}
    }
}
