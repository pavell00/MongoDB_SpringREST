package SQLRest.Controller;

import SQLRest.Model.Journal;
import SQLRest.Repository.StoredProcedure.StoreProcJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spJournalRestController {

    @Autowired
    StoreProcJournalRepository storeProcJournalRepository;

    @RequestMapping(value = "/sp_journals", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Journal> getFolders(@RequestParam("docid") Long docId) {
        List<Journal> journalList = storeProcJournalRepository.getJournals_sp(docId);
        return journalList;
    }
}
