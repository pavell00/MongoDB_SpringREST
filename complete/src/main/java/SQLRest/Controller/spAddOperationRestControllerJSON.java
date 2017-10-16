package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcAddOperationJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spAddOperationRestControllerJSON {

    @Autowired
    StoreProcAddOperationJsonImpl storeProcAddOperationJson;

    @RequestMapping(value = "/sp_add_operation", method = RequestMethod.POST, headers = "Accept=application/json")
    public String getPriceListsJSON(@RequestBody String operation) throws SQLException {

        String result = storeProcAddOperationJson.saveOperation(operation);
        return result;
    }
}
