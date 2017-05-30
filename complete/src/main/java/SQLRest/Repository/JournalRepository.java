package SQLRest.Repository;

import SQLRest.Model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    Journal findById(@Param("id") Long id);
    List<Journal> findByDocId(@Param("docid") Long id);
}
