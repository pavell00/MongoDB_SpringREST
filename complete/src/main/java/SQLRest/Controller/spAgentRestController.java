package SQLRest.Controller;

import SQLRest.Model.Agent;
import SQLRest.Repository.StoredProcedure.StoreProcAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spAgentRestController {

    @Autowired
    private StoreProcAgentRepository storeProcAgentRepository;

    @RequestMapping(value = "/sp_findagent", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Agent> getAgents (@RequestParam("criteria") String criteria,
                                  @RequestParam("valuestr") String valuestr,
                                  @RequestParam("valuelong") Long valuelong){
        List<Agent> agentList = storeProcAgentRepository.getAgent_sp(criteria, valuestr, valuelong);
        return agentList;
    }
}
