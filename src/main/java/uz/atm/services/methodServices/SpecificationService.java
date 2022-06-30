package uz.atm.services.methodServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.resultat.Specifications;
import uz.atm.repository.SpecificationsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecificationService {

    private final SpecificationsRepository repository;

    public Optional<List<Specifications>> findSpecificationsByResultatId(Long id){
        return repository.findSpecificationsByResultatId(id);
    }

    public Optional<List<Specifications>> findSpecificationsByRequestEtpId(Long id){
        return repository.findSpecificationsByRequestEtpId(id);
    }

    public Optional<List<Specifications>> findSpecificationsByClaimInfoEtpId(Long id){
        return repository.findSpecificationsByClaimInfoEtpId(id);
    }
}
