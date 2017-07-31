package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcOperationsJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spOperationsRestControllerJSON {

    @Autowired
    StoreProcOperationsJsonImpl storeProcOperationsJson;

    @RequestMapping(value = "/sp_search_operations", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getPriceListsJSON(@RequestParam("docid") Long docId) throws SQLException {

        String result = storeProcOperationsJson.getOperations_sp(docId);
        return result;
    }
}
