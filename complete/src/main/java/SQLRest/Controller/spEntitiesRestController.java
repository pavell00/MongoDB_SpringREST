package SQLRest.Controller;

import SQLRest.Model.Entities;
import SQLRest.Repository.StoredProcedure.StoreProcEntitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spEntitiesRestController {

    @Autowired
    private StoreProcEntitiesRepository storeProcEntitiesRepository;

    @RequestMapping(value = "/sp_findentities", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Entities> getDocuments(@RequestParam("criteria") String criteria,
                                       @RequestParam("valuestr") String valuestr,
                                       @RequestParam("valuelong") Long valuelong){
        List<Entities> entitiesList = storeProcEntitiesRepository.findByCriteria(criteria, valuestr, valuelong);
        return entitiesList;
    }
}
