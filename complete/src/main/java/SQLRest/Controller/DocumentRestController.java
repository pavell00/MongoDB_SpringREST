package SQLRest.Controller;

import SQLRest.Model.Document;
import SQLRest.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DocumentRestController {

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping(value = "/documents", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Document> getDocuments() {
        List<Document> documentList = documentRepository.findAll();
        return documentList;
    }

    @RequestMapping(value = "/documents/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Document getDocument(@PathVariable("id") Long id) {
        Document document = documentRepository.findById(id);
        return document;
    }
}
