package SQLRest.Model.old;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_onefield",
        resultClasses = OneField.class,
        procedureName = "sp_onefield",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "nom"),
        }
)
public class OneField implements Serializable {

    @Id
    @Column(name = "ent_id")
    private Long Id;

    @Column(name = "ent_nom")
    private String entNom;

    public OneField() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEntNom() {
        return entNom;
    }

    public void setEntNom(String entNom) {
        this.entNom = entNom;
    }
}
