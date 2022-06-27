package uz.atm.controller.manualController;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.atm.services.manualServices.ManualIdentifierService;

@RestController
@RequestMapping("api/manuals")
@RequiredArgsConstructor
public class TempController {
    private final ManualIdentifierService service;

    @GetMapping("/save")
    public void saveJsonToDB(){
        try {
            service.saveManualAccordingToType(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    String json = "{\n" +
            "  \"DIGEST_ID\": 3021519,\n" +
            "  \"TYPE\": \"SINGLEVENDOR_ENKT\",\n" +
            "  \"PAYLOAD\": {\n" +
            "    \"ID\": \"E18EA212593B18C8E0530100007F2481\",\n" +
            "    \"PAGENUM\": 1,\n" +
            "    \"PAGECNT\": 1,\n" +
            "    \"DATA\": [\n" +
            "      {\n" +
            "        \"CHANGE\": \"I\",\n" +
            "        \"INN\": \"205011222\",\n" +
            "        \"ENKT\": \"29.32.30.179-00004\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"16062022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"U\",\n" +
            "        \"INN\": \"206825276\",\n" +
            "        \"ENKT\": \"82.19.13.000-00003\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"31052022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"U\",\n" +
            "        \"INN\": \"206825276\",\n" +
            "        \"ENKT\": \"85.41.99.000-00001\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"31052022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"I\",\n" +
            "        \"INN\": \"206825276\",\n" +
            "        \"ENKT\": \"91.01.12.000-00002\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"16062022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"U\",\n" +
            "        \"INN\": \"206825276\",\n" +
            "        \"ENKT\": \"91.01.12.000-00008\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"31052022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"U\",\n" +
            "        \"INN\": \"207162524\",\n" +
            "        \"ENKT\": \"29.32.30.179-00004\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"14062022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"I\",\n" +
            "        \"INN\": \"207162524\",\n" +
            "        \"ENKT\": \"43.99.70.000-00001\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"16062022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"I\",\n" +
            "        \"INN\": \"207162524\",\n" +
            "        \"ENKT\": \"43.99.70.000-00002\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"16062022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"CHANGE\": \"I\",\n" +
            "        \"INN\": \"207162524\",\n" +
            "        \"ENKT\": \"43.99.70.000-00004\",\n" +
            "        \"STATE\": \"A\",\n" +
            "        \"DATEOPEN\": \"16062022\",\n" +
            "        \"DATECLOSE\": \"\",\n" +
            "        \"DATECHANGE\": \"16062022\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

}
