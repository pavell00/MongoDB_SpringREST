package SQLRest.Repository.Jpa;

import SQLRest.Model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//@CrossOrigin
//@RepositoryRestResource(collectionResourceRel = "folders", path = "folders")
@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Folder findById(@Param("id") Long id);
    List<Folder> findByName(@Param("name") String name);
    List<Folder> findByRootIdOrderByName(@Param("root_id") Long root_id);
    List<Folder> findByRootIdAndTypeFolderOrderByName(@Param("rootId") Long root_id,
                                                      @Param("typeFolder") String type_folder);
}
