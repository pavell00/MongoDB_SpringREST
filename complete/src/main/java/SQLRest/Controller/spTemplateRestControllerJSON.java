package SQLRest.Controller;

import SQLRest.Model.Template;
import SQLRest.Repository.StoredProcedureImpl.StoreProcTemplateJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class spTemplateRestControllerJSON {

    @Autowired
    StoreProcTemplateJsonImpl storeProcTemplateJson;

    @RequestMapping(value = "/sp_template", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTemplatesJSON(@RequestParam("tmlid") Long tmlId, @RequestParam("mode") Long mode) throws SQLException {
        String result = storeProcTemplateJson.getTemplate_sp(tmlId, mode);
        return result;
    }
}
