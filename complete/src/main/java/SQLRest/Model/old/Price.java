package SQLRest.Model.old;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Price implements Serializable {

    @Id
    @Column(name = "prc_id")
    private Long id;

    @Column(name = "prc_name")
    private String prcName;

    public Price() {
    }

    public Price(Long id, String prcName) {
        this.id = id;
        this.prcName = prcName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrcName() {
        return prcName;
    }

    public void setPrcName(String prcName) {
        this.prcName = prcName;
    }
}
