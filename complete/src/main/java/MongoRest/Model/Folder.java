package MongoRest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "vw_folders")
public class Folder {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_children")
    private Boolean isChildren;

    @Column(name = "root_id")
    private Long rootId;

    @Column(name = "type_folder")
    private String typeFolder;

    //private Long formId;

    public Folder(){}

    public Folder(Long id, String name, Boolean children, Long rootId, String typeFolder){}

    public Folder(Folder folder){
        this(folder.getId(), folder.getName(), folder.getChildren(),
        folder.getRootId(), folder.getTypeFolder());
               // , folder.getFormId());
    }

    public Folder(Long id, String name, Long rootId, String typeFolder, Long formId){
        this.id = id;
        this.name = name;
        this.typeFolder = typeFolder;
        //this.formId = formId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    public String getTypeFolder() {
        return typeFolder;
    }

    public void setTypeFolder(String typeFolder) {
        this.typeFolder = typeFolder;
    }

    /*public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }*/

    @Override
    public String toString(){
        return "Document (" +
                "id=" + getId() +
                ", name=" + getName() +
                ", typeFolder=" + getTypeFolder() +
              //  ", formId=" + getFormId() +
                ")";
    }
}
