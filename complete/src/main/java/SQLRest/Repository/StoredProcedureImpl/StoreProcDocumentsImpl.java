package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Document;
import SQLRest.Repository.StoredProcedure.StoreProcDocumentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDate;
import java.util.List;

@Repository
public class StoreProcDocumentsImpl implements StoreProcDocumentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Document> getDocuments_sp(Long root_id, LocalDate startDate,
            LocalDate endDate, String typeDir) {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_documents");

        //  Set the parameters of the stored procedure.
        query.setParameter("rootid", root_id);
        query.setParameter("startdate", startDate);
        query.setParameter("enddate", endDate);
        query.setParameter("typedir", typeDir);
        // Call the stored procedure.
        List<Document> queryResultList = query.getResultList();
        return queryResultList;
    }
}
