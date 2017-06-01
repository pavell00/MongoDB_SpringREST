package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.sp_Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface StoreProcFolderRepository {

    List<sp_Folder> getFolders_sp(Long root_id, String type_folder);
}
