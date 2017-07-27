package SQLRest.Model.old;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_search_pricelistsJSON",
        resultClasses = test.class,
        procedureName = "sp_search_pricelists3"
)
public class test {

    @EmbeddedId
    private Long Id;

    @Column(name = "JSON_F52E2B61-18A1-11d1-B105-00805F49916B")
    //@Column(name = "value")
    private String value;

    public test(){}

    public test( String result) {
        this.value = result;
    }

    @Override
    public String toString() {
        return  value;
    }
}
