package SQLRest.Controller;

import SQLRest.Model.Document;
import SQLRest.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class DocumentRestController {

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value = "/documents", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Document> getDocuments(@RequestParam("docdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate doc_date,
                                       @RequestParam("fldid") Long fld_id) {
        List<Document> documentList = documentRepository.findByDocDateAndFldId(doc_date, fld_id);
        return documentList;
    }

    @RequestMapping(value = "/document", method = RequestMethod.GET, headers = "Accept=application/json")
    public Document getDocument(@RequestParam("id") Long id) {
        Document document = documentRepository.findById(id);
        return document;
    }
}
