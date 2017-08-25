package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.Template;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcTemplateRepository {
    List<Template> getTemplate_sp(Long tmlid, Long mode);
}
