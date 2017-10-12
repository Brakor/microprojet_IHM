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

    modifierContraintes(contraintes, 1, 1, 15, GridBagConstraints.HORIZONTAL,
        GridBagConstraints.CENTER, new Insets(5, 400, 100, 400),
        0.1, 2);
    panneau.add(numReservation, contraintes);

    modifierContraintes(contraintes, 1, 2, contraintes.ipady,
        GridBagConstraints.HORIZONTAL, contraintes.anchor,
        new Insets(5, 400, 5, 10), contraintes.weightx, 1);
    panneau.add(nomClient, contraintes);

    modifierContraintes(contraintes, 2, 2, contraintes.ipady,
        GridBagConstraints.HORIZONTAL, contraintes.anchor,
        new Insets(5, 10, 5, 400), contraintes.weightx,
        contraintes.gridwidth);
    panneau.add(prenomClient, contraintes);

    modifierContraintes(contraintes, 2, 1, contraintes.ipady,
        GridBagConstraints.HORIZONTAL, contraintes.anchor,
        contraintes.insets, contraintes.weightx, contraintes.gridwidth);
    panneau.add(rechercherNum, contraintes);

    modifierContraintes(contraintes, 2, 3, contraintes.ipady,
        GridBagConstraints.HORIZONTAL, contraintes.anchor,
        contraintes.insets, contraintes.weightx, contraintes.gridwidth);
    panneau.add(rechercherNom, contraintes);

    modifierContraintes(contraintes, 2, 0, contraintes.ipady,
        GridBagConstraints.HORIZONTAL, contraintes.anchor,
        contraintes.insets, contraintes.weightx, contraintes.gridwidth);
    panneau.add(titre, contraintes);
    this.add(panneau);

  }

  public void modifierContraintes(GridBagConstraints c, int gridx, int gridy, int ipady, int fill, int anchor, Insets insets, double weightx, int gridwidth){
    c.gridx = gridx;
    c.gridy = gridy;
    c.ipady = ipady;
    c.fill = fill;
    c.anchor = anchor;
    c.insets = insets;
    c.weightx = weightx;
    c.gridwidth = gridwidth;
  }
}


public class Projet_v1 {
  public static void main (String[] args) {
    JFrame f;
    f = new Fenetre();
    f.setVisible(true);
  }
}


