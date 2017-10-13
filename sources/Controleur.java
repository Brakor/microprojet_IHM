import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controleur implements ActionListener {
    int id = 0;
    JPanel p = new JPanel();
    View view;
    
    public Controleur(int i, JPanel panneau) {
	this.id = i;
	this.p = panneau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (id == 1) {
	    view.DeuxiemeFenetre();
	    view.card.next(view.cards);
	    view.panneau.removeAll();
	    view.panneau.updateUI();
	}
	else if (id == 2) {
	    view.DeuxiemeFenetre();
	    view.card.next(view.cards);
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
    }

    public void setView(View view) {
	this.view = view;
    }
}
