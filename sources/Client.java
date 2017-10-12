public class Client{
  private String nom;
  private String prenom;
  private int id;

  public Client(String n, String p, int num){
    this.nom = n;
    this.prenom = p;
    this.id = num;
  }

  public void setNom(String n){
    this.nom = n;
  }

  public void setPrenom(String p){
    this.prenom = p;
  }

  public String getNom(){
    return this.nom;
  }

  public String getPrenom(){
    return this.prenom;
  }
}
