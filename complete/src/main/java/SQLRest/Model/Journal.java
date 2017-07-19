package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_journals",
        resultClasses = Journal.class,
        procedureName = "sp_journals",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "docid")
        }
)
public class Journal implements Serializable {

    @Id
    @Column(name = "j_id")
    private Long id;

    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "j_tr_no")
    private Long jTrNo;

    @Column(name = "j_ln_no")
    private Long jLnNo;

    @Column(name = "j_sum")
    private Double jSum;

    @Column(name = "j_qty")
    private Double jQty;

    @Column(name = "j_ent")
    private Long jEnt;

    @Column(name = "j_price")
    private Double jPrice;

    @Column(name = "acc_db")
    private Long jAccDb;

    @Column(name = "acc_cr")
    private Long jAccCr;

    @Column(name = "j_ag1")
    private Long jAg1;

    @Column(name = "j_Ag2")
    private Long jAg2;

    @Column(name = "ag1_name")
    private String jAg1name;

    @Column(name = "ag2_name")
    private String jAg2name;

    @Column(name = "ent_name")
    private String entName;

    public Journal(){}

    public Journal(Long id, Long docId, Long jTrNo, Long jLnNo, Double jSum, Double jQty, Long jEnt, Double jPrice,
                   Long jAccDb, Long jAccCr, Long jAg1, Long jAg2, String jAg1name, String jAg2name, String entName) {
        this.id = id;
        this.docId = docId;
        this.jTrNo = jTrNo;
        this.jLnNo = jLnNo;
        this.jSum = jSum;
        this.jQty = jQty;
        this.jEnt = jEnt;
        this.jPrice = jPrice;
        this.jAccDb = jAccDb;
        this.jAccCr = jAccCr;
        this.jAg1 = jAg1;
        this.jAg2 = jAg2;
        this.jAg1name = jAg1name;
        this.jAg2name = jAg2name;
        this.entName = entName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getjTrNo() {
        return jTrNo;
    }

    public void setjTrNo(Long jTrNo) {
        this.jTrNo = jTrNo;
    }

    public Long getjLnNo() {
        return jLnNo;
    }

    public void setjLnNo(Long jLnNo) {
        this.jLnNo = jLnNo;
    }

    public Double getjSum() {
        return jSum;
    }

    public void setjSum(Double jSum) {
        this.jSum = jSum;
    }

    public Double getjQty() {
        return jQty;
    }

    public void setjQty(Double jQty) {
        this.jQty = jQty;
    }

    public Long getjEnt() {
        return jEnt;
    }

    public void setjEnt(Long jEnt) {
        this.jEnt = jEnt;
    }

    public Double getjPrice() {
        return jPrice;
    }

    public void setjPrice(Double jPrice) {
        this.jPrice = jPrice;
    }

    public Long getjAccDb() {
        return jAccDb;
    }

    public void setjAccDb(Long jAccDb) {
        this.jAccDb = jAccDb;
    }

    public Long getjAccCr() {
        return jAccCr;
    }

    public void setjAccCr(Long jAccCr) {
        this.jAccCr = jAccCr;
    }

    public Long getjAg1() {
        return jAg1;
    }

    public void setjAg1(Long jAg1) {
        this.jAg1 = jAg1;
    }

    public Long getjAg2() {
        return jAg2;
    }

    public void setjAg2(Long jAg2) {
        this.jAg2 = jAg2;
    }

    public String getjAg1name() {
        return jAg1name;
    }

    public void setjAg1name(String jAg1name) {
        this.jAg1name = jAg1name;
    }

    public String getjAg2name() {
        return jAg2name;
    }

    public void setjAg2name(String jAg2name) {
        this.jAg2name = jAg2name;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }
}
