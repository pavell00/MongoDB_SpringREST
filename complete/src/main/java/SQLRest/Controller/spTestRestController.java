package SQLRest.Controller;

import SQLRest.Model.test;
import SQLRest.Repository.StoredProcedureImpl.StoreProcTestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spTestRestController {

    @Autowired
    private StoreProcTestImpl storeProcTest;

    @RequestMapping(value = "/sp_foldersjson", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getFolders(@RequestParam("rootid") Long rootId, @RequestParam("typefolder") String typeFolder) {
        String folders = storeProcTest.getTest_sp(rootId, typeFolder);
        return folders;
    }
}
