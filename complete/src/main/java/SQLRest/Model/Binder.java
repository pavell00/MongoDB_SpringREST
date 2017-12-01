package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_searchBinders",
        resultClasses = Binder.class,
        procedureName = "acs.sp_search_binders",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "bindername")
        }
)
public class Binder implements Serializable {

    @Id
    @Column(name = "bind_id")
    private Long id;

    @Column(name = "bind_name")
    private String bindName;

    public Binder() {
    }

    public Binder(Long id, String bindName) {
        this.id = id;
        this.bindName = bindName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBindName() {
        return bindName;
    }

    public void setBindName(String bindName) {
        this.bindName = bindName;
    }
}
