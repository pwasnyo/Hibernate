package main.java.hibernatetuto;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compte_epargne")
public class CompteEpargne extends Compte {
    protected BigDecimal taux;

    public CompteEpargne(BigDecimal taux,String numero, BigDecimal solde) {
        super(numero, solde);
        this.taux = taux;
    }
    
    public BigDecimal getTaux() {
        return taux;
    }

    public void setTaux(BigDecimal taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "@" + System.identityHashCode(this)
                + "CompteEpargne [ id=" + id + ", numero=" + numero + ", solde="
                + solde + ", taux=" + taux + "]";
    }
}
