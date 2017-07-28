package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcPriceListsJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spPriceListsRestControllerJSON {

    @Autowired
    private StoreProcPriceListsJsonImpl storeProcPriceListsJson;

    @RequestMapping(value = "/sp_search_pricelists", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getPriceListsJSON() throws SQLException {

        String result = storeProcPriceListsJson.getPriceLists_sp();
        return result;
    }
}
