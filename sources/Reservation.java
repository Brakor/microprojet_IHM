import java.util.Date;

public class Reservation{
  private Date date;
  private int numero;
  private Client client;
  private Chambre chambre;

  public Reservation(int num, String d, Client c, Chambre c2){
//    this.date = new Date(d);   
    this.numero = num;
    this.client = c;
    this.chambre = c2;
  }

  public int getNumeroReservation(){
    return this.numero;
  }

  public Date getDate(){
    return this.date;
  }

  public Client trouverClient(String nom, String prenom, Client[] c){
    for(int i = 0; i < c.length; i++){
      if(c[i].getPrenom().equals(prenom) &&
          c[i].getNom().equals(nom))
        return c[i];
    }

    return null;
  }

  public Client trouverClient(int numeroReservation, Reservation[] r){
    for(int i = 0; i < r.length; i++){
      if(r[i].numero == numeroReservation)
        return r[i].client;
    }

    return null;
  }
}
