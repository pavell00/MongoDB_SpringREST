package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.Folder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcFolderRepository {

    List<Folder> getFolders_sp(Long root_id, String type_folder, Long roleid);
}
