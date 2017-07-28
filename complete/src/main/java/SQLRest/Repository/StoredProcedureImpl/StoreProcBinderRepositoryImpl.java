package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Binder;
import SQLRest.Repository.StoredProcedure.StoreProcBinderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StoreProcBinderRepositoryImpl implements StoreProcBinderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Binder> getBinders_sp(String name) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_searchBinders");

        //  Set the parameters of the stored procedure.
        query.setParameter("bindername", name);

        // Call the stored procedure.
        List<Binder> queryResultList = query.getResultList();

        return queryResultList.stream().map(result -> new Binder(
                (Long) result.getId(),
                (String) result.getBindName()
        )).collect(Collectors.toList());
    }
}
