import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Statistiques {
    JPanel panneau = new JPanel();
    
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

	JLabel tauxNonOccupationJour = new JLabel("Entrez la date pour le taux de non présentation :");
	panneau.add(tauxNonOccupationJour);
	JTextField dateJourNonOccup = new JTextField();
	panneau.add(dateJourNonOccup);
	JButton tauxNonOccup = new JButton("Calculez");
	panneau.add(tauxNonOccup);
	JLabel resultTauxNonOccup = new JLabel();
	panneau.add(resultTauxNonOccup);

	JLabel tauxOccupationPeriode = new JLabel("Entrez la période pour le taux d'occupation :");
	panneau.add(tauxOccupationPeriode);
	JTextField periodeJourOccup = new JTextField();
	panneau.add(periodeJourOccup);
	JButton tauxOccupPeriode = new JButton("Calculez");
	panneau.add(tauxOccupPeriode);
	JLabel resultTauxOccupPeriode = new JLabel();
	panneau.add(resultTauxOccupPeriode);
		
    }

    public static void main(String[] args) {
	Statistiques stats = new Statistiques();
    }
}
