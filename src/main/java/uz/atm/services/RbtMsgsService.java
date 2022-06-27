package uz.atm.services;

import org.springframework.stereotype.Service;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.repository.RbtMsgsRepository;

import java.util.List;

@Service
public class RbtMsgsService {
	private final RbtMsgsRepository rbtMsgsRepository;

	public RbtMsgsService(final RbtMsgsRepository rbtMsgsRepository)
	{
		this.rbtMsgsRepository = rbtMsgsRepository;
	}

	public Iterable<ResultatMethod> list()
	{
		return this.rbtMsgsRepository.findAll();
	}

	public ResultatMethod save(final ResultatMethod resultatMethod)
	{
		return this.rbtMsgsRepository.save(resultatMethod);
	}

	public void save(final List<ResultatMethod> resultatMethod)
	{
		this.rbtMsgsRepository.saveAll(resultatMethod);
	}

}
