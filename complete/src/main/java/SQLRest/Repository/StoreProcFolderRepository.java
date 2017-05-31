package SQLRest.Repository;

import SQLRest.Model.sp_Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface StoreProcFolderRepository {

/*    sp_Folder findById(@Param("id") Long id);
    List<sp_Folder> findByName(@Param("name") String name);
    List<sp_Folder> findByRootIdOrderByName(@Param("root_id") Long root_id);
    List<sp_Folder> findByRootIdAndTypeFolderOrderByName(@Param("rootId") Long root_id,
                                                      @Param("typeFolder") String type_folder);
    @Procedure
    List<sp_Folder> sp_folders(@Param("root_id") Long root_id);*/

    List<sp_Folder> getFoldersFromStoreProcedure(Long root_id, String type_folder);
}
