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
        int nuits=0, categorie=0, numDeChambre=0;
        Date date = "2017-22-09";
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
          view.identite.setText(""+prenom+" "+nom);
        }
        PreparedStatement numChambre = connexion2.prepareStatement("SELECT * FROM Chambre WHERE categorie='"+categorie+"' AND disponible = '1'");
        ResultSet resultNumChambre = numChambre.executeQuery();
        if(resultNumChambre.first()) {
          numDeChambre = resultNumChambre.getInt(4);
        }
        view.caracChambre.setText("Ref: "+reference+"Date: "+date+"Nuits: "+nuits+"Categorie: "+categorie+"\n Numero de chambre: "+numDeChambre);
        view.panneau.removeAll();
        view.panneau.updateUI();
        listeReservRef.close();
        resultListRef.close();
        numChambre.close();
        resultNumChambre.close();
      }
      else if (id == 2) {
        view.DeuxiemeFenetre();
        view.card.next(view.cards);
        nom = view.nomClient.getText();
        prenom = view.prenomClient.getText();
        int nuits=0,categorie=0, numDeChambre=0;
        Date date="2017-22-09";
        String reference="ab";
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
          view.caracChambre.setText("Ref: "+reference+"Date: "+date+"Nuits: "+nuits+"Categorie: "+categorie);
        }
        PreparedStatement numeroChambre = connexion2.prepareStatement("SELECT * FROM Chambre WHERE categorie='"+categorie+"' AND disponible = '1'");
        ResultSet resultNumeroChambre = numeroChambre.executeQuery();
        if(resultNumeroChambre.first()) {
          numDeChambre = resultNumeroChambre.getInt(4);
        }
        view.caracChambre.setText("Ref: "+reference+"Date: "+date+"Nuits: "+nuits+"Categorie: "+categorie+"\n Numero de chambre: "+numDeChambre);
        view.panneau.removeAll();
        view.panneau.updateUI();
        listeReservNom.close();
        resultListNom.close();
        numeroChambre.close();
        resultNumeroChambre.close();
      }
      else if (id == 3) {
        view.TroisiemeFenetre();
        view.card.next(view.cards);
        nom = view.nomClient.getText();
        prenom = view.prenomClient.getText();
        reference = view.numReservation.getText();
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
