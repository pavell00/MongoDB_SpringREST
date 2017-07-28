package SQLRest.Controller;

import SQLRest.Model.Binder;
import SQLRest.Repository.StoredProcedure.StoreProcBinderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spBinderRestController {

    @Autowired
    private StoreProcBinderRepository storeProcBinderRepository;

    @RequestMapping(value = "/sp_search_binders", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Binder> getBinders(@RequestParam("bindername") String criteria){
        List<Binder> binderList = storeProcBinderRepository.getBinders_sp(criteria);
        return binderList;
    }
}
