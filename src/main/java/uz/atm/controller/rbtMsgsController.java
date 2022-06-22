package uz.atm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.atm.model.ResultatMethod;
import uz.atm.services.RbtMsgsService;

@RestController
@RequestMapping("/rbtmsgs")
public class rbtMsgsController {
	private final RbtMsgsService rbtMsgsService;

	public rbtMsgsController(final RbtMsgsService rbtMsgsService)
	{
		this.rbtMsgsService = rbtMsgsService;
	}

	@GetMapping("/list")
	public Iterable<ResultatMethod> list()
	{
		return this.rbtMsgsService.list();
	}
}
