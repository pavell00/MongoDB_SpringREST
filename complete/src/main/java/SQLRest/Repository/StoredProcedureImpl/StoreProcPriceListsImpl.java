package SQLRest.Repository.StoredProcedureImpl;

import SQLRest.Model.Price;
import SQLRest.Model.PriceLists;
import SQLRest.Repository.StoredProcedure.StoreProcPriceListsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StoreProcPriceListsImpl implements StoreProcPriceListsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PriceLists> getPriceLists_sp() {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_search_pricelists");

        List<PriceLists> queryResultList = query.getResultList();

        return queryResultList.stream().map(result -> new PriceLists(
                (Long) result.getId(),
                (String) result.getPrcName()
                ,(Price[]) result.getPrices()
        )).collect(Collectors.toList());
        //return queryResultList;
    }
}
