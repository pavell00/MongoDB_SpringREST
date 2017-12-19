package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcDocumentsJsonImpl;
import SQLRest.Repository.StoredProcedureImpl.StoreProcFolderJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Logger;

@RestController
@CrossOrigin
public class spDocumentRestControllerJSON {

    @Autowired
    StoreProcDocumentsJsonImpl storeProcDocumentsJson;

    @RequestMapping(value = "/sp_documents", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getDocuments(@RequestParam("rootid") Long rootId,
                               @RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startdate,
                               @RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate enddate,
                               @RequestParam("typedir") String typedir,
                               @RequestParam("roleid") Long roleid) throws SQLException {

        String result = storeProcDocumentsJson.getDocument_sp(rootId, startdate,
                enddate, typedir, roleid);
        return result;
    }
}
