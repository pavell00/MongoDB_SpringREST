package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcFirstLevelItemsJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spFirstLevelitemsControllerJSON {
    @Autowired
    StoreProcFirstLevelItemsJsonImpl storeProcFirstLevelItemsJson;

    @RequestMapping(value = "/sp_firstlevel", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getPriceListsJSON(@RequestParam("roleid") Long roleid,
                                    @RequestParam("tabid") Long tabid) throws SQLException {

        String result = storeProcFirstLevelItemsJson.getFirstLevelItems_sp(roleid, tabid);
        return result;
    }
}
