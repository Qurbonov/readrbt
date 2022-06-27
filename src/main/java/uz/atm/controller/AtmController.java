package uz.atm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.ResultatDto;
import uz.atm.services.methodServices.ResultatService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */

@RestController
@RequestMapping("/v1/atm")
public class AtmController {

    private final ResultatService resultatService;

    public AtmController(ResultatService resultatService) {
        this.resultatService = resultatService;
    }


    @GetMapping("/getResultats")
    public ResponseEntity<List<ResultatDto>> getAll(
            @RequestParam(name = "lotId") Optional<String> lotId,
            @RequestParam(name = "state") Optional<String> state,
            @RequestParam(name = "organName") Optional<String> organName,
            @RequestParam(name = "maloy") Optional<String> maloy,
            @RequestParam(name = "summaFrom") Optional<Long> summaFrom,
            @RequestParam(name = "summaTo") Optional<Long> summaTo

    ) {

        ResultatCriteria resultatCriteria = new ResultatCriteria();
        resultatCriteria.setLotId(lotId.orElse("ALL"));
        resultatCriteria.setState(state.orElse("ALL"));
        resultatCriteria.setOrganName(organName.orElse("ALL"));
        resultatCriteria.setMaloy(maloy.orElse("ALL"));
        resultatCriteria.setSummaFrom(summaFrom.orElse(0L));
        resultatCriteria.setSummaTo(summaTo.orElse(999999999999999999L));
        List<ResultatDto> allByCriteria = resultatService.getAllByCriteria(resultatCriteria);
        return new ResponseEntity<>(allByCriteria, HttpStatus.OK);
    }


}
