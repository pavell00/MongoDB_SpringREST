package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_documents",
        resultClasses = Document.class,
        procedureName = "sp_documents",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "rootid"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = LocalDate.class, name = "startdate"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = LocalDate.class, name = "enddate")
        }
)
public class Document implements Serializable {

    @Id
    @Column(name = "doc_id")
    private Long id;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @Column(name = "doc_done")
    private Integer docDone;

    @Column(name = "doc_no")
    private String docNo;

    @Column(name = "doc_sum")
    private Double docSum;

    @Column(name = "doc_name")
    private String docName;

    @Column(name = "fld_id")
    private Long fldId;

    public Document(){}

    public Document(Long Id, LocalDate docDate, Integer docDone, String docNo,
                    Double docSum, String docName, Long fldId){}

    public Document(Document document){
        this(document.getId(), document.getDocDate(),
                document.getDocDone(), document.getDocNo(),
                document.getDocSum(), document.getDocName(),
                document.getFldId());
    }

    /*public Document(Long docId, LocalDate docDate, Integer docDone, String docNo, Currency docSum, String docName) {
        this.id = id;
        this.docDate = docDate;
        this.docDone = docDone;
        this.docNo = docNo;
        this.docSum = docSum;
        this.docName = docName;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDocDate() {
        return docDate;
    }

    public void setDocDate(LocalDate docDate) {
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Long getFldId() {
        return fldId;
    }

    public void setFldId(Long fldId) {
        this.fldId = fldId;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", docDate=" + docDate +
                ", docDone=" + docDone +
                ", docNo='" + docNo + '\'' +
                ", docSum=" + docSum +
                ", docName='" + docName + '\'' +
                ", fldId=" + fldId +
                '}';
    }
}
