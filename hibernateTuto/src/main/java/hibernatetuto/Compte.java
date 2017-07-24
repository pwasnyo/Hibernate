package main.java.hibernatetuto;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "compte")
/* InheritanceType.SINGLE_TABLE veut dire Une seule table celle de la classe parent (compte) dans 
laquelle on enregistrera toutes les données des classes qui hériteront de la classe compte voir appel dans le main.
InheritanceType.SINGLE_TABLE va mettre dans le champs DTYPE de la table compte (voir compte.sql) la classe avec laquelle
on a instancié le compte sauvegardé (Compte ou CompteCourant ou encore CompteCourant)
*/
// Etudier les limite de la methode InheritanceType.SINGLE_TABLE avant de choisir cette technique
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
public class Compte {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "id")
    protected int id;
    @Column(name = "numero")
    protected String numero;
    @Column(name = "solde")
    protected BigDecimal solde;

    public Compte(String numero, BigDecimal solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSolde() {
        return solde;
    }

    public void setSolde(BigDecimal solde) {
        this.solde = solde;
    }

    @Override
    public String toString() {
        return super.toString() + " [id=" + id + ", numero=" + numero + ", solde="
                + solde + "]";
    }
}
