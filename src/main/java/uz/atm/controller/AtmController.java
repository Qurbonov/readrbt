package uz.atm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.ResultatCollectedDto;
import uz.atm.dto.ResultatDto;
import uz.atm.services.methodServices.ResultatService;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
            @RequestParam(name = "lotId") Optional<Long> lotId,
            @RequestParam(name = "state") Optional<Integer> state,
            @RequestParam(name = "organName") Optional<String> organName,
            @RequestParam(name = "maloy") Optional<String> maloy,
            @RequestParam(name = "summaFrom") Optional<Long> summaFrom,
            @RequestParam(name = "summaTo") Optional<Long> summaTo,
            @RequestParam(name = "procId") Optional<Integer> procId,
            @RequestParam(name = "locDate1") Optional<LocalDate> contractDateFrom,
            @RequestParam(name = "locDate2") Optional<LocalDate> contractDateTo

    ) {

        ResultatCriteria resultatCriteria = new ResultatCriteria();
        resultatCriteria.setLotId(lotId.orElse(9223372036854775807L));
        resultatCriteria.setState(state.orElse(2147483647));
        resultatCriteria.setOrganName(organName.orElse("ALL"));
        resultatCriteria.setMaloy(maloy.orElse("ALL"));
        resultatCriteria.setFromDate(contractDateFrom.orElse(LocalDate.of(1970, 1, 1)));
        resultatCriteria.setToDate(contractDateTo.orElse(LocalDate.now().plusYears(1)));
        resultatCriteria.setSummaFrom(summaFrom.orElse(0L));
        resultatCriteria.setSummaTo(summaTo.orElse(999999999999999999L));
        resultatCriteria.setProcId(procId.orElse(2147483647));
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
