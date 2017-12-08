package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcRefreshListTemplates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spRefreshListTmlRestControllerJSON {
    @Autowired
    StoreProcRefreshListTemplates storeProcRefreshListTemplates;

    @RequestMapping(value = "/sp_roottmls", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getRoleTemplatesJSON(@RequestParam("rootitems") String rootitems,
                                       @RequestParam("roleid") String roleid) throws SQLException {

        String result = storeProcRefreshListTemplates.getTemplateList_sp(rootitems, roleid);
        return result;
    }
}
