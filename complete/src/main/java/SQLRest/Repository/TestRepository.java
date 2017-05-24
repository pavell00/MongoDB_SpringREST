package SQLRest.Repository;

import SQLRest.Model.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "test", path = "test")
public interface TestRepository extends JpaRepository<test, Long> {

	test findById(@Param("id") Long id);
}