package SQLRest.Repository.StoredProcedure.old;

import SQLRest.Model.old.PriceLists;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcPriceListsRepository {
    List<PriceLists> getPriceLists_sp();
}
