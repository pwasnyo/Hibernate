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
/* InheritanceType.TABLE_PER_CLASS une table par classe */

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
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
