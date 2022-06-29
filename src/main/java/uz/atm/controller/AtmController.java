package uz.atm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.criteria.RequestEtpCriteria;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.RequestEtpDto;
import uz.atm.dto.ResultatCollectedDto;
import uz.atm.dto.ResultatDto;
import uz.atm.enums.Pltf;
import uz.atm.services.methodServices.RequestEtpService;
import uz.atm.services.methodServices.ResultatService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/atm")
@RequiredArgsConstructor
public class AtmController {

    private final ResultatService resultatService;
    private final RequestEtpService requestEtpService;



    @GetMapping("/getResultats")
    public ResponseEntity<List<ResultatDto>> getAllResultats(
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


    @GetMapping("/getAuctions")
    public ResponseEntity<List<RequestEtpDto>> getAllAuctions(
            @RequestParam(name = "lotId") Optional<Long> lotId,
            @RequestParam(name = "docDateFrom") Optional<Date> docDateFrom,
            @RequestParam(name = "docDateTo") Optional<Date> docDateTo,
            @RequestParam(name = "organName") Optional<String> organName,
            @RequestParam(name = "sumLotFrom") Optional<Long> sumLotFrom,
            @RequestParam(name = "sumLotTo") Optional<Long> sumLotTo,
            @RequestParam(name = "month") Optional<Integer> month,
            @RequestParam(name = "state") Optional<Integer> state

    ) {

        RequestEtpCriteria requestEtpCriteria = new RequestEtpCriteria();
        requestEtpCriteria.setLotId(lotId.orElse(9223372036854775807L));
        requestEtpCriteria.setDocDateFrom(docDateFrom.orElse(new Date(0)));
        requestEtpCriteria.setDocDateTo(docDateTo.orElse(new Date()));
        requestEtpCriteria.setOrganName(organName.orElse("ALL"));
        requestEtpCriteria.setSumLotFrom(sumLotFrom.orElse(0L));
        requestEtpCriteria.setSumLotTo(sumLotTo.orElse(999999999999999999L));
        requestEtpCriteria.setMonth(month.orElse(2147483647));
        requestEtpCriteria.setState(state.orElse(2147483647));
        requestEtpCriteria.setPltf(Pltf.E_MAGAZIN.getCode());
        List<RequestEtpDto> allByCriteria = requestEtpService.getAllAuctionsByCriteria(requestEtpCriteria);
        return new ResponseEntity<>(allByCriteria, HttpStatus.OK);
    }


}
