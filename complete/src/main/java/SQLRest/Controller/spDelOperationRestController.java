package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcDelOperationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spDelOperationRestController {

    @Autowired
    StoreProcDelOperationImpl storeProcDelOperation;

    @RequestMapping(value = "/sp_del_operation", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public String getPriceListsJSON(@RequestParam("docid") Long docId,
                                    @RequestParam("roleid") Long roleid) throws SQLException {

        return storeProcDelOperation.delOperation(docId, roleid);
    }
}
