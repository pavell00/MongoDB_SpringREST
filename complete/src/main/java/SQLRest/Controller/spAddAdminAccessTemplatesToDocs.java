package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcAddAdminAccessTemplatesJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spAddAdminAccessTemplatesToDocs {
    @Autowired
    StoreProcAddAdminAccessTemplatesJsonImpl storeProcAddAdminAccessTemplatesJson;

    @RequestMapping(value = "/sp_tmlsaccess", method = RequestMethod.POST, headers = "Accept=application/json")
    public String getTmplatesJSON(@RequestBody String tmls) throws SQLException {

        String result = storeProcAddAdminAccessTemplatesJson.saveAdminAccessToDocs(tmls);
        return result;
    }
}
