package SQLRest.Controller;

import SQLRest.Model.PriceListsJSON;
import SQLRest.Repository.StoredProcedure.StoreProcPriceListsRepositoryJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class spPriceListsRestControllerJSON {

    @Autowired
    private StoreProcPriceListsRepositoryJSON storeProcPriceListsRepositoryJSON;

    @RequestMapping(value = "/sp_pricejson", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<PriceListsJSON> getPriceListsJSON() {

        List<PriceListsJSON> priceListsJSON = storeProcPriceListsRepositoryJSON.getPriceListsJSON_sp();
        return priceListsJSON;
    }
}
