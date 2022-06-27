package uz.atm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.ResultatCollectedDto;
import uz.atm.dto.ResultatDto;
import uz.atm.services.methodServices.ResultatService;

import java.time.LocalDate;
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
            @RequestParam(name = "summaTo") Optional<Long> summaTo,
            @RequestParam(name = "locDate1") Optional<LocalDate> locDate1,
            @RequestParam(name = "locDate2") Optional<LocalDate> locDate2

    ) {

        ResultatCriteria resultatCriteria = new ResultatCriteria();
        resultatCriteria.setLotId(lotId.orElse("ALL"));
        resultatCriteria.setState(state.orElse("ALL"));
        resultatCriteria.setOrganName(organName.orElse("ALL"));
        resultatCriteria.setMaloy(maloy.orElse("ALL"));
        resultatCriteria.setLocDate1(locDate1.orElse(LocalDate.of(1970, 1, 1)));
        resultatCriteria.setLocDate2(locDate2.orElse(LocalDate.now().plusYears(1)));
        resultatCriteria.setSummaFrom(summaFrom.orElse(0L));
        resultatCriteria.setSummaTo(summaTo.orElse(999999999999999999L));
        List<ResultatDto> allByCriteria = resultatService.getAllByCriteria(resultatCriteria);
        return new ResponseEntity<>(allByCriteria, HttpStatus.OK);
    }


    @GetMapping("/getResultatById/{id}")
    public ResponseEntity<ResultatCollectedDto> getById(@PathVariable("id") Long id) {
        Optional<ResultatCollectedDto> optional = resultatService.getById(id);
        return optional
                .map(resultatCollectedDto -> new ResponseEntity<>(resultatCollectedDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ResultatCollectedDto(), HttpStatus.NOT_FOUND));
    }


}
