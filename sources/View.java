import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View extends JFrame{
    public CardLayout card = new CardLayout();
    public JPanel cards = new JPanel(card);
    public JPanel panneau = new JPanel();
    public JPanel content = new JPanel();
    public JPanel lastPage = new JPanel();
    String[] listContent = {"card1", "card2", "card3"};
    public JTextField numReservation = new JTextField();
    public JTextField nomClient = new JTextField();
    public JTextField prenomClient = new JTextField();
    public JLabel chambreSugg = new JLabel("Chambre suggerée : ");
    public JLabel caracChambre = new JLabel();
    public JLabel identite = new JLabel();
    
    public View() {
	JFrame f = new JFrame();
	f.setSize(1200,800);
	f.setLocation(0,10);
	f.setTitle("Gestion des réservations");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.add(cards);
	PremiereFenetre();
	f.setVisible(true);
    }
    
    public void PremiereFenetre(){
	JButton rechercherNum = new JButton("Rechercher");
	JButton rechercherNom = new JButton("Rechercher");
	JLabel titre = new JLabel("Rechercher une réservation");
	panneau.setLayout(new GridBagLayout());
        GridBagConstraints contraintes = new GridBagConstraints();

	/* Implémentation de toutes les contraintes pour chaque composant et ajout au GridBagLayout, les contraintes sont les suivantes :
	   
	   gridx : choix de la colonne d'affichage
	   gridy : choix de la ligne d'affichage
	   ipady : choix de la hauteur de l'élément
	   fill : agrandissement de l'élément pour qu'il remplisse la case (peut remplir de manière : Horizontal, Vertical, Aucune, ou les deux
	   anchor : pour placer le composant dans la case quand il est plus petit que la case
	   insets : modifie l'espace entre chaque case, 4 paramètres : en bas, à gauche, en haut, à droite
	   weightx : valeur qui va gérer l'espace restant horizontal
	   gridwidth : taille de la case (peut faire la taille d'1 case, de 2 cases, ect ...)
	*/
	
        contraintes.gridx = 1;
        contraintes.gridy = 1;
        contraintes.ipady = 15;
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.anchor = GridBagConstraints.CENTER;
        contraintes.insets = new Insets(5,400,100,400);
        contraintes.weightx = 0.1;
        contraintes.gridwidth = 2;
        panneau.add(numReservation, contraintes);

        contraintes.insets = new Insets(5,400,5,10);
        contraintes.fill = GridBagConstraints.HORIZONTAL;
        contraintes.gridwidth = 1;
        contraintes.gridx = 1;
        contraintes.gridy = 2;
	panneau.add(nomClient, contraintes);

	contraintes.insets = new Insets(5,10,5,400);
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 2;
	contraintes.gridy = 2;
	panneau.add(prenomClient, contraintes);

	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 2;
	contraintes.gridy = 1;
	panneau.add(rechercherNum, contraintes);
	
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 2;
	contraintes.gridy = 3;
	panneau.add(rechercherNom, contraintes);

	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.gridx = 2;
	contraintes.gridy = 0;
	panneau.add(titre, contraintes);

	cards.add(panneau, listContent[0]);

	Controleur c1 = new Controleur(1,panneau);
	Controleur c2 = new Controleur(2,panneau);
	c1.setView(this);
	c2.setView(this);
	rechercherNum.addActionListener(c1);
	rechercherNom.addActionListener(c2);
    }

    public void DeuxiemeFenetre() {
	JLabel autreChambre = new JLabel("Ou choisissez une autre chambre :");
	JButton accepter = new JButton("Accepter");
	JCheckBox possibChambre = new JCheckBox("Test"); //à modifier
	content.setLayout(new GridBagLayout());
	GridBagConstraints contraintes = new GridBagConstraints();

	/* Implémentation du GridBagLayout avec toutes les contraintes pour chaque élément */
	contraintes.gridx = 1;
	contraintes.gridy = 0;
	contraintes.ipady = 20;
	contraintes.insets = new Insets(15,50,50,150);
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.anchor = GridBagConstraints.CENTER;
	contraintes.weightx = 0.1;
	content.add(identite, contraintes);

	contraintes.gridx = 0;
	contraintes.gridy = 1;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	content.add(chambreSugg, contraintes);

	contraintes.gridx = 0;
	contraintes.gridy = 2;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	content.add(caracChambre, contraintes);

	contraintes.gridx = 0;
	contraintes.gridy = 3;
	content.add(accepter, contraintes);

	contraintes.gridx = 2;
	contraintes.gridy = 1;
	contraintes.gridwidth = 2;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	content.add(autreChambre, contraintes);

	contraintes.gridx = 2;
	contraintes.gridy = 2;
	content.add(possibChambre, contraintes);

	/* Ajout du Panel contenant tous les éléments au CardLayout */
	cards.add(content, listContent[1]);

	Controleur c3 = new Controleur(3, content);
	c3.setView(this);
	accepter.addActionListener(c3);
    }

    public void TroisiemeFenetre() {
	JLabel nomClient = new JLabel("Nom Client"); //à modifier
	JLabel chambre = new JLabel("Chambre attribuée :");
	JLabel numChambre = new JLabel("Numéro de chambre");//à modifier
	JButton menu = new JButton("Revenir au menu");
	lastPage.setLayout(new GridBagLayout());
	GridBagConstraints contraintes = new GridBagConstraints();

	contraintes.gridx = 1;
	contraintes.gridy = 0;
	contraintes.ipady = 20;
	contraintes.insets = new Insets(50,300,50,300);
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	contraintes.anchor = GridBagConstraints.CENTER;
	contraintes.weightx = 0.1;
        lastPage.add(nomClient, contraintes);

	contraintes.gridx = 1;
	contraintes.gridy = 1;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	lastPage.add(chambre, contraintes);

	contraintes.gridx = 1;
	contraintes.gridy = 2;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	lastPage.add(numChambre, contraintes);

	contraintes.gridx = 1;
	contraintes.gridy = 3;
	contraintes.fill = GridBagConstraints.HORIZONTAL;
	lastPage.add(menu, contraintes);

	cards.add(lastPage, listContent[2]);

	Controleur c4 = new Controleur(4,lastPage);
	c4.setView(this);
	menu.addActionListener(c4);
    }
	
    public static void main(String[] args) {
	View view = new View();
    }
}



