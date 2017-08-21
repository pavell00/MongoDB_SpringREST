package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.Agent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcAgentRepository {
    List<Agent> getAgent_sp(String criteria, String valuestr, Long valuelong);
}
