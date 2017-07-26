package SQLRest.Controller;

import SQLRest.Model.OneField;
import SQLRest.Repository.StoredProcedureImpl.StoreProcOneFieldRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spOneFieldRestController {

    @Autowired
    StoreProcOneFieldRepositoryImpl storeProcOneFieldRepository;

    @RequestMapping(value = "/sp_findentnom", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<OneField> getFields(@RequestParam("nom") String nomnumber) {
        List<OneField> journalList = storeProcOneFieldRepository.getEntNom(nomnumber);
        return journalList;
    }
}