// Par Yann Pascoet et Romain Simon

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Statistiques{
    public JPanel panneau = new JPanel();
    int id = 0;
    public JTextField dateJourOccup = new JTextField();
    public JLabel resultTauxOccupJour = new JLabel();
    public JTextField dateJourNonOccup = new JTextField();
    public JLabel resultTauxNonOccup = new JLabel();
    public JTextField periodeJourOccup = new JTextField("YYYY-mm-dd YYYY-mm-dd");
    public JLabel resultTauxOccupPeriode = new JLabel();
    
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
	panneau.add(dateJourOccup);
	JButton tauxOccup = new JButton("Calculez");
	panneau.add(tauxOccup);
	panneau.add(resultTauxOccupJour);

	JLabel tauxNonOccupationJour = new JLabel("Entrez la date pour le taux de non presentation :");
	panneau.add(tauxNonOccupationJour);
	panneau.add(dateJourNonOccup);
	JButton tauxNonOccup = new JButton("Calculez");
	panneau.add(tauxNonOccup);
	panneau.add(resultTauxNonOccup);

	JLabel tauxOccupationPeriode = new JLabel("Entrez la periode pour le taux d'occupation :");
	panneau.add(tauxOccupationPeriode);
	panneau.add(periodeJourOccup);
	JButton tauxOccupPeriode = new JButton("Calculez");
	panneau.add(tauxOccupPeriode);
	panneau.add(resultTauxOccupPeriode);

	Calculateur c1 = new Calculateur(1,panneau);
	Calculateur c2 = new Calculateur(2,panneau);
	Calculateur c3 = new Calculateur(3,panneau);
	c1.setStatistiques(this);
	c2.setStatistiques(this);
	c3.setStatistiques(this);
	tauxOccup.addActionListener(c1);
	tauxNonOccup.addActionListener(c2);
	tauxOccupPeriode.addActionListener(c3);
    }
    
    public static void main(String[] args) {
	Statistiques stats = new Statistiques();
    }
    
}
