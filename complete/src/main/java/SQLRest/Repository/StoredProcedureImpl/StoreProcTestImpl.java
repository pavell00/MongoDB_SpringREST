package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.test;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class StoreProcTestImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public String getTest_sp(Long root_id, String type_folder) {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_foldersJSON");

        //  Set the parameters of the stored procedure.
        query.setParameter("rootid", root_id);
        query.setParameter("typefolder", type_folder);

        // Call the stored procedure.
        String queryResult =  query.getSingleResult().toString();

        return queryResult;
    }
}
