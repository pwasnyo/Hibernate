package main.java.hibernatetuto;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * les Resource doives être dans src/main/resources java files dans
 * src/main/java pour être chargé dans le classpath java
 */
@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "id")
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "dateNais")
    private Date dateNais;
    
    /*OneToOne Une Personne n'a qu'une Adresse et une adresse appartient à une seule personne donc relation 1:1
    Il y'a 2 cas unidirectionnel (on a une clé primaire (table maître) qui est référencée via une clé secondaire dans la table esclave)
    dans cette exemple c'est le mode bidirectionnel c-à-d, l'entité esclave doit préciser un champ retour par une annotation @OneToOne et un attribut mappedBy,
    qui doit référencer le champ qui porte la relation côté maître*/
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
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
