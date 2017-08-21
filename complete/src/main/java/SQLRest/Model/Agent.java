package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_findAgents",
        resultClasses = Agent.class,
        procedureName = "sp_findAgents",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "criteria"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "valuestr"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "valuelong")
        }
)
public class Agent implements Serializable {

    @Id
    @Column(name = "ag_id")
    private Long id;

    @Column(name = "ag_guid", columnDefinition = "uniqueidentifier")
    private String agGuid;

    @Column(name = "ag_name")
    private String agName;

    @Column(name = "ag_type")
    private Long agType;

    @Column(name = "ag_tag")
    private String agTag;

    @Column(name = "ag_memo")
    private String agMemo;

    @Column(name = "ag_code")
    private String agCode;

    @Column(name = "ag_address")
    private String agAddress;

    @Column(name = "ag_phone")
    private String agPhone;

    @Column(name = "ag_passport")
    private String agPassport;

    @Column(name = "ag_vatno")
    private String agVatno;

    @Column(name = "ag_regno")
    private String agRegno;

    public Agent() {
    }

    public Agent(Long id, String agGuid, String agName, Long agType, String agTag, String agMemo,
                 String agCode, String agAddress, String agPhone, String agPassport, String agVatno, String agRegno) {
        this.id = id;
        this.agGuid = agGuid;
        this.agName = agName;
        this.agType = agType;
        this.agTag = agTag;
        this.agMemo = agMemo;
        this.agCode = agCode;
        this.agAddress = agAddress;
        this.agPhone = agPhone;
        this.agPassport = agPassport;
        this.agVatno = agVatno;
        this.agRegno = agRegno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgGuid() {
        return agGuid;
    }

    public void setAgGuid(String agGuid) {
        this.agGuid = agGuid;
    }

    public String getAgName() {
        return agName;
    }

    public void setAgName(String agName) {
        this.agName = agName;
    }

    public Long getAgType() {
        return agType;
    }

    public void setAgType(Long agType) {
        this.agType = agType;
    }

    public String getAgTag() {
        return agTag;
    }

    public void setAgTag(String agTag) {
        this.agTag = agTag;
    }

    public String getAgMemo() {
        return agMemo;
    }

    public void setAgMemo(String agMemo) {
        this.agMemo = agMemo;
    }

    public String getAgCode() {
        return agCode;
    }

    public void setAgCode(String agCode) {
        this.agCode = agCode;
    }

    public String getAgAddress() {
        return agAddress;
    }

    public void setAgAddress(String agAddress) {
        this.agAddress = agAddress;
    }

    public String getAgPhone() {
        return agPhone;
    }

    public void setAgPhone(String agPhone) {
        this.agPhone = agPhone;
    }

    public String getAgPassport() {
        return agPassport;
    }

    public void setAgPassport(String agPassport) {
        this.agPassport = agPassport;
    }

    public String getAgVatno() {
        return agVatno;
    }

    public void setAgVatno(String agVatno) {
        this.agVatno = agVatno;
    }

    public String getAgRegno() {
        return agRegno;
    }

    public void setAgRegno(String agRegno) {
        this.agRegno = agRegno;
    }
}
