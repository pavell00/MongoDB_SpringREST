package SQLRest.Controller;

import SQLRest.Model.sp_Folder;
import SQLRest.Repository.StoreProcFolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StoredProcRestController {

    @Autowired
    private StoreProcFolderRepository storeProcFolderRepository;

    @RequestMapping(value = "/sp_folders", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<sp_Folder> getFolders(@RequestParam("rootId") Long rootId, @RequestParam("typeFolder") String typeFolder) {
        List<sp_Folder> folderList = storeProcFolderRepository.findByRootIdAndTypeFolderOrderByName(rootId, typeFolder);
        return folderList;
    }
}
