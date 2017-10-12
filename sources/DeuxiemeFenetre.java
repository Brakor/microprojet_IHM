import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Fenetre extends JFrame {
    public Fenetre(){
	this.setSize(1200,800);
        this.setLocation(0,10);
	this.setTitle("Résultats de la recherche");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel cards = new JPanel(new CardLayout());
	JPanel panneau = new JPanel();
	JLabel chambreSugg = new JLabel("Chambre suggerée :");
	JLabel autreChambre = new JLabel("Ou choisissez une autre chambre :");
	JLabel nomClient = new JLabel("nom Client"); //à modifier quand la bd sera reliée
	JButton accepter = new JButton("Accepter");
	JLabel caracChambre = new JLabel("caractéristiques de la chambre"); //à modifier, juste pour tester l'affichage
	JCheckBox possibChambre = new JCheckBox("Test"); //à modifier
	panneau.setLayout(new GridBagLayout());
	GridBagConstraints contraintes = new GridBagConstraints();

	contraintes.gridx = 1;
	contraintes.gridy = 0;
	contraintes.ipady = 20;
	contraintes.insets = new Insets(15,50,50,150);
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.anchor = GridBagConstraints.CENTER;
	contraintes.weightx = 0.1;
	panneau.add(nomClient, contraintes);

	contraintes.gridx = 0;
	contraintes.gridy = 1;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	panneau.add(chambreSugg, contraintes);

	contraintes.gridx = 0;
	contraintes.gridy = 2;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	panneau.add(caracChambre, contraintes);

	contraintes.gridx = 0;
	contraintes.gridy = 3;
	panneau.add(accepter, contraintes);

	contraintes.gridx = 2;
	contraintes.gridy = 1;
	contraintes.gridwidth = 2;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	panneau.add(autreChambre, contraintes);

	contraintes.gridx = 2;
	contraintes.gridy = 2;
	panneau.add(possibChambre, contraintes);

	cards.add(panneau);
	this.add(cards);
    }
}
	
public class DeuxiemeFenetre {
    public static void main (String[] args) {
	JFrame f;
	f = new Fenetre();
	f.setVisible(true);
    }
}
