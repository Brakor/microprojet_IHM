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
	}

	else if (id == 2) {
	    view.DeuxiemeFenetre();
	    view.card.next(view.cards);
	}
    }

    public void setView(View view) {
	this.view = view;
    }
}
