import java.util.Date;

public class Statistiques{
  public Date date;
  public Date dateDebutPeriode;
  public Date dateFinPeriode;
  public int tauxOccupation;
  public int tauxNonPresentation;

  public Statistiques(Date newDate, Date newDateDebutPeriode, Date newDateFinPeriode, Chambre[] chambresOccupees){
    this.date = newDate;
    this.dateDebutPeriode = newDateDebutPeriode;
    this.dateFinPeriode = newDateFinPeriode;
    this.tauxOccupation = chambresOccupees.length;
    this.tauxNonPresentation = 100 - this.tauxOccupation;
  }

  public void setDate(Date newDate){
    this.date = newDate;
  }

  public void setDateDebutPeriode(Date newDate){
    this.dateDebutPeriode = newDate;
  }

  public void setDateFinPeriode(Date newDate){
    this.dateFinPeriode = newDate;
  }

  public Date getDate(){
    return this.date;
  }

  public Date getDateFinPeriode(){
    return this.dateFinPeriode;
  }

  public Date getDateDebutPeriod(){
    return this.dateDebutPeriode;
  }

  public int getTauxOccupation(){
    return this.tauxOccupation;
  }

  public int getTauxNonPresentation(){
    return this.tauxNonPresentation;
  }
}
