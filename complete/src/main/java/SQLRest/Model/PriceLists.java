package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_search_pricelists",
        resultClasses = PriceLists.class,
        procedureName = "sp_search_pricelists2"
)
public class PriceLists implements Serializable {

    @Id
    @Column(name = "prl_id")
    private Long id;

    @Column(name = "prl_name")
    private String prcName;

    @Column(name = "prices")
    private Price[] prices;

    public PriceLists() {
    }

    public PriceLists(Long id, String prcName, Price[] prices) {
        this.id = id;
        this.prcName = prcName;
        this.prices = prices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrcName() {
        return prcName;
    }

    public void setPrcName(String prcName) {
        this.prcName = prcName;
    }

    public Price[] getPrices() {
        return prices;
    }

    public void setPrices(Price[] prices) {
        this.prices = prices;
    }
}
