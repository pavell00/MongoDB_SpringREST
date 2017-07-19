package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Folder;
import SQLRest.Repository.StoredProcedure.StoreProcFolderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StoreProcFolderRepositoryImpl implements StoreProcFolderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Folder> getFolders_sp(Long root_id, String type_folder) {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_folders");

        //  Set the parameters of the stored procedure.
        query.setParameter("rootid", root_id);
        query.setParameter("typefolder", type_folder);

        // Call the stored procedure.
        List<Folder> queryResultList = query.getResultList();

        return queryResultList.stream().map(result -> new Folder(
                (Long) result.getId(),
                (String) result.getName(),
                (Boolean) result.getIsChildren(),
                (Long) result.getRootId(),
                (String) result.getTypeFolder(),
                (Long) result.getTmlId()
        )).collect(Collectors.toList());

        //return queryResultList;
    }
}
