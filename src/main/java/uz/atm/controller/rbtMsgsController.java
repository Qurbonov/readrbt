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

    @GetMapping("/create")
    public boolean create() {
        try {
            generalService.parse(str);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }

    static String str = "{\n" +
            "  \"ETP_ID\": 1,\n" +
            "  \"REQUEST_ID\": 1995476,\n" +
            "  \"METHOD_NAME\": \"RESULTAT\",\n" +
            "  \"PAYLOAD\": {\n" +
            "    \"LOTID\": 22110024243812,\n" +
            "    \"PROC_ID\": 19,\n" +
            "    \"GEN_ID\": null,\n" +
            "    \"VERSION\": 22,\n" +
            "    \"LOTDATE1\": null,\n" +
            "    \"LOTDATE2\": null,\n" +
            "    \"CONTRACTNUM\": \"Доп сог №1 дог №14-9313/2180\",\n" +
            "    \"CONTRACTDAT\": \"17062022\",\n" +
            "    \"DVR\": 3,\n" +
            "    \"ORGAN\": \"00640000150\",\n" +
            "    \"INN\": \"201119699\",\n" +
            "    \"LS\": \"100021860352367045300104001\",\n" +
            "    \"VENDORNAME\": \"O`ZBEKTELEKOM  AKSIYADORLIK JAMIYATI\",\n" +
            "    \"VENDORBANK\": \"00401\",\n" +
            "    \"VENDORACC\": \"20210000904074838359\",\n" +
            "    \"VENDORINN\": \"203366731\",\n" +
            "    \"VENDORKLS\": null,\n" +
            "    \"MALOY\": \"Y\",\n" +
            "    \"SUMMA\": 288000000,\n" +
            "    \"AVANS\": 288000000,\n" +
            "    \"AVANSDAY\": 7,\n" +
            "    \"CONTRACTBEG\": \"07032022\",\n" +
            "    \"CONTRACTEND\": \"31122022\",\n" +
            "    \"PURPOSE\": \"УП-3953  пункт,4  с НДС   услуги интернет\",\n" +
            "    \"SROK\": 10,\n" +
            "    \"VENDORTERR\": \"26266\",\n" +
            "    \"LINKS\": null,\n" +
            "    \"FINSRC\": [\n" +
            "      {\n" +
            "        \"NPOS\": 1,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"BANKCODE\": \"00014\",\n" +
            "        \"BANKACC\": \"23402000300100001010\",\n" +
            "        \"SUMMA\": 288000000\n" +
            "      }\n" +
            "    ],\n" +
            "    \"SPECIFICATIONS\": [\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 1,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 1,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 2,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 2,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 3,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 3,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 4,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 4,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 5,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 5,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 6,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 6,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 7,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 7,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 8,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 8,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 9,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 9,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 10,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 10,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 11,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 11,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"NPOS\": 12,\n" +
            "        \"TOVAR\": \"61.10.40.000-00001\",\n" +
            "        \"TOVARNAME\": \"Услуги по доступу к информационно-коммуникационной сети Интернет\",\n" +
            "        \"TOVAREDIZM\": 0,\n" +
            "        \"TOVARAMOUNT\": 1,\n" +
            "        \"TOVARPRICE\": 24000000,\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\",\n" +
            "        \"NOTE\": \"Интернет\",\n" +
            "        \"SPLIT\": [\n" +
            "          {\n" +
            "            \"MONTH\": 12,\n" +
            "            \"TOVARAMOUNT\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"PROPERTIES\": [\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 0,\n" +
            "            \"PROP_NAME\": \"Единица измерения\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"усл. ед\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 1,\n" +
            "            \"PROP_NAME\": \"пропускная способность, Мбит/с\",\n" +
            "            \"VAL_NUMB\": 0,\n" +
            "            \"VAL_NAME\": \"≥ 100000\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"PROP_NUMB\": 2,\n" +
            "            \"PROP_NAME\": \"технологии подключения\",\n" +
            "            \"VAL_NUMB\": 2,\n" +
            "            \"VAL_NAME\": \"WiFi\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ],\n" +
            "    \"GRAFICS\": [\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 1,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 2,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 3,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 4,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 5,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 6,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 7,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 8,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 9,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 10,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 11,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"FINYEAR\": 2022,\n" +
            "        \"MONTH\": 12,\n" +
            "        \"KLS\": \"100021860352367045300104001\",\n" +
            "        \"TOVARSUMMA\": 24000000,\n" +
            "        \"EXPENSE\": \"44292200\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"BENEFICIAR\": \"-\",\n" +
            "    \"RASCHOT\": null,\n" +
            "    \"REESTR_ID\": 22110024617827,\n" +
            "    \"PNFL\": null,\n" +
            "    \"CONTRACT_ID\": 29263391,\n" +
            "    \"SUMNDS\": 37565217\n" +
            "  }\n" +
            "}";
}
