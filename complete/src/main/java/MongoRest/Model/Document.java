package MongoRest.Model;

public class Document extends NamedEntity {

    private Long fldId;
//    private Long docId;
    private String dateItem;
    private Boolean isDone;

    public Document(){}

    //public Document(Integer id, String name, Long fldId, String dateItem, Boolean done){}

    public Document(Document document){
        this(document.getId(), document.getName(), document.getFldId(),
                document.getDateItem(), document.getDone());
    }
    public Long getFldId() {
        return fldId;
    }

    public Document(String id, String name, Long fldId, String dateItem, Boolean done){
        super(id, name);
        this.fldId = fldId;
        this.dateItem = dateItem;
        this.isDone = done;
    }

    public void setFldId(Long fldId) {
        this.fldId = fldId;
    }

 /*   public Long getDocId() {
        return docId;
    }
    public void setDocId(Long docId) {
        this.docId = docId;
    }*/

/*    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }*/

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

    @Override
    public String toString(){
        return "Document (" +
                "id=" + getId() +
                ", name=" + getName() +
                ", fldId=" + getFldId() +
                ", done=" + getDone() +
                ")";
    }
}
