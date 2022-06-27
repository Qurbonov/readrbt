package uz.atm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.services.GeneralService;
import uz.atm.services.RbtMsgsService;

@RestController
@RequestMapping("/rbtmsgs")
public class rbtMsgsController {
    private final RbtMsgsService rbtMsgsService;
    private final GeneralService generalService;

    public rbtMsgsController(final RbtMsgsService rbtMsgsService, GeneralService generalService) {
        this.rbtMsgsService = rbtMsgsService;
        this.generalService = generalService;
    }

    @GetMapping("/list")
    public Iterable<ResultatMethod> list() {
        return this.rbtMsgsService.list();
    }

}
