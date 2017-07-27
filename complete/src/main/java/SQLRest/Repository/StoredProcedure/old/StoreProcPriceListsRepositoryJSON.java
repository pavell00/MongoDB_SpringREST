package SQLRest.Repository.StoredProcedure.old;

import SQLRest.Model.old.PriceListsJSON;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcPriceListsRepositoryJSON {
    List<PriceListsJSON> getPriceListsJSON_sp();
}
