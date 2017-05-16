package hello;

import org.springframework.data.annotation.Id;

public class Documents2 {

    @Id private String id;

    private String docName;

    public String getDocName() {
        return docName;
    }

    public void setDocName(String firstName) {
        this.docName = firstName;
    }

}