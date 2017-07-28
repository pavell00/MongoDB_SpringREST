package SQLRest.Controller.old;

import SQLRest.Repository.StoredProcedureImpl.old.StoreProcTestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spTestRestController {

    @Autowired
    private StoreProcTestImpl storeProcTest;

    @RequestMapping(value = "/sp_search_pricelists00", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getFolders() throws SQLException {
        String folders = storeProcTest.getTest_sp();
        return folders;
    }
}
