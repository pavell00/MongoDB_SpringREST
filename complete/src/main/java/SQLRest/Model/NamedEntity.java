package SQLRest.Model;

public abstract class NamedEntity extends BaseEntity {

    protected String name;

    public NamedEntity() {
    }

    protected NamedEntity(String id, String name) {
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}
