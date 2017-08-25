package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Template;
import SQLRest.Repository.StoredProcedure.StoreProcTemplateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StoreProcTemplateImpl implements StoreProcTemplateRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Template> getTemplate_sp(Long tmlid, Long mode) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_template");

        //  Set the parameters of the stored procedure.
        query.setParameter("tmlid", tmlid);
        query.setParameter("mode", mode);

        // Call the stored procedure.
        List<Template> queryResultList = query.getResultList();

        return queryResultList.stream().map(result -> new Template(
                (Long) result.getId(),
                (String) result.getTmlGuid(),
                (String) result.getTmlName(),
                (Long) result.getFrmId(),
                (String) result.getTmlScript()
          )).collect(Collectors.toList());
    }
}
