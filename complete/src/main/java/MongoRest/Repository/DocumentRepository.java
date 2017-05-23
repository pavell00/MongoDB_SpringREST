package MongoRest.Repository;

import MongoRest.Model.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "document", path = "document")
public interface DocumentRepository extends MongoRepository<Document, Long> {

	List<Document> findByFldId(@Param("fldid") Long fldid);
	//Document findByDocId(@Param("docid") Long docid);
	Document findById(@Param("id") String id);
	List<Document> findByName(@Param("name") String name);
	List<Document> findByIsDone(@Param("done") Boolean done);
	List<Document> findByDateItem(@Param("date") String date);
}