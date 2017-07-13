package main.java.hibernatetuto;
import java.util.Date;
/**
 * les Resource doives être dans src/main/resources
    java files dans src/main/java
    * pour être chargé dans le classpath java
*/
public class Personne {

  private Long id;
  private String nom;
  private String prenom;
  private Date dateNais;
  private Adresse adresse;

  public Personne(String nom, String prenom, Date dateNais, Adresse adresse) {
    this.nom = nom;
    this.prenom = prenom;
    this.dateNais = dateNais;
    this.adresse = adresse;
  }

  public Personne() {
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public Date getDateNais() {
    return dateNais;
  }

  public void setDateNais(Date dateNais) {
    this.dateNais = dateNais;
  }

  public Long getId() {
    return id;
  }

  // Attention le setter est requis par Hibernate
  public void setId(Long id) {
    this.id = id;
  }

  public Adresse getAdresse() {
    return adresse;
  }

  public void setAdresse(Adresse adresse) {
    this.adresse = adresse;
  }

  @Override
  public String toString() {
    return this.id + " : " + this.nom + " " + this.prenom;
  }
}