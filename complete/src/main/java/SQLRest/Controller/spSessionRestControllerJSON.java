package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcSessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spSessionRestControllerJSON {
        @Autowired
        StoreProcSessionImpl storeProcSession;

    @RequestMapping(value = "/sp_session", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getSession(@RequestParam("nickname") String nickname) throws SQLException {
        String result = storeProcSession.getSession_sp(nickname);
        return result;
    }
}
