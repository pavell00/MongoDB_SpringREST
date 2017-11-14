package SQLRest.Controller;

import SQLRest.Model.Folder;
import SQLRest.Repository.StoredProcedure.StoreProcFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spFolderRestController {

    @Autowired
    private StoreProcFolderRepository storeProcFolderRepository;

    @RequestMapping(value = "/sp_folders_off", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Folder> getFolders(@RequestParam("rootid") Long rootId,
                                   @RequestParam("typefolder") String typefolder,
                                   @RequestParam("roleid") Long roleid) {
        List<Folder> folderList = storeProcFolderRepository.getFolders_sp(rootId, typefolder, roleid);
        return folderList;
    }
}
