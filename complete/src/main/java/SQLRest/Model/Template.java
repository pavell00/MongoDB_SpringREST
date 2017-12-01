package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_template",
        resultClasses = Template.class,
        procedureName = "acs.sp_template",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "tmlid"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "mode"),
        }
)
public class Template implements Serializable {

    @Id
    @Column(name = "tml_id")
    private Long id;

    @Column(name = "tml_guid", columnDefinition = "uniqueidentifier")
    private String tmlGuid;

    @Column(name = "tml_name")
    private String tmlName;

    @Column(name = "frm_id")
    private Long frmId;

    @Column(name = "tml_script")
    private String tmlScript;

    @Column(name = "fld_id")
    private Long fldId;

    public Template() {
    }

    public Template(Long id, String tmlGuid, String tmlName, Long frmId,
                    String tmlScript, Long fldId) {
        this.id = id;
        this.tmlGuid = tmlGuid;
        this.tmlName = tmlName;
        this.frmId = frmId;
        this.tmlScript = tmlScript;
        this.fldId = fldId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTmlGuid() {
        return tmlGuid;
    }

    public void setTmlGuid(String tmlGuid) {
        this.tmlGuid = tmlGuid;
    }

    public String getTmlName() {
        return tmlName;
    }

    public void setTmlName(String tmlName) {
        this.tmlName = tmlName;
    }

    public Long getFrmId() {
        return frmId;
    }

    public void setFrmId(Long frmId) {
        this.frmId = frmId;
    }

    public String getTmlScript() {
        return tmlScript;
    }

    public void setTmlScript(String tmlScript) {
        this.tmlScript = tmlScript;
    }

    public Long getFldId() {
        return fldId;
    }

    public void setFldId(Long fldId) {
        this.fldId = fldId;
    }
}
