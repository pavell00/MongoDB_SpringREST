package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.Journal;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProcJournalRepository {

    List <Journal> getJournals_sp(Long docid);
}
