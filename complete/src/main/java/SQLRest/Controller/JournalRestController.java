package SQLRest.Controller;

import SQLRest.Model.Journal;
import SQLRest.Repository.Jpa.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JournalRestController {

    @Autowired
    private JournalRepository journalRepository;

    @RequestMapping(value = "/journals", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Journal> getJournals(@RequestParam("docid") Long doc_id) {
        List<Journal> journalList = journalRepository.findByDocId(doc_id);
        return journalList;
    }

    @RequestMapping(value = "/journal", method = RequestMethod.GET, headers = "Accept=application/json")
    public Journal getJournal(@RequestParam("id") Long id) {
        Journal journal = journalRepository.findById(id);
        return journal;
    }
}
