package SQLRest.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NamedStoredProcedureQuery(
        name = "call_sp_documents",
        resultClasses = Document.class,
        procedureName = "sp_documents",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "rootid"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = LocalDate.class, name = "startdate"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = LocalDate.class, name = "enddate"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "typedir"),
                @StoredProcedureParameter(mode = ParameterMode.IN, type = Long.class, name = "roleid")
        }
)
public class Document implements Serializable {

    @Id
    @Column(name = "doc_id")
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "doc_date")
    private LocalDateTime docDate;

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

    public Document(Document document){
        this(document.getId(), document.getDocDate(),
                document.getDocDone(), document.getDocNo(),
                document.getDocSum(), document.getDocName(),
                document.getFldId());
    }

    public Document(Long id, LocalDateTime docDate, Integer docDone, String docNo,
                    Double docSum, String docName, Long fldId) {
        this.id = id;
        this.docDate = docDate;
        this.docDone = docDone;
        this.docNo = docNo;
        this.docSum = docSum;
        this.docName = docName;
        this.fldId = fldId;
    }

    /*public Document(Long docId, LocalDateTime docDate, Integer docDone, String docNo, Double docSum, String docName) {
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
