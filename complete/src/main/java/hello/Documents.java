package hello;

import org.springframework.data.annotation.Id;

public class Documents {

    @Id private String id;
    private Long fldId;
    private Long docId;
    private String docName;
    private String dateItem;
    private Boolean isDone;

    public Long getFldId() {
        return fldId;
    }

    public void setFldId(Long fldId) {
        this.fldId = fldId;
    }

     public Long getDocId() {
        return docId;
    }
    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDateItem() {
        return dateItem;
    }

    public void setDateItem(String dateItem) {
        this.dateItem = dateItem;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

}
