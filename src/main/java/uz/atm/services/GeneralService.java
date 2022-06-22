package uz.atm.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import uz.atm.enums.Methods;
import uz.atm.model.General;
import uz.atm.model.resultat.ResultatMethod;
import uz.atm.repository.ResultatMethodRepository;

@Service
public class GeneralService {
    private final ObjectMapper mapper = new ObjectMapper();
    private final ResultatMethodRepository resultatMethodRepository;

    public GeneralService(ResultatMethodRepository resultatMethodRepository) {
        this.resultatMethodRepository = resultatMethodRepository;
    }

    public void parse(String str) throws JsonProcessingException {
        General general = new Gson().fromJson(str, General.class);

        String methodName = general.getMETHOD_NAME();

        if (methodName.equals(Methods.RESULTAT.toString())) {
            this.resultatMethod(str);
        }
    }

    private void resultatMethod(String json) throws JsonProcessingException {
        ResultatMethod resultatMethod = mapper.readValue(json, new TypeReference<ResultatMethod>() {
        });
        ResultatMethod save = resultatMethodRepository.save(resultatMethod);
    }
}