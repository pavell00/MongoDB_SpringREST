package SQLRest.Repository;

import SQLRest.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "documents", path = "documents")
public interface DocumentRepository extends JpaRepository<Document, Long> {

	Document findById(@Param("doc_id") Long doc_id);
	List<Document> findByDocName(@Param("doc_name") String doc_name);
	List<Document> findByDocDate(@Param("doc_date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate doc_date);
}