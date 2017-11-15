// Par Yann Pascoet et Romain Simon

public abstract class Chambre{
  private byte numero;
  private boolean proprete;
  private boolean occupee;

  public Chambre(byte num){
    this.numero = num;
    this.proprete = true;
    this.occupee = false;
  }

  public void setProprete(boolean prop){
    this.proprete = prop;
  }

  public void setOccupee(boolean occ){
    this.occupee = occ;
  }

  public byte getNumero(){
    return this.numero;
  }

  public boolean getProprete(){
    return this.proprete;
  }

  public boolean getOccupee(){
    return this.occupee;
  }
}
