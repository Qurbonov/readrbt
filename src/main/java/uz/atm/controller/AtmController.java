package uz.atm.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.criteria.ClaimInfoCriteria;
import uz.atm.criteria.RequestEtpCriteria;
import uz.atm.criteria.ResultatCriteria;
import uz.atm.dto.*;
import uz.atm.enums.Pltf;
import uz.atm.enums.ProcId;
import uz.atm.services.methodServices.ClaimInfoEtpService;
import uz.atm.services.methodServices.RequestEtpService;
import uz.atm.services.methodServices.ResultatService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */

@RestController
@RequestMapping("/v1/atm")
@RequiredArgsConstructor
public class AtmController {

    private final ResultatService resultatService;
    private final RequestEtpService requestEtpService;
    private final ClaimInfoEtpService claimInfoEtpService;


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
        requestEtpCriteria.setPltf(Pltf.AUKSION.getCode());
        List<RequestEtpDto> allByCriteria = requestEtpService.getAllAuctionsByCriteria(requestEtpCriteria);
        return new ResponseEntity<>(allByCriteria, HttpStatus.OK);
    }


    @GetMapping("/getEMagazins")
    public ResponseEntity<List<RequestEtpDto>> getAllEMagazins(
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


    @GetMapping("/getAuksionOrEMagazinById/{id}")
    public ResponseEntity<RequestEtpCollectedDto> getAuksionOrEMagazinById(@PathVariable("id") Long id) {
        Optional<RequestEtpCollectedDto> optional = requestEtpService.getById(id);
        return optional
                .map(resultatCollectedDto -> new ResponseEntity<>(resultatCollectedDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new RequestEtpCollectedDto(), HttpStatus.NOT_FOUND));
    }


    @GetMapping("/getAllTenders")
    public ResponseEntity<List<ClaimInfoEtpDto>> getAllTenders(
            @RequestParam(name = "lotId") Optional<Long> lotId,
            @RequestParam(name = "organName") Optional<String> organName,
            @RequestParam(name = "summaFrom") Optional<Long> summaFrom,
            @RequestParam(name = "summTo") Optional<Long> summaTo,
            @RequestParam(name = "srok") Optional<Integer> srok,
            @RequestParam(name = "state") Optional<Integer> state
    ) {
        ClaimInfoCriteria claimInfoCriteria = new ClaimInfoCriteria();
        claimInfoCriteria.setLotId(lotId.orElse(9223372036854775807L));
        claimInfoCriteria.setOrganName(organName.orElse("ALL"));
        claimInfoCriteria.setSummaFrom(summaFrom.orElse(9223372036854775807L));
        claimInfoCriteria.setSummaTo(summaTo.orElse(9223372036854775807L));
        claimInfoCriteria.setSrok(srok.orElse(2147483647));
        claimInfoCriteria.setState(state.orElse(2147483647));
        claimInfoCriteria.setProdId(ProcId.TENDER.getCode());

        Optional<List<ClaimInfoEtpDto>> claimInfoEtpDto = claimInfoEtpService.getByCriteria(claimInfoCriteria);

        return claimInfoEtpDto
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllKonkurs")
    public ResponseEntity<List<ClaimInfoEtpDto>> getAllKonkurs(
            @RequestParam(name = "lotId") Optional<Long> lotId,
            @RequestParam(name = "organName") Optional<String> organName,
            @RequestParam(name = "summaFrom") Optional<Long> summaFrom,
            @RequestParam(name = "summTo") Optional<Long> summaTo,
            @RequestParam(name = "srok") Optional<Integer> srok,
            @RequestParam(name = "state") Optional<Integer> state
    ) {
        ClaimInfoCriteria claimInfoCriteria = new ClaimInfoCriteria();
        claimInfoCriteria.setLotId(lotId.orElse(9223372036854775807L));
        claimInfoCriteria.setOrganName(organName.orElse("ALL"));
        claimInfoCriteria.setSummaFrom(summaFrom.orElse(9223372036854775807L));
        claimInfoCriteria.setSummaTo(summaTo.orElse(9223372036854775807L));
        claimInfoCriteria.setSrok(srok.orElse(2147483647));
        claimInfoCriteria.setState(state.orElse(2147483647));
        claimInfoCriteria.setProdId(ProcId.KONKURS.getCode());


        Optional<List<ClaimInfoEtpDto>> claimInfoEtpDto = claimInfoEtpService.getByCriteria(claimInfoCriteria);

        return claimInfoEtpDto
                .map(m -> new ResponseEntity<>(m, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND));
    }

}
