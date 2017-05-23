package MongoRest.Repository;

import MongoRest.Model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "folder", path = "folder")
public interface FolderRepository extends JpaRepository<Folder, Long> {
    Folder findById(@Param("id") Long id);
    List<Folder> findByName(@Param("name") String name);
    List<Folder> findByRootIdOrderByName(@Param("root_id") Long root_id);
}
