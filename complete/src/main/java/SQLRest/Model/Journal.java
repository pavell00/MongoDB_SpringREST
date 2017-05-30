package SQLRest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "journal")
public class Journal {

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

    public Journal(){}

    public Journal(Long id, Long docId, Long jTrNo, Long jLnNo, Double jSum, Double jQty, Long jEnt, Double jPrice) {
        this.id = id;
        this.docId = docId;
        this.jTrNo = jTrNo;
        this.jLnNo = jLnNo;
        this.jSum = jSum;
        this.jQty = jQty;
        this.jEnt = jEnt;
        this.jPrice = jPrice;
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
}
