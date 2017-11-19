// Par Yann Pascoet et Romain Simon

public class Client{
  private String nom;
  private String prenom;
  private int id;

  public Client(String n, String p, int num){
    this.nom = n;
    this.prenom = p;
    this.id = num;
  }

  public void setNom(String newNom){
    this.nom = newNom;
  }

  public void setPrenom(String newPrenom){
    this.prenom = newPrenom;
  }

  public String getNom(){
    return this.nom;
  }

  public String getPrenom(){
    return this.prenom;
  }
}
