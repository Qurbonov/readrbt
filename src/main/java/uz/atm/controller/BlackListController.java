package uz.atm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.dto.blackList.BlackListCreateDto;
import uz.atm.model.BlackList;
import uz.atm.services.blacklist.BlackListService;

import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 15:10
 */
@RestController
@RequestMapping("/v1/atm/black/list")
public class BlackListController {

    private final BlackListService service;

    public BlackListController(BlackListService service) {
        this.service = service;
    }


    @PostMapping("/add")
    public ResponseEntity<Long> add(@RequestBody BlackListCreateDto blackList) {
        Long aLong = service.create(blackList);
        return new ResponseEntity<>(aLong, HttpStatus.CREATED);
    }


    @GetMapping("/remove/{id}")
    public ResponseEntity<?> unblock(@PathVariable Long id) {
        try {
            Long aLong = service.unblock(id);
            return new ResponseEntity<>(aLong, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<BlackList>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }


}
