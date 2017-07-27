package SQLRest.Model.old;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import java.io.Serializable;

@JsonAutoDetect
@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_search_pricelistsJSON_",
        resultClasses = PriceListsJSON.class,
        procedureName = "sp_search_pricelists3"
)
public class PriceListsJSON  implements Serializable {

    @Id
    @Column(name = "prl_id")
    @JsonProperty("prl_id")
    private Long id;

    @Column(name = "prl_name")
    @JsonProperty("prl_name")
    private String prl_name;

    //private Price[] prices;

    @JsonCreator
    public PriceListsJSON() {
    }

    @JsonCreator
    public PriceListsJSON(Long id, String prlName) {
        this.id = id;
        this.prl_name = prlName;
        //this.prices = prices; , Price[] prices
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrcName() {
        return prl_name;
    }

    public void setPrcName(String prlName) {
        this.prl_name = prlName;
    }

    /*public Price[] getPrices() {
        return prices;
    }

    public void setPrices(Price[] prices) {
        this.prices = prices;
    }*/
}
