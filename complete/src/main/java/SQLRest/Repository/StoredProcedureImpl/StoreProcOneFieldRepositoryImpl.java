package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.OneField;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class StoreProcOneFieldRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<OneField> getEntNom(String nom){
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_onefield");

        //  Set the parameters of the stored procedure.
        query.setParameter("nom", nom);

        // Call the stored procedure.
        List<OneField> queryResultList = query.getResultList();
        return queryResultList;
    }
}
