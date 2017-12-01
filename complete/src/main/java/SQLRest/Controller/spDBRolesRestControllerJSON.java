package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcDBRolesJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
@CrossOrigin
public class spDBRolesRestControllerJSON {

    @Autowired
    StoreProcDBRolesJsonImpl storeProcDBRolesJson;

    @RequestMapping(value = "/sp_dbroles", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getDocuments() throws SQLException {

        String result = storeProcDBRolesJson.getDBRoles_sp();
        return result;
    }
}
