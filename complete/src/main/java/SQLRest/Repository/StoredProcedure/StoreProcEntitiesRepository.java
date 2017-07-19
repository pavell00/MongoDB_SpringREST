package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.Entities;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcEntitiesRepository {

    List<Entities> findByCriteria(String criteria, String valuestr, Long valuelong);

}
