package main.java.hibernatetuto;

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "compte_epargne")
// attribut de la super classe
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "id")),
    @AttributeOverride(name = "numero", column = @Column(name = "numero")),
    @AttributeOverride(name = "solde", column = @Column(name = "solde")) })
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
