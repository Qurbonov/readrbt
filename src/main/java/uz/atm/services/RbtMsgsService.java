package uz.atm.services;

import org.springframework.stereotype.Service;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.repository.RbtMsgsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RbtMsgsService {
    private final RbtMsgsRepository rbtMsgsRepository;

    public RbtMsgsService(final RbtMsgsRepository rbtMsgsRepository) {
        this.rbtMsgsRepository = rbtMsgsRepository;
    }

    public Iterable<ResultatMethod> list() {
        return this.rbtMsgsRepository.findAll();
    }

    public ResultatMethod save(final ResultatMethod user) {
        return this.rbtMsgsRepository.save(user);
    }

    public void save(final List<ResultatMethod> users) {
        this.rbtMsgsRepository.saveAll(users);
    }


    public void save(ArrayList<String> msgFromRbt) {
    }

    public void save(String toString) {
    }


}
