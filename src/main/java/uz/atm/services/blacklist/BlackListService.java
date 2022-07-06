package uz.atm.services.blacklist;

import org.springframework.stereotype.Service;
import uz.atm.dto.blackList.BlackListCreateDto;
import uz.atm.enums.BlackListStatus;
import uz.atm.mapper.blackList.BlackListMapper;
import uz.atm.model.BlackList;
import uz.atm.model.action.Actions;
import uz.atm.repository.BlackListRepository;
import uz.atm.services.AbstractService;
import uz.atm.utils.SessionUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 14:50
 */
@Service
public class BlackListService extends AbstractService<BlackListRepository> {

    private final ActionService actionService;
    private final SessionUtils sessionUtils;
    private final BlackListMapper blackListMapper;


    public BlackListService(BlackListRepository repository, ActionService actionService, SessionUtils sessionUtils, BlackListMapper blackListMapper) {
        super(repository);
        this.actionService = actionService;
        this.sessionUtils = sessionUtils;
        this.blackListMapper = blackListMapper;
    }

    public List<BlackList> getAll() {
        return repository.findAllByStatus(BlackListStatus.BLOCK.getCode());
    }


    public Long create(BlackListCreateDto list) {
        BlackList blackList = blackListMapper.fromCreateDto(list);
        blackList.setStatus(BlackListStatus.BLOCK.getCode());
        blackList.setDateBegin(new Date());
        BlackList save = repository.save(blackList);
        Actions actions = new Actions(save + "=>Org added to black list ", sessionUtils.getSessionId());
        actionService.create(actions);
        return save.getId();
    }

    public Long unblock(Long id) {
        Optional<BlackList> byId = repository.findById(id);
        if (byId.isPresent()) {
            BlackList blackList = byId.get();
            blackList.setStatus(BlackListStatus.UNBLOCK.getCode());
            BlackList save = repository.save(blackList);
            Actions actions = new Actions(save + "=>Org added to black list ", sessionUtils.getSessionId());
            actionService.create(actions);
            return id;
        } else throw new RuntimeException("Organization not found with id : " + id);
    }

}
