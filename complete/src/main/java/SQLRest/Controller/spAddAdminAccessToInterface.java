package SQLRest.Controller;

import SQLRest.Repository.StoreProcAddAdminAccessElementJsonImpl;
import SQLRest.Repository.StoredProcedureImpl.StoreProcAddOperationJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spAddAdminAccessToInterface {
    @Autowired
    StoreProcAddAdminAccessElementJsonImpl storeProcAddAdminAccessElementJson;

    @RequestMapping(value = "/sp_elementaccess", method = RequestMethod.POST, headers = "Accept=application/json")
    public String getPriceListsJSON(@RequestBody String operation) throws SQLException {

        String result = storeProcAddAdminAccessElementJson.saveAdminAccessToInterface(operation);
        return result;
    }
}
