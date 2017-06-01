package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.sp_Folder;
import SQLRest.Repository.StoredProcedure.StoreProcFolderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class StoreProcFolderRepositoryImpl implements StoreProcFolderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<sp_Folder> getFolders_sp(Long root_id, String type_folder) {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_folders");

        //  Set the parameters of the stored procedure.
        query.setParameter("rootid", root_id);
        query.setParameter("typefolder", type_folder);

        // Call the stored procedure.
        List<sp_Folder> queryResultList = query.getResultList();

        /*queryResultList.stream().map(result -> new sp_Folder(
                (Long) result[0],
                (String) result[1],
                (Boolean) result[2],
                (Long) result[3],
                (String) result[4],
                (Long) result[5]
        )).collect(Collectors.toList());*/

        return queryResultList;
    }
}
