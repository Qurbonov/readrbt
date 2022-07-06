package uz.atm.services.blacklist;

import org.springframework.stereotype.Service;
import uz.atm.model.action.Actions;
import uz.atm.repository.ActionRepository;
import uz.atm.services.AbstractService;

import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 14:59
 */
@Service
public class ActionService extends AbstractService<ActionRepository> {

    public ActionService(ActionRepository repository) {
        super(repository);
    }

    public Long create(Actions action) {
        return repository.save(action).getId();
    }

    public List<Actions> getAll() {
        return repository.findAll();
    }

}
