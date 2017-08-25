package SQLRest.Controller;

import SQLRest.Model.Template;
import SQLRest.Repository.StoredProcedure.StoreProcTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spTemplateRestController {

    @Autowired
    private StoreProcTemplateRepository storeProcTemplateRepository;

    @RequestMapping(value = "/sp_template", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Template> getFolders(@RequestParam("tmlid") Long tmlId, @RequestParam("mode") Long mode) {
        List<Template> folderList = storeProcTemplateRepository.getTemplate_sp(tmlId, mode);
        return folderList;
    }
}
