package main.java.hibernatetuto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "adresse")
public class Adresse {

  @Id
  @GeneratedValue(generator = "adresseGenerator")
  @org.hibernate.annotations.GenericGenerator(name = "adresseGenerator",strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
  @Column(name = "id")
  private Long id;
  @Column(name = "ligne1_adr", nullable = false)
  private String ligne1;
  @Column(name = "ligne2_adr")
  private String ligne2;
  @Column(name = "cp_adr")
  private String cp;
  @Column(name = "ville_adr")
  private String ville;
  @Column(name = "ligne3_adr")
  private String ligne3;
  
   //Créons par exemple un champ retour dans notre classe Adresse. L'attribut mappedBy est défini sur l'entité esclave de la relation.
  // référence la relation dans la classe Personne sur le champ adresse(class maître: on choisi comme on veut la class maître et esclave)
  @OneToOne(mappedBy = "adresse")
  private Personne personne;

  public Adresse(String ligne1, String ligne2, String cp, String ville, String ligne3) {
    super();
    this.ligne1 = ligne1;
    this.ligne2 = ligne2;
    this.cp = cp;
    this.ville = ville;
    this.ligne3 = ligne3;
  }

  public Adresse() {
  }

  //
  // getter et setter sur les champs de la classe
  //

    public String getLigne1() {
        return ligne1;
    }

    public void setLigne1(String ligne1) {
        this.ligne1 = ligne1;
    }

    public String getLigne2() {
        return ligne2;
    }

    public void setLigne2(String ligne2) {
        this.ligne2 = ligne2;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getLigne3() {
        return ligne3;
    }

    public void setLigne3(String ligne3) {
        this.ligne3 = ligne3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

}
