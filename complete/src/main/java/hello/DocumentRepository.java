package hello;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "documents", path = "documents")
public interface DocumentRepository extends MongoRepository<Documents, String> {

	List<Documents> findByFldId(@Param("fldid") Long fldid);
	Documents findByDocId(@Param("docid") Long docid);
	List<Documents> findByDocName(@Param("docname") String docname);
	List<Documents> findByIsDone(@Param("done") Boolean done);
	List<Documents> findByDateItem(@Param("date") String date);
}