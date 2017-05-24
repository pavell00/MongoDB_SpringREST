package SQLRest.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "vw_folders")
public class Folder implements Serializable {

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

    @Column(name = "tml_id")
    private Long tmlId;

    public Folder(){}

    public Folder(Long id, String name, Boolean children, Long rootId, String typeFolder, long tmlId){}

    public Folder(Folder folder){
        this(folder.getId(), folder.getName(), folder.getChildren(),
        folder.getRootId(), folder.getTypeFolder(), folder.getTmlId());
    }

    public Folder(Long id, String name, Long rootId, String typeFolder, Long tmlId){
        this.id = id;
        this.name = name;
        this.typeFolder = typeFolder;
        this.tmlId = tmlId;
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

    public Long getTmlId() {
        return tmlId;
    }

    public void setTmlId(Long tmlId) {
        this.tmlId = tmlId;
    }

    @Override
    public String toString(){
        return "Document (" +
                "id=" + getId() +
                ", name=" + getName() +
                ", typeFolder=" + getTypeFolder() +
                ", tmlId=" + getTmlId() +
                ")";
    }
}
