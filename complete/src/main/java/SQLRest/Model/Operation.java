package SQLRest.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_operation",
        resultClasses = Operation.class,
        procedureName = "sp_operation",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "docid")
        }
)
public class Operation implements Serializable {

    @Id
    @Column(name = "doc_id")
    private Long id;

    @Column(name = "doc_name")
    private String docName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "doc_date")
    private LocalDateTime docDate;

    @Column(name = "doc_done")
    private Integer docDone;

    @Column(name = "doc_no")
    private String docNo;

    @Column(name = "doc_sum")
    private Double docSum;

    @Column(name = "doc_tml")
    private Long tmlId;

    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "Journal",
    //            cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Journal> transictions;

    public Operation() {
    }

    public Operation(Long id, String docName, LocalDateTime docDate, Integer docDone,
                     String docNo, Double docSum, Long tmlId) {
        this.id = id;
        this.docName = docName;
        this.docDate = docDate;
        this.docDone = docDone;
        this.docNo = docNo;
        this.docSum = docSum;
        this.tmlId = tmlId;
        //this.transictions = transictions; , List<Journal> transictions
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public LocalDateTime getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDateTime docDate) {
        this.docDate = docDate;
    }

    public Integer getDocDone() {
        return docDone;
    }

    public void setDocDone(Integer docDone) {
        this.docDone = docDone;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Double getDocSum() {
        return docSum;
    }

    public void setDocSum(Double docSum) {
        this.docSum = docSum;
    }

    public Long getTmlId() {
        return tmlId;
    }

    public void setTmlId(Long tmlId) {
        this.tmlId = tmlId;
    }

    /*public List<Journal> getTransictions() {
        return transictions;
    }

    public void setTransictions(List<Journal> transictions) {
        this.transictions = transictions;
    }*/
}
