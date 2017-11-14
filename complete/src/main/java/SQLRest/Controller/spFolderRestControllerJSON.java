package SQLRest.Controller;

import SQLRest.Repository.StoredProcedureImpl.StoreProcFolderJsonImpl;
import SQLRest.Repository.StoredProcedureImpl.StoreProcOperationsJsonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@CrossOrigin
public class spFolderRestControllerJSON {

    @Autowired
    StoreProcFolderJsonImpl storeProcFolderJson;

    @RequestMapping(value = "/sp_folders", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getPriceListsJSON(@RequestParam("rootid") Long rootid,
                                    @RequestParam("typefolder") String typefolder,
                                    @RequestParam("roleid") Long roleid) throws SQLException {

        String result = storeProcFolderJson.getFolder_sp(rootid, typefolder, roleid);
        return result;
    }
}
