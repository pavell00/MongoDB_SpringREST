package SQLRest.Controller;

import SQLRest.Model.PriceLists;
import SQLRest.Repository.StoredProcedure.StoreProcPriceListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class spPriceListsRestController {

    @Autowired
    private StoreProcPriceListsRepository storeProcPriceListsRepository;

    @RequestMapping(value = "/sp_pricelists", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<PriceLists> getPriceLists() {
        List<PriceLists> priceLists = storeProcPriceListsRepository.getPriceLists_sp();
        return priceLists;
    }
}
