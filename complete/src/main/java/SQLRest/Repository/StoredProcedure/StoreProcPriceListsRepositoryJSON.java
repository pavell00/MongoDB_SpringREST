package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.PriceListsJSON;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcPriceListsRepositoryJSON {
    List<PriceListsJSON> getPriceListsJSON_sp();
}
