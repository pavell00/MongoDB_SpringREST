package SQLRest.Controller;

import SQLRest.Model.test;
import SQLRest.Repository.StoredProcedureImpl.StoreProcTestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class spTestRestController {

    @Autowired
    private StoreProcTestImpl storeProcTest;

    @RequestMapping(value = "/sp_json", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getFolders() throws SQLException {
        String folders = storeProcTest.getTest_sp();
        return folders;
    }
}
