package SQLRest.Repository.StoredProcedureImpl.old;

import SQLRest.Model.old.PriceListsJSON;
import SQLRest.Repository.StoredProcedure.old.StoreProcPriceListsRepositoryJSON;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StoreProcPriceListsImplJSON implements StoreProcPriceListsRepositoryJSON {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PriceListsJSON> getPriceListsJSON_sp() {

        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("call_sp_search_pricelistsJSON_");

        List<PriceListsJSON> queryResultList = query.getResultList();

        return queryResultList.stream().map(result -> new PriceListsJSON(
                (Long) result.getId(),
                (String) result.getPrcName()
        )).collect(Collectors.toList());
    }
}
