package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Journal;
import SQLRest.Repository.StoredProcedure.StoreProcJournalRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

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

        return queryResultList.stream().map(result -> new Journal(
                (Long) result.getId(),
                (Long) result.getDocId(),
                (Long) result.getjTrNo(),
                (Long) result.getjLnNo(),
                (Double) result.getjSum(),
                (Double) result.getjQty(),
                (Long) result.getjEnt(),
                (Double) result.getjPrice(),
                (Long) result.getjAccDb(),
                (Long) result.getjAccCr(),
                (Long) result.getjAg1(),
                (Long) result.getjAg2(),
                (String) result.getjAg1name(),
                (String) result.getjAg2name(),
                (String) result.getEntName()
        )).collect(Collectors.toList());

        //return queryResultList;
    }
}