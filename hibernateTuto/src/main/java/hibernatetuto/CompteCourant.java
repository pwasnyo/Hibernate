package main.java.hibernatetuto;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author pwasnyo
 */
@Entity
@Table(name = "compte_courant")
public class CompteCourant extends Compte {
    
    protected int decouvert;

    public CompteCourant(int decouvert,String numero, BigDecimal solde) {
        super(numero, solde);
        this.decouvert = decouvert;
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "@" + System.identityHashCode(this)
                + "CompteCourant [id=" + id + ", numero=" + numero + ", solde=" + solde
                + ", decouvert=" + decouvert + "]";
    }
}
