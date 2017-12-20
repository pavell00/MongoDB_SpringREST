package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcAddAdminAccessElementJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spAddAdminAccessToInterface {
    @Autowired
    StoreProcAddAdminAccessElementJsonImpl storeProcAddAdminAccessElementJson;

    @RequestMapping(value = "/sp_elementaccess", method = RequestMethod.POST, headers = "Accept=application/json")
    public String getElementJSON(@RequestBody String elementList) throws SQLException {

        String result = storeProcAddAdminAccessElementJson.saveAdminAccessToInterface(elementList);
        return result;
    }
}
