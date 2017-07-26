package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.PriceLists;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcPriceListsRepository {
    List<PriceLists> getPriceLists_sp();
}
