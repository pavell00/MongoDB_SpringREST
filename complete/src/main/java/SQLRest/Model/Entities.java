package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_findEntities",
        resultClasses = Entities.class,
        procedureName = "acs.sp_findEntities",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "criteria"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "valuestr"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "valuelong")
        }
)
public class Entities implements Serializable {

    @Id
    @Column(name = "ent_id")
    private Long id;

    @Column(name = "ent_type")
    private Long entType;

    @Column(name = "ent_name")
    private String entName;

    @Column(name = "ent_cat")
    private Long entCat;

    @Column(name = "ent_nom")
    private Long entNom;

    public Entities() {
    }

    public Entities(Long id, Long entType, String entName, Long entCat, Long entNom) {
        this.id = id;
        this.entType = entType;
        this.entName = entName;
        this.entCat = entCat;
        this.entNom = entNom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntType() {
        return entType;
    }

    public void setEntType(Long entType) {
        this.entType = entType;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public Long getEntCat() {
        return entCat;
    }

    public void setEntCat(Long entCat) {
        this.entCat = entCat;
    }

    public Long getEntNom() {
        return entNom;
    }

    public void setEntNom(Long entNom) {
        this.entNom = entNom;
    }
}
