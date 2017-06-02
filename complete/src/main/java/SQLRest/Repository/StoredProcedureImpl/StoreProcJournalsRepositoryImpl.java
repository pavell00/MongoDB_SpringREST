package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Journal;
import SQLRest.Repository.StoredProcedure.StoreProcJournalRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
public class StoreProcJournalsRepositoryImpl implements StoreProcJournalRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Journal> getJournals_sp(Long docid) {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_journals");

        //  Set the parameters of the stored procedure.
        query.setParameter("docid", docid);

        // Call the stored procedure.
        List<Journal> queryResultList = query.getResultList();
        return queryResultList;
    }
}
