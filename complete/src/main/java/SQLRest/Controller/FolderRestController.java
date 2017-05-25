package SQLRest.Controller;

import SQLRest.Model.Folder;
import SQLRest.Repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FolderRestController {

    @Autowired
    private FolderRepository folderRepository;

    /*@RequestMapping(value = "/folders", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Folder> getFolders() {
        List<Folder> folderList = folderRepository.findAll();
        return folderList;
    }*/

    /*@RequestMapping(value = "/folders/{rootId}/{typeFolder}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Folder> getFolders(@PathVariable("rootId") Long rootId, @PathVariable("typeFolder") String typeFolder) {
        List<Folder> folderList = folderRepository.findByRootIdAndTypeFolderOrderByName(rootId, typeFolder);
        return folderList;
    }*/

    @RequestMapping(value = "/folders", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Folder> getFolders(@RequestParam("rootId") Long rootId, @RequestParam("typeFolder") String typeFolder) {
        List<Folder> folderList = folderRepository.findByRootIdAndTypeFolderOrderByName(rootId, typeFolder);
        return folderList;
    }

    @RequestMapping(value = "/folder", method = RequestMethod.GET, headers = "Accept=application/json")
    public Folder getFolder(@RequestParam("id") Long id) {
        Folder folder = folderRepository.findById(id);
        return folder;
    }
    /*@RequestMapping(value = "/folders/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Folder getFolder(@PathVariable("id") Long id) {
        Folder folder = folderRepository.findById(id);
        return folder;
    }*/
}
