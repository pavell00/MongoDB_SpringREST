package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.Binder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcBinderRepository {
    List<Binder> getBinders_sp(String name);
}
