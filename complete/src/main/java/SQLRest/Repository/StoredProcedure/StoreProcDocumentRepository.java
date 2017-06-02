package SQLRest.Repository.StoredProcedure;

import SQLRest.Model.Document;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StoreProcDocumentRepository {

    List<Document> getDocuments_sp(Long root_id, LocalDate startDate, LocalDate endDate);
}
