package SQLRest.Repository;

import SQLRest.Model.sp_Folder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by net_master on 31.05.2017.
 */

@Repository
public class StoreProcFolderRepositoryImpl implements StoreProcFolderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<sp_Folder> getFoldersFromStoreProcedure(Long root_id, String type_folder) {

        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("callStoreProcedure");

        //  Set the parameters of the stored procedure.
        storedProcedureQuery.setParameter("rootid", root_id);
        storedProcedureQuery.setParameter("typefolder", type_folder);

        // Call the stored procedure.
        List<sp_Folder> storedProcedureQueryResultList = storedProcedureQuery.getResultList();

        /*storedProcedureQueryResultList.stream().map(result -> new sp_Folder(
                (Long) result[0],
                (String) result[1],
                (Boolean) result[2],
                (Long) result[3],
                (String) result[4],
                (Long) result[5]
        )).collect(Collectors.toList());*/

        return storedProcedureQueryResultList;
    }
}
