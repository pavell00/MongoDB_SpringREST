package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Agent;
import SQLRest.Repository.StoredProcedure.StoreProcAgentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StoreProcAgentRepositoryImpl implements StoreProcAgentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Agent> getAgent_sp(String criteria, String valuestr, Long valuelong) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_findAgents");

        //  Set the parameters of the stored procedure.
        query.setParameter("criteria", criteria);
        query.setParameter("valuestr", valuestr);
        query.setParameter("valuelong", valuelong);

        // Call the stored procedure.
        List<Agent> queryResultList = query.getResultList();

        return queryResultList.stream().map(result -> new Agent(
                (Long) result.getId(),
                (String) result.getAgGuid(),
                (String) result.getAgName(),
                (Long) result.getAgType(),
                (String) result.getAgTag(),
                (String) result.getAgMemo(),
                (String) result.getAgCode(),
                (String) result.getAgAddress(),
                (String) result.getAgPhone(),
                (String) result.getAgPassport(),
                (String) result.getAgVatno(),
                (String) result.getAgRegno()
        )).collect(Collectors.toList());
    }
}
