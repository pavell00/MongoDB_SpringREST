package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Entities;
import SQLRest.Repository.StoredProcedure.StoreProcEntitiesRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StoreProcEntitiesRepositoryImpl  implements StoreProcEntitiesRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Entities> findByCriteria(String criteria, String valuestr, Long valuelong) {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_findEntities");

        //  Set the parameters of the stored procedure.
        query.setParameter("criteria", criteria);
        query.setParameter("valuestr", valuestr);
        query.setParameter("valuelong", valuelong);

        // Call the stored procedure.
        List<Entities> queryResultList = query.getResultList();

        return queryResultList.stream().map(result -> new Entities(
                (Long) result.getId(),
                (Long) result.getEntType(),
                (String) result.getEntName(),
                (Long) result.getEntCat(),
                (Long) result.getEntNom()
        )).collect(Collectors.toList());

        //return queryResultList;
    }

}
