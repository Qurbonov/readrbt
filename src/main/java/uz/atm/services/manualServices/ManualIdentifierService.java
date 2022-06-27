package uz.atm.services.manualServices;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.model.manuals.ManualIdentifier;
import uz.atm.model.manuals.ManualValues;


import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ManualIdentifierService {
    private final ManAccountsService manAccountsService;
    private final ManExpGoodsService manExpGoodsService;
    private final ManOrganizationsService manOrganizationsService;
    private final SingleVendorService singleVendorService;
    private final SingleVendorEnktService singleVendorEnktService;

    public void saveManualAccordingToType(String json) throws JsonProcessingException {
        ManualIdentifier manualIdentifier =new Gson().fromJson(json, ManualIdentifier.class);
        if (Objects.nonNull(manualIdentifier.getTYPE())) {
            String type = manualIdentifier.getTYPE();
            switch (type) {
                  case (ManualValues.MAN_ACCOUNTS) -> {
                    manAccountsService.save(json);
                } case (ManualValues.MAN_EXPGOODS) -> {
                    manExpGoodsService.save(json);
                } case (ManualValues.MAN_ORGANIZATIONS) -> {
                    manOrganizationsService.save(json);
                } case (ManualValues.SINGLEVENDOR) -> {
                    singleVendorService.save(json);
                } case (ManualValues.SINGLEVENDOR_ENKT) -> {
                    singleVendorEnktService.save(json);
                }
                }
            }
        }
    }

