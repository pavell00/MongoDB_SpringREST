package SQLRest.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
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

    public Document(){}

    public Document(Long Id, LocalDate docDate, Integer docDone, String docNo, Double docSum, String docName){}

    public Document(Document document){
        this(document.getId(), document.getDocDate(),
                document.getDocDone(), document.getDocNo(),
                document.getDocSum(), document.getDocName());
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

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", docDate=" + docDate +
                ", docDone=" + docDone +
                ", docNo='" + docNo + '\'' +
                ", docSum=" + docSum +
                ", docName='" + docName + '\'' +
                '}';
    }
}
