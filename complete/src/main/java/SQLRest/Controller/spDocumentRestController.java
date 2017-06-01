package SQLRest.Controller;

import SQLRest.Model.Document;
import SQLRest.Repository.StoredProcedure.StoreProcDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class spDocumentRestController {

    @Autowired
    StoreProcDocumentsRepository storeProcDocumentsRepository;

    @RequestMapping(value = "/sp_documents", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Document> getDocuments(@RequestParam("rootid") Long rootId,
                                     @RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startdate,
                                     @RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate enddate){
        List<Document> documentList = storeProcDocumentsRepository.getDocuments_sp(rootId, startdate, enddate);
        return documentList;
    }
}
