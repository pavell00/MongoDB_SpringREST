package MongoRest.Model;

import java.util.Set;

public class Folder extends NamedEntity {

    private Boolean isChildren;
    private Long rootId;
    private Set<EnumType> typeFolder;
    private Long formId;

    public Folder(){}

    public Folder(String id, String name, Long rootId, Set<EnumType> typeFolder, Long formId){
        super(id, name);
        this.typeFolder = typeFolder;
        this.formId = formId;
    }

    public Boolean getChildren() {
        return isChildren;
    }

    public void setChildren(Boolean children) {
        isChildren = children;
    }

    public Long getRootId() {
        return rootId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public Set<EnumType> getTypeFolder() {
        return typeFolder;
    }

    public void setTypeFolder(Set<EnumType> typeFolder) {
        this.typeFolder = typeFolder;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    @Override
    public String toString(){
        return "Document (" +
                "id=" + getId() +
                ", name=" + getName() +
                ", typeFolder=" + getTypeFolder() +
                ", formId=" + getFormId() +
                ")";
    }
}
