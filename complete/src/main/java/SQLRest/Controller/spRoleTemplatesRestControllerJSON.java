package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcRoleTemplatesJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spRoleTemplatesRestControllerJSON {
    @Autowired
    StoreProcRoleTemplatesJsonImpl storeProcRoleTemplatesJson;

    @RequestMapping(value = "/sp_roletemplates", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getRoleTemplatesJSON(@RequestParam("roleid") Long roleid) throws SQLException {

        String result = storeProcRoleTemplatesJson.getRoleTemplates_sp(roleid);
        return result;
    }
}
