package uz.atm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.atm.dto.ResultatDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */

@RestController
@RequestMapping("/v1/atm")
public class AtmController {


    @GetMapping("/getResultats")
    public ResponseEntity<List<ResultatDto>> getAll() {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

}
