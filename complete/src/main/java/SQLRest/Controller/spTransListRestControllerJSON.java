package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcTransListRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spTransListRestControllerJSON {

    @Autowired
    StoreProcTransListRepositoryImpl storeProcTransListRepository;

    @RequestMapping(value = "/sp_translist", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTransList(@RequestParam("docid") Long docId) throws SQLException {
        String result = storeProcTransListRepository.getTransList_sp(docId);
        return result;
    }
}
