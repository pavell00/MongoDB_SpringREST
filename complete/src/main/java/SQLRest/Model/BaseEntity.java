package SQLRest.Model;

import org.springframework.data.annotation.Id;

public class BaseEntity {

    @Id protected String id;

    public BaseEntity() {
    }

    protected BaseEntity(String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isNew() {
        return (getId() == null);
    }

    public int hashCode() {
        return (getId() == null) ? 0 : Integer.parseInt(getId().toString());
    }

    public String toString() {
        return String.format("Entity of type %s with id: %s", getClass().getName(), getId());
    }
}
