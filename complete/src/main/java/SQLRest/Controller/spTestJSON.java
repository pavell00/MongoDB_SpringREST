package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spTestJSON {
    @Autowired
    StoreProcTest storeProcTest;

    @RequestMapping(value = "/sp_testjson", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTest() throws SQLException {

        String result = storeProcTest.getTest_sp();
        return result;
    }
}
